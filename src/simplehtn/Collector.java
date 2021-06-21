package simplehtn;

import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import static simplehtn.JSHOP2Parser.*;

/**
 * 符号信息收集器
 */
public class Collector extends JSHOP2BaseListener {

    final ShopContext shopCtx;
    /**
     * false的话就是problem, 对应的收集的信息为constants，和currentVars
     */
    boolean isDomain;
    DomainContext domainCtx;
    final Set<String> primitives = new LinkedHashSet<>();
    final Set<String> compounds = new LinkedHashSet<>();
    final Set<String> constants = new LinkedHashSet<>();
    final Set<String> axiomConstants = new LinkedHashSet<>();
    final Map<PdeContext, Set<String>> pdeVarSymbols = new LinkedHashMap<>();

    Set<String> currentVars;
    ProblemContext problemCtx;

    public Collector(ShopContext ctx) {
        this.shopCtx = ctx;
    }

    public void walk() {
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, shopCtx);
    }

    @Override
    public void enterDomain(DomainContext ctx) {
        isDomain = true;
        domainCtx = ctx;
    }

    @Override
    public void enterProblem(ProblemContext ctx) {
        isDomain = false;
        problemCtx = ctx;
        currentVars = new LinkedHashSet<>();
    }

    @Override
    public void enterPde(PdeContext ctx) {
        currentVars = new LinkedHashSet<>();
        pdeVarSymbols.put(ctx, currentVars);
    }

    @Override
    public void exitOperator(OperatorContext ctx) {
        primitives.add(ctx.OPID().getText());
    }

    @Override
    public void exitMethod(MethodContext ctx) {
        compounds.add(ctx.ID().getText());
    }

    @Override
    public void exitAxiom(AxiomContext ctx) {
        String txt = ctx.ID().getText();
        axiomConstants.add(txt);
        constants.add(txt);
    }

    @Override
    public void exitAtom_Basic(Atom_BasicContext ctx) {
        String txt = ctx.ID().getText();
        constants.add(txt);
    }

    @Override
    public void exitTerm_Const(Term_ConstContext ctx) {
        String txt = ctx.ID().getText();
        constants.add(txt);
    }

    @Override
    public void exitPrecond_SortBy(Precond_SortByContext ctx) {
        currentVars.add(ctx.VARID().getText());
    }

    @Override
    public void exitExp_Assign(Exp_AssignContext ctx) {
        currentVars.add(ctx.VARID().getText());
    }

    @Override
    public void exitTerm_Var(Term_VarContext ctx) {
        currentVars.add(ctx.VARID().getText());
    }
}
