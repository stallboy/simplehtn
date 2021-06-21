// Generated from simplehtn\JSHOP2.g4 by ANTLR 4.9.2
package simplehtn;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JSHOP2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JSHOP2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JSHOP2Parser#shop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShop(JSHOP2Parser.ShopContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSHOP2Parser#problem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProblem(JSHOP2Parser.ProblemContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSHOP2Parser#domain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDomain(JSHOP2Parser.DomainContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSHOP2Parser#pde}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPde(JSHOP2Parser.PdeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSHOP2Parser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(JSHOP2Parser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSHOP2Parser#methodsub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodsub(JSHOP2Parser.MethodsubContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSHOP2Parser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(JSHOP2Parser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSHOP2Parser#axiom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAxiom(JSHOP2Parser.AxiomContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSHOP2Parser#axiomsub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAxiomsub(JSHOP2Parser.AxiomsubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DelAdd_Basic}
	 * labeled alternative in {@link JSHOP2Parser#deladd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelAdd_Basic(JSHOP2Parser.DelAdd_BasicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DelAdd_Var}
	 * labeled alternative in {@link JSHOP2Parser#deladd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelAdd_Var(JSHOP2Parser.DelAdd_VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DelAdd_Nil}
	 * labeled alternative in {@link JSHOP2Parser#deladd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelAdd_Nil(JSHOP2Parser.DelAdd_NilContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DelAddEle_Atom}
	 * labeled alternative in {@link JSHOP2Parser#deladdele}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelAddEle_Atom(JSHOP2Parser.DelAddEle_AtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DelAddEle_Protect}
	 * labeled alternative in {@link JSHOP2Parser#deladdele}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelAddEle_Protect(JSHOP2Parser.DelAddEle_ProtectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DelAddEle_ForAll}
	 * labeled alternative in {@link JSHOP2Parser#deladdele}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelAddEle_ForAll(JSHOP2Parser.DelAddEle_ForAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TaskList_Basic}
	 * labeled alternative in {@link JSHOP2Parser#tasklist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaskList_Basic(JSHOP2Parser.TaskList_BasicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TaskList_Nil}
	 * labeled alternative in {@link JSHOP2Parser#tasklist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaskList_Nil(JSHOP2Parser.TaskList_NilContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TaskListSub_List}
	 * labeled alternative in {@link JSHOP2Parser#tasklistsub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaskListSub_List(JSHOP2Parser.TaskListSub_ListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TaskListSub_Atom}
	 * labeled alternative in {@link JSHOP2Parser#tasklistsub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaskListSub_Atom(JSHOP2Parser.TaskListSub_AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSHOP2Parser#taskatom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaskatom(JSHOP2Parser.TaskatomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Precond_Exp}
	 * labeled alternative in {@link JSHOP2Parser#lprecond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecond_Exp(JSHOP2Parser.Precond_ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Precond_First}
	 * labeled alternative in {@link JSHOP2Parser#lprecond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecond_First(JSHOP2Parser.Precond_FirstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Precond_SortBy}
	 * labeled alternative in {@link JSHOP2Parser#lprecond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecond_SortBy(JSHOP2Parser.Precond_SortByContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSHOP2Parser#compname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompname(JSHOP2Parser.CompnameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Exp_Nil}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_Nil(JSHOP2Parser.Exp_NilContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Exp_And}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_And(JSHOP2Parser.Exp_AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Exp_Or}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_Or(JSHOP2Parser.Exp_OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Exp_Not}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_Not(JSHOP2Parser.Exp_NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Exp_Imply}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_Imply(JSHOP2Parser.Exp_ImplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Exp_Atom}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_Atom(JSHOP2Parser.Exp_AtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Exp_ForAll}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_ForAll(JSHOP2Parser.Exp_ForAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Exp_Assign}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_Assign(JSHOP2Parser.Exp_AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Exp_Call}
	 * labeled alternative in {@link JSHOP2Parser#lexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_Call(JSHOP2Parser.Exp_CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomList_Basic}
	 * labeled alternative in {@link JSHOP2Parser#latomlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomList_Basic(JSHOP2Parser.AtomList_BasicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomList_Nil}
	 * labeled alternative in {@link JSHOP2Parser#latomlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomList_Nil(JSHOP2Parser.AtomList_NilContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Atom_Basic}
	 * labeled alternative in {@link JSHOP2Parser#latom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom_Basic(JSHOP2Parser.Atom_BasicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Atom_Var}
	 * labeled alternative in {@link JSHOP2Parser#latom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom_Var(JSHOP2Parser.Atom_VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSHOP2Parser#funcname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncname(JSHOP2Parser.FuncnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSHOP2Parser#terml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerml(JSHOP2Parser.TermlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Term_Var}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm_Var(JSHOP2Parser.Term_VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Term_Const}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm_Const(JSHOP2Parser.Term_ConstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Term_Num}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm_Num(JSHOP2Parser.Term_NumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Term_List}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm_List(JSHOP2Parser.Term_ListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Term_Nil}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm_Nil(JSHOP2Parser.Term_NilContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Term_Call}
	 * labeled alternative in {@link JSHOP2Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm_Call(JSHOP2Parser.Term_CallContext ctx);
}