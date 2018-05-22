// Generated from Grammar.g4 by ANTLR 4.7.1

package Grammar;

import org.antlr.v4.runtime.*;
import DBTypes.*;
import java.util.Map;

import java.util.Vector;

/**
 * This class provides an empty implementation of {@link GrammarListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class GrammarVisitorProgram extends GrammarBaseVisitor<Void> {

    Database db = new Database();

    public GrammarVisitorProgram (Database database) {
        this.db = database;
    }

    @Override
    public Void visitRenaming(GrammarParser.RenamingContext ctx) {
        Vector<String> attrList = ctx.getChild(2).accept(new GrammarVisitorAttributeList());
        Relation relation = ctx.getChild(3).accept(new GrammarVisitorRelation(db));
        try {
            db.renaming(relation.getRelation(), attrList.get(0), attrList.get(1));
        }
        catch (Exception e) {
            return null;
        }
        return null;
    }

    @Override
    public Void visitOpen_cmd(GrammarParser.Open_cmdContext ctx) {
        try {
            if (ctx.getChild(1).accept(new GrammarVisitorString()).equals("ALL") ) {
                File folder = new File("RelationFiles/");
                File[] listOfFiles = folder.listFiles();
                for (File f : listOfFiles) {
                    if (f.getName().equals("Class-Schedule-18spring-XML.txt")) continue;
                    if (f.isFile()) {
                        String fileName = f.getName();
                        String relationName = fileName.substring(0,fileName.length()-3);
                        db.open(relationName);
                    }
                }

                //insert all into one relation
                Relation relation = new Relation("all");
                relation.setDomainMap(db.getRelationMap().get("ACCT").getDomainMap());
                db.getRelationMap().put("all", relation);

                for (int i = 0; i < listOfFiles.length; i++) {
                    String fileName = listOfFiles[i].getName();
                    String relationName = fileName.substring(0,fileName.length()-3);
                    db.insert("all", relationName);
                }
            }
            else {
                db.open(ctx.getChild(1).accept(new GrammarVisitorString()));
            }
        }
        catch (Exception e) {
            return null;
        }
        return null;
    }

    @Override
    public Void visitClose_cmd(GrammarParser.Close_cmdContext ctx) {
        try {
            db.close(ctx.getChild(1).accept(new GrammarVisitorString()));
        }
        catch (Exception e) {
            return null;
        }
        return null;
    }

    @Override
    public Void visitWrite_cmd(GrammarParser.Write_cmdContext ctx) {
        try {
            db.write(ctx.getChild(1).accept(new GrammarVisitorString()));
        }
        catch (Exception e) {
            return null;
        }

        return null;
    }

    @Override
    public Void visitExit_cmd(GrammarParser.Exit_cmdContext ctx) {
        try{
            db.exit();
        }
        catch (Exception e) {
            return null;
        }

        return null;
    }

    @Override
    public Void visitShow_cmd(GrammarParser.Show_cmdContext ctx) {
        try {
            db.show(ctx.getChild(1).accept(new GrammarVisitorString()));
        }
        catch (Exception e) {
            return null;
        }

        return null;
    }

    @Override
    public Void visitCreate_cmd(GrammarParser.Create_cmdContext ctx) {
        String relationName = ctx.getChild(1).accept(new GrammarVisitorString());
        Vector<Domain<?>> typedAttrList = ctx.getChild(3).accept(new GrammarVisitorDomainList());
        Vector<String> key = ctx.getChild(7).accept(new GrammarVisitorAttributeList());

        try {
            db.create(relationName, typedAttrList, key.get(0));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Void visitUpdate_cmd(GrammarParser.Update_cmdContext ctx) {
        String relationName = ctx.getChild(1).accept(new GrammarVisitorString());
        Vector<Attribute> attrList = new Vector<Attribute>();
        Vector<Object> values = new Vector<Object>();
        Vector<String> condition = new Vector<String>(ctx.getChild(ctx.getChildCount()-1).accept(new GrammarVisitorAttributeList()));

        for (int i = 0; i < ctx.getChildCount() - 5; i+=4) {
            if (ctx.getChild(i).getText().matches("^-?\\d+$")) {
                values.add(Integer.parseInt(ctx.getChild(i+5).getText())); //literal
                Domain<?> domain = new Domain<Integer>(Integer.class, ctx.getChild(i+3).getText());
                attrList.add(new Attribute(domain, ctx.getChild(i+5).getText())); //attribute_name
            }
            else {
                values.add(ctx.getChild(i+5).getText()); //literal
                Domain<?> domain = new Domain<String>(String.class, ctx.getChild(i+3).getText());
                attrList.add(new Attribute(domain, ctx.getChild(i+5).getText())); //attribute_name
            }
        }

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

        for (int i = 0; i < attrList.size(); i++) {
            db.update(relationName, attrList.get(i), values.get(i), attrComp, condition.get(1), condition.get(2)); //FIXME
        }
        return null;
    }

    @Override
    public Void visitInsert_cmd(GrammarParser.Insert_cmdContext ctx) {
        String relationName = ctx.getChild(1).accept(new GrammarVisitorString());
        if (ctx.getChild(2).getText().equals("VALUES FROM RELATION")) {
            String relation = ctx.getChild(3).accept(new GrammarVisitorRelation(db)).getRelation();
            db.insert(relationName, relation);
        }
        else {
            Vector<Attribute> values = new Vector<Attribute>();
            for (int i = 4; i < ctx.getChildCount(); i+=2) {
                if (ctx.getChild(i).getText().matches("^-?\\d+$")) {
                    Domain<?> domain = new Domain<Integer>(Integer.class, ((Domain<Integer>)db.getRelationMap().get(relationName).getDomainMap().values().toArray()[(i-4)/2]).getName());
                    values.add(new Attribute(domain, ctx.getChild(i).getText()));
                }
                else {
                    Domain<?> domain = new Domain<String>(String.class, ((Domain<String>)db.getRelationMap().get(relationName).getDomainMap().values().toArray()[(i-4)/2]).getName());
                    values.add(new Attribute(domain, ctx.getChild(i).getText()));
                }

            }
            db.insert(relationName, values);
        }
        return null;
    }

    @Override
    public Void visitDelete_cmd(GrammarParser.Delete_cmdContext ctx) {
        String relationName = ctx.getChild(1).getText();
        Vector<String> condition = new Vector<String>(ctx.getChild(3).accept(new GrammarVisitorAttributeList()));

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

        db.delete(relationName, attrComp, condition.get(1), condition.get(2));

        return null;
    }

    @Override
    public Void visitQuery(GrammarParser.QueryContext ctx) {
        try {
            String relationName = ctx.getChild(0).accept(new GrammarVisitorString());
            Relation relation = new Relation(relationName);
            Relation old = ctx.getChild(2).accept(new GrammarVisitorRelation(db));
            relation.setDomainMap(old.getDomainMap());
            for (Map.Entry<Attribute, Tuple> attrTuplePair : old.getTuples().entrySet())
                relation.set(attrTuplePair.getKey(), attrTuplePair.getValue());
            relation.renameRelation(relationName);
            db.getRelationMap().put(relationName, relation);
            db.show(relationName);
        }
        catch (Exception e) {
            System.out.println("Cannot do query");
            return null;
        }

        return null;
    }
}
