// Generated from Grammar.g4 by ANTLR 4.7.1

package Grammar;

import org.antlr.v4.runtime.*;
import java.util.Vector;

/**
 * This class provides an empty implementation of {@link GrammarListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class GrammarVisitorAttributeList extends GrammarBaseVisitor<Vector<String>> {
    @Override
    public Vector<String> visitComparison(GrammarParser.ComparisonContext ctx) {
        Vector<String> ops = new Vector<String>();

        if (ctx.getChild(0).getText().equals("(")) { //not a comparison
            return visit(ctx.getChild(1));
        }
        else { //comparison
            String operand1 = ctx.getChild(0).accept(new GrammarVisitorString());
            String operator = ctx.getChild(1).accept(new GrammarVisitorString());
            String operand2 = ctx.getChild(2).accept(new GrammarVisitorString());

            ops.add(operand1);
            ops.add(operator);
            ops.add(operand2);
        }

        return ops;
    }

    @Override
    public Vector<String> visitCondition(GrammarParser.ConditionContext ctx) {
        Vector<String> conditions = new Vector<String>();
        if (ctx.getChildCount() > 1) {
            for (int i = 0; i < ctx.getChildCount(); i++) {
                conditions.add(ctx.getChild(i).getText());
            }
            return conditions;
        }
        else {
            return visit(ctx.getChild(0));
        }
    }

    @Override
    public Vector<String> visitConjunction(GrammarParser.ConjunctionContext ctx) {
        Vector<String> conjunctions = new Vector<String>();
        if (ctx.getChildCount() > 1) {
            for (int i = 0; i < ctx.getChildCount(); i++) {
                if (i%2 == 0) {
                    conjunctions.addAll(visit(ctx.getChild(i)));
                }
                else {
                    conjunctions.add(ctx.getChild(i).getText());
                }
            }
            return conjunctions;
        }
        else {
           return visit(ctx.getChild(0));
        }
    }



    @Override
    public Vector<String> visitAttribute_list(GrammarParser.Attribute_listContext ctx) {
        Vector<String> attrList = new Vector<String>();
        for (int i = 0; i < ctx.getChildCount(); i++)
            attrList.add(ctx.getChild(i).accept(new GrammarVisitorString()));
        return attrList;
    }
}
