// Generated from simplehtn\JSHOP2.g4 by ANTLR 4.9.2
package simplehtn;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JSHOP2Parser}.
 */
public interface JSHOP2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JSHOP2Parser#shop}.
	 * @param ctx the parse tree
	 */
	void enterShop(JSHOP2Parser.ShopContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSHOP2Parser#shop}.
	 * @param ctx the parse tree
	 */
	void exitShop(JSHOP2Parser.ShopContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSHOP2Parser#problem}.
	 * @param ctx the parse tree
	 */
	void enterProblem(JSHOP2Parser.ProblemContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSHOP2Parser#problem}.
	 * @param ctx the parse tree
	 */
	void exitProblem(JSHOP2Parser.ProblemContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSHOP2Parser#domain}.
	 * @param ctx the parse tree
	 */
	void enterDomain(JSHOP2Parser.DomainContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSHOP2Parser#domain}.
	 * @param ctx the parse tree
	 */
	void exitDomain(JSHOP2Parser.DomainContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSHOP2Parser#pde}.
	 * @param ctx the parse tree
	 */
	void enterPde(JSHOP2Parser.PdeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSHOP2Parser#pde}.
	 * @param ctx the parse tree
	 */
	void exitPde(JSHOP2Parser.PdeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSHOP2Parser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(JSHOP2Parser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSHOP2Parser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(JSHOP2Parser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSHOP2Parser#methodsub}.
	 * @param ctx the parse tree
	 */
	void enterMethodsub(JSHOP2Parser.MethodsubContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSHOP2Parser#methodsub}.
	 * @param ctx the parse tree
	 */
	void exitMethodsub(JSHOP2Parser.MethodsubContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSHOP2Parser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(JSHOP2Parser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSHOP2Parser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(JSHOP2Parser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSHOP2Parser#axiom}.
	 * @param ctx the parse tree
	 */
	void enterAxiom(JSHOP2Parser.AxiomContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSHOP2Parser#axiom}.
	 * @param ctx the parse tree
	 */
	void exitAxiom(JSHOP2Parser.AxiomContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSHOP2Parser#axiomsub}.
	 * @param ctx the parse tree
	 */
	void enterAxiomsub(JSHOP2Parser.AxiomsubContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSHOP2Parser#axiomsub}.
	 * @param ctx the parse tree
	 */
	void exitAxiomsub(JSHOP2Parser.AxiomsubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DelAdd_Basic}
	 * labeled alternative in {@link JSHOP2Parser#deladd}.
	 * @param ctx the parse tree
	 */
	void enterDelAdd_Basic(JSHOP2Parser.DelAdd_BasicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DelAdd_Basic}
	 * labeled alternative in {@link JSHOP2Parser#deladd}.
	 * @param ctx the parse tree
	 */
	void exitDelAdd_Basic(JSHOP2Parser.DelAdd_BasicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DelAdd_Var}
	 * labeled alternative in {@link JSHOP2Parser#deladd}.
	 * @param ctx the parse tree
	 */
	void enterDelAdd_Var(JSHOP2Parser.DelAdd_VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DelAdd_Var}
	 * labeled alternative in {@link JSHOP2Parser#deladd}.
	 * @param ctx the parse tree
	 */
	void exitDelAdd_Var(JSHOP2Parser.DelAdd_VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DelAdd_Nil}
	 * labeled alternative in {@link JSHOP2Parser#deladd}.
	 * @param ctx the parse tree
	 */
	void enterDelAdd_Nil(JSHOP2Parser.DelAdd_NilContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DelAdd_Nil}
	 * labeled alternative in {@link JSHOP2Parser#deladd}.
	 * @param ctx the parse tree
	 */
	void exitDelAdd_Nil(JSHOP2Parser.DelAdd_NilContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DelAddEle_Atom}
	 * labeled alternative in {@link JSHOP2Parser#deladdele}.
	 * @param ctx the parse tree
	 */
	void enterDelAddEle_Atom(JSHOP2Parser.DelAddEle_AtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DelAddEle_Atom}
	 * labeled alternative in {@link JSHOP2Parser#deladdele}.
	 * @param ctx the parse tree
	 */
	void exitDelAddEle_Atom(JSHOP2Parser.DelAddEle_AtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DelAddEle_Protect}
	 * labeled alternative in {@link JSHOP2Parser#deladdele}.
	 * @param ctx the parse tree
	 */
	void enterDelAddEle_Protect(JSHOP2Parser.DelAddEle_ProtectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DelAddEle_Protect}
	 * labeled alternative in {@link JSHOP2Parser#deladdele}.
	 * @param ctx the parse tree
	 */
	void exitDelAddEle_Protect(JSHOP2Parser.DelAddEle_ProtectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DelAddEle_ForAll}
	 * labeled alternative in {@link JSHOP2Parser#deladdele}.
	 * @param ctx the parse tree
	 */
	void enterDelAddEle_ForAll(JSHOP2Parser.DelAddEle_ForAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DelAddEle_ForAll}
	 * labeled alternative in {@link JSHOP2Parser#deladdele}.
	 * @param ctx the parse tree
	 */
	void exitDelAddEle_ForAll(JSHOP2Parser.DelAddEle_ForAllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TaskList_Basic}
	 * labeled alternative in {@link JSHOP2Parser#tasklist}.
	 * @param ctx the parse tree
	 */
	void enterTaskList_Basic(JSHOP2Parser.TaskList_BasicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TaskList_Basic}
	 * labeled alternative in {@link JSHOP2Parser#tasklist}.
	 * @param ctx the parse tree
	 */
	void exitTaskList_Basic(JSHOP2Parser.TaskList_BasicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TaskList_Nil}
	 * labeled alternative in {@link JSHOP2Parser#tasklist}.
	 * @param ctx the parse tree
	 */
	void enterTaskList_Nil(JSHOP2Parser.TaskList_NilContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TaskList_Nil}
	 * labeled alternative in {@link JSHOP2Parser#tasklist}.
	 * @param ctx the parse tree
	 */
	void exitTaskList_Nil(JSHOP2Parser.TaskList_NilContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TaskListSub_List}
	 * labeled alternative in {@link JSHOP2Parser#tasklistsub}.
	 * @param ctx the parse tree
	 */
	void enterTaskListSub_List(JSHOP2Parser.TaskListSub_ListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TaskListSub_List}
	 * labeled alternative in {@link JSHOP2Parser#tasklistsub}.
	 * @param ctx the parse tree
	 */
	void exitTaskListSub_List(JSHOP2Parser.TaskListSub_ListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TaskListSub_Atom}
	 * labeled alternative in {@link JSHOP2Parser#tasklistsub}.
	 * @param ctx the parse tree
	 */
	void enterTaskListSub_Atom(JSHOP2Parser.TaskListSub_AtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TaskListSub_Atom}
	 * labeled alternative in {@link JSHOP2Parser#tasklistsub}.
	 * @param ctx the parse tree
	 */
	void exitTaskListSub_Atom(JSHOP2Parser.TaskListSub_AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSHOP2Parser#taskatom}.
	 * @param ctx the parse tree
	 */
	void enterTaskatom(JSHOP2Parser.TaskatomContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSHOP2Parser#taskatom}.
	 * @param ctx the parse tree
	 */
	void exitTaskatom(JSHOP2Parser.TaskatomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Precond_Exp}
	 * labeled alternative in {@link JSHOP2Parser#lprecond}.
	 * @param ctx the parse tree
	 */
	void enterPrecond_Exp(JSHOP2Parser.Precond_ExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Precond_Exp}
	 * labeled alternative in {@link JSHOP2Parser#lprecond}.
	 * @param ctx the parse tree
	 */
	void exitPrecond_Exp(JSHOP2Parser.Precond_ExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Precond_First}
	 * labeled alternative in {@link JSHOP2Parser#lprecond}.
	 * @param ctx the parse tree
	 */
	void enterPrecond_First(JSHOP2Parser.Precond_FirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Precond_First}
	 * labeled alternative in {@link JSHOP2Parser#lprecond}.
	 * @param ctx the parse tree
	 */
	void exitPrecond_First(JSHOP2Parser.Precond_FirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Precond_SortBy}
	 * labeled alternative in {@link JSHOP2Parser#lprecond}.
	 * @param ctx the parse tree
	 */
	void enterPrecond_SortBy(JSHOP2Parser.Precond_SortByContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Precond_SortBy}
	 * labeled alternative in {@link JSHOP2Parser#lprecond}.
	 * @param ctx the parse tree
	 */
	void exitPrecond_SortBy(JSHOP2Parser.Precond_SortByContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSHOP2Parser#compname}.
	 * @param ctx the parse tree
	 */
	void enterCompname(JSHOP2Parser.CompnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSHOP2Parser#compname}.
	 * @param ctx the parse tree
	 */
	void exitCompname(JSHOP2Parser.CompnameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exp_Nil}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void enterExp_Nil(JSHOP2Parser.Exp_NilContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exp_Nil}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void exitExp_Nil(JSHOP2Parser.Exp_NilContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exp_And}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void enterExp_And(JSHOP2Parser.Exp_AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exp_And}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void exitExp_And(JSHOP2Parser.Exp_AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exp_Or}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void enterExp_Or(JSHOP2Parser.Exp_OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exp_Or}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void exitExp_Or(JSHOP2Parser.Exp_OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exp_Not}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void enterExp_Not(JSHOP2Parser.Exp_NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exp_Not}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void exitExp_Not(JSHOP2Parser.Exp_NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exp_Imply}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void enterExp_Imply(JSHOP2Parser.Exp_ImplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exp_Imply}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void exitExp_Imply(JSHOP2Parser.Exp_ImplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exp_Atom}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void enterExp_Atom(JSHOP2Parser.Exp_AtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exp_Atom}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void exitExp_Atom(JSHOP2Parser.Exp_AtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exp_ForAll}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void enterExp_ForAll(JSHOP2Parser.Exp_ForAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exp_ForAll}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void exitExp_ForAll(JSHOP2Parser.Exp_ForAllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exp_Assign}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void enterExp_Assign(JSHOP2Parser.Exp_AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exp_Assign}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void exitExp_Assign(JSHOP2Parser.Exp_AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Exp_Call}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void enterExp_Call(JSHOP2Parser.Exp_CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exp_Call}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 */
	void exitExp_Call(JSHOP2Parser.Exp_CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomList_Basic}
	 * labeled alternative in {@link JSHOP2Parser#latomlist}.
	 * @param ctx the parse tree
	 */
	void enterAtomList_Basic(JSHOP2Parser.AtomList_BasicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomList_Basic}
	 * labeled alternative in {@link JSHOP2Parser#latomlist}.
	 * @param ctx the parse tree
	 */
	void exitAtomList_Basic(JSHOP2Parser.AtomList_BasicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomList_Nil}
	 * labeled alternative in {@link JSHOP2Parser#latomlist}.
	 * @param ctx the parse tree
	 */
	void enterAtomList_Nil(JSHOP2Parser.AtomList_NilContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomList_Nil}
	 * labeled alternative in {@link JSHOP2Parser#latomlist}.
	 * @param ctx the parse tree
	 */
	void exitAtomList_Nil(JSHOP2Parser.AtomList_NilContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atom_Basic}
	 * labeled alternative in {@link JSHOP2Parser#latom}.
	 * @param ctx the parse tree
	 */
	void enterAtom_Basic(JSHOP2Parser.Atom_BasicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atom_Basic}
	 * labeled alternative in {@link JSHOP2Parser#latom}.
	 * @param ctx the parse tree
	 */
	void exitAtom_Basic(JSHOP2Parser.Atom_BasicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atom_Var}
	 * labeled alternative in {@link JSHOP2Parser#latom}.
	 * @param ctx the parse tree
	 */
	void enterAtom_Var(JSHOP2Parser.Atom_VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atom_Var}
	 * labeled alternative in {@link JSHOP2Parser#latom}.
	 * @param ctx the parse tree
	 */
	void exitAtom_Var(JSHOP2Parser.Atom_VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSHOP2Parser#funcname}.
	 * @param ctx the parse tree
	 */
	void enterFuncname(JSHOP2Parser.FuncnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSHOP2Parser#funcname}.
	 * @param ctx the parse tree
	 */
	void exitFuncname(JSHOP2Parser.FuncnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSHOP2Parser#terml}.
	 * @param ctx the parse tree
	 */
	void enterTerml(JSHOP2Parser.TermlContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSHOP2Parser#terml}.
	 * @param ctx the parse tree
	 */
	void exitTerml(JSHOP2Parser.TermlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Term_Var}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm_Var(JSHOP2Parser.Term_VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Term_Var}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm_Var(JSHOP2Parser.Term_VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Term_Const}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm_Const(JSHOP2Parser.Term_ConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Term_Const}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm_Const(JSHOP2Parser.Term_ConstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Term_Num}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm_Num(JSHOP2Parser.Term_NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Term_Num}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm_Num(JSHOP2Parser.Term_NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Term_List}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm_List(JSHOP2Parser.Term_ListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Term_List}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm_List(JSHOP2Parser.Term_ListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Term_Nil}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm_Nil(JSHOP2Parser.Term_NilContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Term_Nil}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm_Nil(JSHOP2Parser.Term_NilContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Term_Call}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm_Call(JSHOP2Parser.Term_CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Term_Call}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm_Call(JSHOP2Parser.Term_CallContext ctx);
}