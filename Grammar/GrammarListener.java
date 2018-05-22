// Generated from Grammar.g4 by ANTLR 4.7.1

package Grammar;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(GrammarParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(GrammarParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#open_cmd}.
	 * @param ctx the parse tree
	 */
	void enterOpen_cmd(GrammarParser.Open_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#open_cmd}.
	 * @param ctx the parse tree
	 */
	void exitOpen_cmd(GrammarParser.Open_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#close_cmd}.
	 * @param ctx the parse tree
	 */
	void enterClose_cmd(GrammarParser.Close_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#close_cmd}.
	 * @param ctx the parse tree
	 */
	void exitClose_cmd(GrammarParser.Close_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#write_cmd}.
	 * @param ctx the parse tree
	 */
	void enterWrite_cmd(GrammarParser.Write_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#write_cmd}.
	 * @param ctx the parse tree
	 */
	void exitWrite_cmd(GrammarParser.Write_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#exit_cmd}.
	 * @param ctx the parse tree
	 */
	void enterExit_cmd(GrammarParser.Exit_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#exit_cmd}.
	 * @param ctx the parse tree
	 */
	void exitExit_cmd(GrammarParser.Exit_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#show_cmd}.
	 * @param ctx the parse tree
	 */
	void enterShow_cmd(GrammarParser.Show_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#show_cmd}.
	 * @param ctx the parse tree
	 */
	void exitShow_cmd(GrammarParser.Show_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#create_cmd}.
	 * @param ctx the parse tree
	 */
	void enterCreate_cmd(GrammarParser.Create_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#create_cmd}.
	 * @param ctx the parse tree
	 */
	void exitCreate_cmd(GrammarParser.Create_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#update_cmd}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_cmd(GrammarParser.Update_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#update_cmd}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_cmd(GrammarParser.Update_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#insert_cmd}.
	 * @param ctx the parse tree
	 */
	void enterInsert_cmd(GrammarParser.Insert_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#insert_cmd}.
	 * @param ctx the parse tree
	 */
	void exitInsert_cmd(GrammarParser.Insert_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#delete_cmd}.
	 * @param ctx the parse tree
	 */
	void enterDelete_cmd(GrammarParser.Delete_cmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#delete_cmd}.
	 * @param ctx the parse tree
	 */
	void exitDelete_cmd(GrammarParser.Delete_cmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#typed_attribute_list}.
	 * @param ctx the parse tree
	 */
	void enterTyped_attribute_list(GrammarParser.Typed_attribute_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#typed_attribute_list}.
	 * @param ctx the parse tree
	 */
	void exitTyped_attribute_list(GrammarParser.Typed_attribute_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(GrammarParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(GrammarParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(GrammarParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(GrammarParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#relation_name}.
	 * @param ctx the parse tree
	 */
	void enterRelation_name(GrammarParser.Relation_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#relation_name}.
	 * @param ctx the parse tree
	 */
	void exitRelation_name(GrammarParser.Relation_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#atomic_expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomic_expr(GrammarParser.Atomic_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#atomic_expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomic_expr(GrammarParser.Atomic_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(GrammarParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(GrammarParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#projection}.
	 * @param ctx the parse tree
	 */
	void enterProjection(GrammarParser.ProjectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#projection}.
	 * @param ctx the parse tree
	 */
	void exitProjection(GrammarParser.ProjectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#renaming}.
	 * @param ctx the parse tree
	 */
	void enterRenaming(GrammarParser.RenamingContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#renaming}.
	 * @param ctx the parse tree
	 */
	void exitRenaming(GrammarParser.RenamingContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#union}.
	 * @param ctx the parse tree
	 */
	void enterUnion(GrammarParser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#union}.
	 * @param ctx the parse tree
	 */
	void exitUnion(GrammarParser.UnionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#difference}.
	 * @param ctx the parse tree
	 */
	void enterDifference(GrammarParser.DifferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#difference}.
	 * @param ctx the parse tree
	 */
	void exitDifference(GrammarParser.DifferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#product}.
	 * @param ctx the parse tree
	 */
	void enterProduct(GrammarParser.ProductContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#product}.
	 * @param ctx the parse tree
	 */
	void exitProduct(GrammarParser.ProductContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#natural_join}.
	 * @param ctx the parse tree
	 */
	void enterNatural_join(GrammarParser.Natural_joinContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#natural_join}.
	 * @param ctx the parse tree
	 */
	void exitNatural_join(GrammarParser.Natural_joinContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(GrammarParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(GrammarParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(GrammarParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(GrammarParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(GrammarParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(GrammarParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#attribute_list}.
	 * @param ctx the parse tree
	 */
	void enterAttribute_list(GrammarParser.Attribute_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#attribute_list}.
	 * @param ctx the parse tree
	 */
	void exitAttribute_list(GrammarParser.Attribute_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(GrammarParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(GrammarParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(GrammarParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(GrammarParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(GrammarParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(GrammarParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#attribute_name}.
	 * @param ctx the parse tree
	 */
	void enterAttribute_name(GrammarParser.Attribute_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#attribute_name}.
	 * @param ctx the parse tree
	 */
	void exitAttribute_name(GrammarParser.Attribute_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(GrammarParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(GrammarParser.LiteralContext ctx);
}