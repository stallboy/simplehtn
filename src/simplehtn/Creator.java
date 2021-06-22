package simplehtn;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static simplehtn.JSHOP2Parser.*;

public class Creator {
    private final ShopContext shopCtx;
    private final CreateArgs createArgs;

    private final PdeVisitor pdeVisitor = new PdeVisitor();
    private final TermVisitor termVisitor = new TermVisitor();
    private final LatomVisitor latomVisitor = new LatomVisitor();
    private final LatomlistVisitor latomlistVisitor = new LatomlistVisitor();
    private final LexpVisitor lexpVisitor = new LexpVisitor();
    private final LprecondVisitor lprecondVisitor = new LprecondVisitor();
    private final TasklistVisitor tasklistVisitor = new TasklistVisitor();
    private final TasklistsubVisitor tasklistsubVisitor = new TasklistsubVisitor();
    private final DeladdVisitor deladdVisitor = new DeladdVisitor();
    private final DeladdeleVisitor deladdeleVisitor = new DeladdeleVisitor();

    private boolean isDomain;
    private Domain domain;
    private Set<String> curPdeVars;
    private DomainElement curDomainEle;
    private Problem problem;

    public static Creator createFromFile(String fileName, CreateArgs args) throws IOException {
        return createFromStream(CharStreams.fromFileName(fileName, StandardCharsets.UTF_8), args);
    }

    public static Creator createFromStream(CharStream stream, CreateArgs args) {
        JSHOP2Lexer lexer = new JSHOP2Lexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        JSHOP2Parser parser = new JSHOP2Parser(tokens);
        ShopContext ctx = parser.shop();
        return new Creator(ctx, args);
    }

    public Creator(ShopContext shopCtx, CreateArgs args) {
        this.shopCtx = shopCtx;
        this.createArgs = args;
        convert();
    }

    public boolean isDomain() {
        return isDomain;
    }

    public Domain getDomain() {
        return domain;
    }

    public Problem getProblem() {
        return problem;
    }

    //------------------------------- domain/problem 转换为领域或问题对象 ------------------------------

    private void convert() {
        SymbolCollector col = new SymbolCollector(shopCtx);
        col.walk();

        isDomain = col.isDomain;
        if (isDomain) {
            domain = new Domain(col.domainCtx.ID().getText(),
                                col.primitives,
                                col.compounds,
                                col.axiomConstants,
                                col.constants
            );

            for (Map.Entry<PdeContext, Set<String>> entry : col.pdeVarSymbols.entrySet()) {
                curPdeVars = entry.getValue();
                pdeVisitor.visit(entry.getKey());
            }

        } else {
            Domain dom = createArgs.assureGetKnownDomain(col.problemCtx.dn.getText());
            problem = new Problem(col.problemCtx.pn.getText(),
                                  dom,
                                  col.constants,
                                  col.currentVars
            );

            problem.state = predicateList(col.problemCtx.state);
            problem.taskList = taskList(col.problemCtx.tl);
        }
    }

    private class PdeVisitor extends JSHOP2BaseVisitor<Void> {

        @Override
        public Void visitOperator(OperatorContext ctx) {
            Operator op = new Operator(domain, curPdeVars);
            curDomainEle = op;

            op.head = Predicate.ofPrimitiveTask(op, ctx.OPID().getText(), new TermList(tList(ctx.terml())));

            op.pre = precondition(ctx.pre);
            op.del = delAdd(ctx.del);
            op.add = delAdd(ctx.add);
            Term cost = new TermNumber(1);
            if (ctx.cost != null) {
                cost = term(ctx.cost);
            }
            op.cost = cost;

            domain.addOperator(op);
            return null;
        }


        @Override
        public Void visitMethod(MethodContext ctx) {
            Method me = new Method(domain, curPdeVars);
            curDomainEle = me;

            me.head = Predicate.ofCompoundTask(me, ctx.ID().getText(), new TermList(tList(ctx.terml())));

            List<MethodsubContext> methodSubs = ctx.methodsub();
            me.subs = new Method.MethodSub[methodSubs.size()];

            int i = 0;
            for (MethodsubContext subCtx : methodSubs) {
                Method.MethodSub sub = new Method.MethodSub();
                TerminalNode id = subCtx.ID();
                if (id != null) {
                    sub.label = id.getText();
                } else {
                    sub.label = me.head.getName() + "_" + i;
                }

                sub.pre = precondition(subCtx.pre);
                sub.tasklist = taskList(subCtx.tl);
                me.subs[i] = sub;
                i++;
            }

            domain.addMethod(me);
            return null;
        }


        @Override
        public Void visitAxiom(AxiomContext ctx) {
            Axiom ax = new Axiom(domain, curPdeVars);
            curDomainEle = ax;

            ax.head = Predicate.of(ax, ctx.ID().getText(), new TermList(tList(ctx.terml())));

            List<AxiomsubContext> axiomSubs = ctx.axiomsub();
            ax.subs = new Axiom.AxiomSub[axiomSubs.size()];

            int i = 0;
            for (AxiomsubContext subCtx : axiomSubs) {
                Axiom.AxiomSub sub = new Axiom.AxiomSub();
                TerminalNode id = subCtx.ID();
                if (id != null) {
                    sub.label = id.getText();
                } else {
                    sub.label = ax.head.getName() + "_" + i;
                }
                sub.pre = precondition(subCtx.pre);
                ax.subs[i] = sub;
                i++;
            }

            domain.addAxiom(ax);
            return null;
        }
    }


    //------------------------------- precondition 转换为前置条件 ------------------------------


    private Precondition precondition(LprecondContext ctx) {
        return lprecondVisitor.visit(ctx);
    }

    private Precondition preconditionFromLogicExp(LexpContext ctx) {
        return lexpVisitor.visit(ctx);
    }

    private List<Predicate> predicateList(LatomlistContext ctx) {
        return latomlistVisitor.visit(ctx);
    }

    private Predicate predicate(LatomContext ctx) {
        return latomVisitor.visit(ctx);
    }

    private TList tList(TermlContext ctx) {
        LinkedList<Term> list = new LinkedList<>();
        for (TermContext tc : ctx.term()) {
            list.addFirst(term(tc));
        }
        return TList.MakeList(list);
    }

    private Term term(TermContext ctx) {
        return termVisitor.visit(ctx);
    }


    private class LprecondVisitor extends JSHOP2BaseVisitor<Precondition> {
        @Override
        public Precondition visitPrecond_Exp(Precond_ExpContext ctx) {
            return preconditionFromLogicExp(ctx.lexp());
        }

        @Override
        public Precondition visitPrecond_First(Precond_FirstContext ctx) {
            Precondition pre = preconditionFromLogicExp(ctx.lexp());
            pre.setFirst(true);
            return pre;
        }

        @Override
        public Precondition visitPrecond_SortBy(Precond_SortByContext ctx) {
            Precondition pre = preconditionFromLogicExp(ctx.lexp());
            ComparatorCreator compCreater = createArgs.assureGetSort(ctx.compname().getText());
            int varIdx = curDomainEle.varSymbols.get(ctx.VARID().getText());
            Comparator<Term[]> comparator = compCreater.create(varIdx);
            pre.setSortBy(comparator);
            return pre;
        }
    }

    private class LexpVisitor extends JSHOP2BaseVisitor<Precondition> {

        @Override
        public Precondition visitExp_Nil(Exp_NilContext ctx) {
            return new PreconditionNil();
        }

        @Override
        public Precondition visitExp_And(Exp_AndContext ctx) {
            List<LexpContext> lexps = ctx.lexp();
            if (lexps.size() == 0) {
                return new PreconditionNil();

            } else {
                Precondition lastPre = preconditionFromLogicExp(lexps.get(0));
                for (int i = 1; i < lexps.size(); i++) {
                    Precondition thisPre = preconditionFromLogicExp(lexps.get(i));
                    lastPre = new PreconditionAnd2(lastPre, thisPre);
                }
                return lastPre;
            }
        }

        @Override
        public Precondition visitExp_Or(Exp_OrContext ctx) {
            List<LexpContext> lexps = ctx.lexp();
            if (lexps.size() == 1) {
                return preconditionFromLogicExp(lexps.get(0));

            } else {
                Precondition[] pres = new Precondition[lexps.size()];
                int i = 0;
                for (LexpContext e : lexps) {
                    pres[i] = preconditionFromLogicExp(e);
                    i++;
                }
                return new PreconditionOr(pres);
            }
        }

        @Override
        public Precondition visitExp_Not(Exp_NotContext ctx) {
            return new PreconditionNot(preconditionFromLogicExp(ctx.lexp()));
        }

        @Override
        public Precondition visitExp_Imply(Exp_ImplyContext ctx) {
            Precondition y = preconditionFromLogicExp(ctx.lexp(0));
            Precondition z = preconditionFromLogicExp(ctx.lexp(1));
            Precondition[] eles = new Precondition[2];
            eles[0] = new PreconditionNot(y);
            eles[1] = z;
            return new PreconditionOr(eles);
        }

        @Override
        public Precondition visitExp_Atom(Exp_AtomContext ctx) {
            return new PreconditionAtomic(predicate(ctx.latom()));
        }

        @Override
        public Precondition visitExp_ForAll(Exp_ForAllContext ctx) {
            Precondition y = preconditionFromLogicExp(ctx.lexp(0));
            Precondition z = preconditionFromLogicExp(ctx.lexp(1));
            return new PreconditionForAll(y, z);
        }

        @Override
        public Precondition visitExp_Assign(Exp_AssignContext ctx) {
            if (!isDomain) {
                throw new IllegalArgumentException("problem里的logic atom应该都是ground，不该有assign: "
                                                           + ctx.getText());
            }
            Term term = term(ctx.term());
            return new PreconditionAssign(term, curDomainEle, ctx.VARID().getText());
        }

        @Override
        public Precondition visitExp_Call(Exp_CallContext ctx) {
            TList param = tList(ctx.terml());
            String funcName = ctx.funcname().getText();
            Calculate func = createArgs.assureGetCall(funcName);
            TermCall termCall = new TermCall(param, func, funcName);
            return new PreconditionCall(termCall);
        }
    }


    private class LatomlistVisitor extends JSHOP2BaseVisitor<List<Predicate>> {
        @Override
        public List<Predicate> visitAtomList_Basic(AtomList_BasicContext ctx) {
            List<LatomContext> atoms = ctx.latom();
            List<Predicate> res = new ArrayList<>(atoms.size());
            for (LatomContext atom : atoms) {
                res.add(predicate(atom));
            }
            return res;
        }

        @Override
        public List<Predicate> visitAtomList_Nil(AtomList_NilContext ctx) {
            return List.of();
        }
    }

    private class LatomVisitor extends JSHOP2BaseVisitor<Predicate> {
        @Override
        public Predicate visitAtom_Basic(Atom_BasicContext ctx) {
            TermList param = new TermList(tList(ctx.terml()));
            if (isDomain) {
                return Predicate.of(curDomainEle, ctx.ID().getText(), param);
            } else {
                return Predicate.of(problem, ctx.ID().getText(), param);
            }
        }

        @Override
        public Predicate visitAtom_Var(Atom_VarContext ctx) {
            if (!isDomain) {
                throw new IllegalArgumentException("problem里的logic atom应该都是ground，不该有var类型的: "
                                                           + ctx.getText());
            }
            return Predicate.ofVar(curDomainEle, ctx.VARID().getText());
        }
    }

    private class TermVisitor extends JSHOP2BaseVisitor<Term> {
        @Override
        public Term visitTerm_Var(Term_VarContext ctx) {
            if (isDomain) {
                return TermVariable.of(curDomainEle, ctx.VARID().getText());
            } else {
                return TermVariable.of(problem, ctx.VARID().getText());
            }
        }

        @Override
        public Term visitTerm_Const(Term_ConstContext ctx) {
            if (isDomain) {
                return TermConstant.of(domain, ctx.ID().getText());
            } else {
                return TermConstant.of(problem, ctx.ID().getText());
            }
        }

        @Override
        public Term visitTerm_Num(Term_NumContext ctx) {
            return new TermNumber(Double.parseDouble(ctx.NUM().getText()));
        }

        @Override
        public Term visitTerm_List(Term_ListContext ctx) {
            TList list = tList(ctx.terml());
            TermContext lastTerm = ctx.term();
            if (lastTerm != null) {
                list.append(term(lastTerm));
            }
            return new TermList(list);
        }

        @Override
        public Term visitTerm_Nil(Term_NilContext ctx) {
            return TermList.NIL;
        }

        @Override
        public Term visitTerm_Call(Term_CallContext ctx) {
            TList param = tList(ctx.terml());
            String funcName = ctx.funcname().getText();
            Calculate func = createArgs.assureGetCall(funcName);
            return new TermCall(param, func, funcName);
        }
    }

    //------------------------------- task 转换为任务 ------------------------------

    private TaskList taskList(TasklistContext ctx) {
        return tasklistVisitor.visit(ctx);
    }

    private TaskList taskListFromTaskListSub(TasklistsubContext ctx) {
        return tasklistsubVisitor.visit(ctx);
    }

    private TaskAtom taskAtom(TaskatomContext ctx) {
        TermList param = new TermList(tList(ctx.terml()));
        TerminalNode immediate = ctx.IMMEDIATE();
        boolean isImmediate = immediate != null;
        TerminalNode idNode = ctx.ID();
        boolean isPrimitive = idNode == null;
        Predicate head;
        if (isPrimitive) {
            if (isDomain) {
                head = Predicate.ofPrimitiveTask(curDomainEle, ctx.OPID().getText(), param);
            } else {
                head = Predicate.ofPrimitiveTask(problem, ctx.OPID().getText(), param);
            }
        } else {
            if (isDomain) {
                head = Predicate.ofCompoundTask(curDomainEle, idNode.getText(), param);
            } else {
                head = Predicate.ofCompoundTask(problem, idNode.getText(), param);
            }
        }
        return new TaskAtom(head, isImmediate, isPrimitive);
    }

    private class TasklistVisitor extends JSHOP2BaseVisitor<TaskList> {
        @Override
        public TaskList visitTaskList_Basic(TaskList_BasicContext ctx) {
            TerminalNode unordered = ctx.UNORDERED();
            boolean isOrdered = unordered == null;
            List<TasklistsubContext> tasklistsubs = ctx.tasklistsub();
            if (tasklistsubs.isEmpty()) {
                return TaskList.empty;

            } else {
                List<TaskList> subs = new ArrayList<>(tasklistsubs.size());
                for (TasklistsubContext tasklistsub : tasklistsubs) {
                    TaskList tl = taskListFromTaskListSub(tasklistsub);
                    subs.add(tl);
                }
                return TaskList.of(subs, isOrdered);
            }
        }

        @Override
        public TaskList visitTaskList_Nil(TaskList_NilContext ctx) {
            return TaskList.empty;
        }
    }

    private class TasklistsubVisitor extends JSHOP2BaseVisitor<TaskList> {
        @Override
        public TaskList visitTaskListSub_List(TaskListSub_ListContext ctx) {
            return taskList(ctx.tasklist());
        }

        @Override
        public TaskList visitTaskListSub_Atom(TaskListSub_AtomContext ctx) {
            return TaskList.of(taskAtom(ctx.taskatom()));
        }
    }


    //------------------------------- deladd 转换为deladd ------------------------------


    private DelAdd delAdd(DeladdContext ctx) {
        return deladdVisitor.visit(ctx);
    }

    private DelAddElement delAddElement(DeladdeleContext ctx) {
        return deladdeleVisitor.visit(ctx);
    }

    private class DeladdVisitor extends JSHOP2BaseVisitor<DelAdd> {
        @Override
        public DelAdd visitDelAdd_Basic(DelAdd_BasicContext ctx) {
            List<DeladdeleContext> deladdeles = ctx.deladdele();
            DelAdd r = new DelAdd();
            r.elements = new DelAddElement[deladdeles.size()];

            int i = 0;
            for (DeladdeleContext d : deladdeles) {
                r.elements[i] = delAddElement(d);
                i++;
            }
            return r;
        }

        @Override
        public DelAdd visitDelAdd_Var(DelAdd_VarContext ctx) {
            int idx = curDomainEle.varSymbols.get(ctx.VARID().getText());
            DelAdd r = new DelAdd();
            r.varIdx = idx;
            return r;
        }

        @Override
        public DelAdd visitDelAdd_Nil(DelAdd_NilContext ctx) {
            DelAdd r = new DelAdd();
            r.elements = new DelAddElement[0];
            return r;
        }
    }

    private class DeladdeleVisitor extends JSHOP2BaseVisitor<DelAddElement> {
        @Override
        public DelAddElement visitDelAddEle_Atom(DelAddEle_AtomContext ctx) {
            return new DelAddAtomic(predicate(ctx.latom()));
        }

        @Override
        public DelAddElement visitDelAddEle_Protect(DelAddEle_ProtectContext ctx) {
            return new DelAddProtection(predicate(ctx.latom()));
        }

        @Override
        public DelAddElement visitDelAddEle_ForAll(DelAddEle_ForAllContext ctx) {
            Precondition pre = preconditionFromLogicExp(ctx.lexp());
            List<Predicate> atoms = predicateList(ctx.latomlist());
            return new DelAddForAll(pre, atoms.toArray(new Predicate[0]));
        }
    }
}
