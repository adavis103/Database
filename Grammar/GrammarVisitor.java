// Generated from Grammar.g4 by ANTLR 4.7.1

package Grammar;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link GrammarParser#program}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProgram(GrammarParser.ProgramContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#command}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCommand(GrammarParser.CommandContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#open_cmd}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOpen_cmd(GrammarParser.Open_cmdContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#close_cmd}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitClose_cmd(GrammarParser.Close_cmdContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#write_cmd}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWrite_cmd(GrammarParser.Write_cmdContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#exit_cmd}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExit_cmd(GrammarParser.Exit_cmdContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#show_cmd}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitShow_cmd(GrammarParser.Show_cmdContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#create_cmd}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCreate_cmd(GrammarParser.Create_cmdContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#update_cmd}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUpdate_cmd(GrammarParser.Update_cmdContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#insert_cmd}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInsert_cmd(GrammarParser.Insert_cmdContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#delete_cmd}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDelete_cmd(GrammarParser.Delete_cmdContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#typed_attribute_list}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTyped_attribute_list(GrammarParser.Typed_attribute_listContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitType(GrammarParser.TypeContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#integer}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInteger(GrammarParser.IntegerContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#query}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitQuery(GrammarParser.QueryContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#relation_name}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRelation_name(GrammarParser.Relation_nameContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpr(GrammarParser.ExprContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#atomic_expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAtomic_expr(GrammarParser.Atomic_exprContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#selection}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSelection(GrammarParser.SelectionContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#projection}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProjection(GrammarParser.ProjectionContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#renaming}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRenaming(GrammarParser.RenamingContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#union}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUnion(GrammarParser.UnionContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#difference}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDifference(GrammarParser.DifferenceContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#product}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProduct(GrammarParser.ProductContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#natural_join}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNatural_join(GrammarParser.Natural_joinContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#condition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCondition(GrammarParser.ConditionContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#conjunction}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConjunction(GrammarParser.ConjunctionContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#comparison}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitComparison(GrammarParser.ComparisonContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#attribute_list}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAttribute_list(GrammarParser.Attribute_listContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#identifier}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIdentifier(GrammarParser.IdentifierContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#op}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOp(GrammarParser.OpContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#operand}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOperand(GrammarParser.OperandContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#attribute_name}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAttribute_name(GrammarParser.Attribute_nameContext ctx);

    /**
     * Visit a parse tree produced by {@link GrammarParser#literal}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLiteral(GrammarParser.LiteralContext ctx);
}