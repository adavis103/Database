// Generated from Grammar.g4 by ANTLR 4.7.1

package Grammar;

import org.antlr.v4.runtime.*;
import java.util.*;
import DBTypes.*;

/**
 * This class provides an empty implementation of {@link GrammarListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class GrammarVisitorRelation extends GrammarBaseVisitor<Relation> {

    Database db = new Database();

    public GrammarVisitorRelation(Database database) {
        this.db = database;
    }

    @Override
    public Relation visitExpr(GrammarParser.ExprContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public Relation visitAtomic_expr(GrammarParser.Atomic_exprContext ctx) {
        if (ctx.getChildCount() > 1) {
            return visit(ctx.getChild(1));
        }
        else { //recursive call, not just atomic_expr
            return visit(ctx.getChild(0));
        }
    }

    @Override
    public Relation visitSelection(GrammarParser.SelectionContext ctx) {
        Relation atomicExpr = visit(ctx.getChild(4));
        Vector<String> condition = ctx.getChild(2).accept(new GrammarVisitorAttributeList());

        //Make Condition an Attribute
        Attribute attrComp;
        if (condition.get(0).matches("^-?\\d+$")) {
            Domain<?> domain = new Domain<Integer>(Integer.class, condition.get(0));
            attrComp = new Attribute(domain, Integer.parseInt(condition.get(2))); //attribute_name
        }
        else {
            Domain<?> domain = new Domain<String>(String.class, condition.get(0));
            attrComp = new Attribute(domain, condition.get(2)); //attribute_name
        }

        Relation relation = db.selection(atomicExpr.getRelation(), attrComp, condition.get(1), condition.get(2));
        return relation;
    }

    @Override
    public Relation visitProjection(GrammarParser.ProjectionContext ctx) {
        Vector<String> attrList = ctx.getChild(2).accept(new GrammarVisitorAttributeList());
        String relation = visit(ctx.getChild(4)).getRelation();
        try {
            return db.projection(relation, attrList);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Relation visitUnion(GrammarParser.UnionContext ctx) {
        String relation1 = visit(ctx.getChild(0)).getRelation();
        String relation2 = visit(ctx.getChild(2)).getRelation();
        try {
            return db.union(relation1, relation2);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Relation visitDifference(GrammarParser.DifferenceContext ctx) {
        String relation1 = visit(ctx.getChild(0)).getRelation();
        String relation2 = visit(ctx.getChild(2)).getRelation();
        try {
            return db.difference(relation1, relation2);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Relation visitProduct(GrammarParser.ProductContext ctx) {
        String relation1 = visit(ctx.getChild(0)).getRelation();
        String relation2 = visit(ctx.getChild(2)).getRelation();
        try {
            return db.product(relation1, relation2);
        } catch (Exception e) {
            return null;
        }
    }

    @Override public Relation visitRelation_name(GrammarParser.Relation_nameContext ctx) {
        Relation relation = db.getRelationMap().get(ctx.getChild(0).getText());
        return relation;
    }
}
