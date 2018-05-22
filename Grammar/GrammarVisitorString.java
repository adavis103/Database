// Generated from Grammar.g4 by ANTLR 4.7.1

package Grammar;

import org.antlr.v4.runtime.*;

/**
 * This class provides an empty implementation of {@link GrammarListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class GrammarVisitorString extends GrammarBaseVisitor<String> {
    @Override
    public String visitRelation_name(GrammarParser.Relation_nameContext ctx) {
        return ctx.getChild(0).getText();
    }

    @Override
    public String visitOp(GrammarParser.OpContext ctx) {
        return ctx.getChild(0).getText();
    }

    @Override
    public String visitOperand(GrammarParser.OperandContext ctx) { return ctx.getChild(0).getText(); }

    @Override
    public String visitAttribute_name(GrammarParser.Attribute_nameContext ctx) {
        return ctx.getChild(0).getText();
    }
}
