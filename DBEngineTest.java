import DBTypes.*;
import Grammar.*;
import org.w3c.dom.Attr;

import javax.naming.directory.AttributeInUseException;
import java.io.*;
import java.util.Map;
import java.util.Vector;
import java.util.Scanner;

/* Tests all functionality of the Database Engine. Each of the test methods
 *  return 0 if passed, return 1 if failed. Prints out which tests failed.*/
public class DBEngineTest {

    public static void main(String[] args) throws Exception {
        new DBEngineTest();
    }

    public DBEngineTest() throws Exception {
        int numFailed = 0;
        numFailed += RelationTest();
        numFailed += AttributeTest(); //YAY
        numFailed += TupleTest();     //YAY
        numFailed += IOTest();
        numFailed += CloseTest();
        numFailed += ExitTest();
        numFailed += RenameTest();
        numFailed += CreateTest();
        numFailed += UpdateTest();
        numFailed += InsertTest();
        numFailed += DeleteTest();
        numFailed += QueryTest();
        numFailed += UnionDifferenceProductTest();
        System.out.println("Number of tests failed: " + numFailed);
    }

    private int RelationTest() {
        Vector<Domain<?>> attrList = new Vector<Domain<?>>();
        attrList.add(new Domain<String>(String.class, "Name"));
        attrList.add(new Domain<String>(String.class, "Kind"));
        attrList.add(new Domain<Integer>(Integer.class, "Years"));

        // Create relation table
        Relation relation1 = new Relation("Dogs",
                new Domain<String>(String.class, "Name"),   // Primary Key
                attrList);

        if (relation1.getRelation() != "Dogs") {
            System.out.println("Failed: RelationTest() Relation Creation");
            return 1;
        }

        // Creates a tuple with only 2 attributes
        Vector<Attribute> tuple = new Vector<Attribute>();
        tuple.add(new Attribute(new Domain<String>(String.class, "Kind"), "Dog"));
        tuple.add(new Attribute(new Domain<Integer>(Integer.class, "Years"), 20));


        // Insert row
        Attribute attr = new Attribute(new Domain<String>(String.class, "Name"), "Alex");
        relation1.set(attr, new Tuple(tuple));

        // Tests relation set
        if (relation1.getTuples().size() == 0) {
            System.out.println("Failed 1: RelationTest() Row Insertion");
            return 1;
        }

        relation1.rename("Kind", "Species");

        relation1.deleteTuple(new Attribute(new Domain<String>(String.class, "Name"), "Alex"));

        relation1.renameRelation("Animals");

        //System.out.println(relation1.getTuples().size());

        // Tests relation renaming
        if (relation1.getRelation() != "Animals") {
            System.out.println("Failed: RelationTest() Relation Renaming");
            return 1;
        }

        // Tests relation deletion
        //relation1.selectByAttribute(new Attribute(new Domain<String>(String.class, "Name"), "Alex")).size() != 0
        if (relation1.getTuples().size() != 0) {
            //System.out.println(relation1.getTuples().size());
            System.out.println("Failed: RelationTest() Deletion");
            return 1;
        }

        return 0;
    }

    private int AttributeTest() {
        Attribute attribute1 = new Attribute(new Domain<String>(String.class, "Name"), "Joe");
        attribute1.setValue("John");
        if (attribute1.getValue() != "John") {
            System.out.println("Failed: AttributeTest()");
            return 1;
        }

        return 0;
    }

    private int TupleTest() {

//-------------------TUPLE CREATIONS--------------------------------------//
        Vector<Attribute> attrList = new Vector<Attribute>();
        attrList.add(new Attribute(new Domain<String>(String.class, "Name"), "Alex"));
        attrList.add(new Attribute(new Domain<String>(String.class, "Kind"), "Dog"));
        attrList.add(new Attribute(new Domain<Integer>(Integer.class, "Years"), 20));
        Tuple tuple1 = new Tuple(attrList);

        Vector<Attribute> attrList2 = new Vector<Attribute>();
        attrList2.add(new Attribute(new Domain<String>(String.class, "Name"), "Alex"));
        attrList2.add(new Attribute(new Domain<String>(String.class, "Kind"), "Dog"));
        attrList2.add(new Attribute(new Domain<Integer>(Integer.class, "Years"), 20));
        Tuple tuple2 = new Tuple(attrList2);

        Vector<Attribute> attrList3 = new Vector<Attribute>();
        attrList3.add(new Attribute(new Domain<String>(String.class, "Name"), "Ben"));
        attrList3.add(new Attribute(new Domain<String>(String.class, "Kind"), "Cat"));
        attrList3.add(new Attribute(new Domain<Integer>(Integer.class, "Years"), 10));
        Tuple tuple3 = new Tuple(attrList3);
//------------------------------------------------------------------------//

        Vector<String> keys = new Vector<String>();
        keys.add("Name");
        keys.add("Species");
        keys.add("Years");

        Vector<Object> values = new Vector<Object>();
        values.add("Ben");
        values.add("Cat");
        values.add("10");

        tuple1.rename("Kind", "Species");
        tuple1.refactor(keys, values);

        if (tuple2.equal(tuple1) | tuple2.get("Name").getValue() == "Ben") {
            System.out.println("Failed: TupleTest()");
            return 1;
        }

        // Add another test to make sure kind was changed to species

        return 0;
    }

    private int CreateTest() throws Exception {
        Database db = new Database();
        String relationName = "table";

        //Create Table
        Vector<Domain<?>> domainList = new Vector<Domain<?>>();
        domainList.add(new Domain<String>(String.class, "Name"));
        domainList.add(new Domain<String>(String.class, "Kind"));
        domainList.add(new Domain<Integer>(Integer.class, "Years"));
        db.create(relationName, domainList, domainList.get(0).getName());
        Vector<String> domainNames = new Vector<String>();
        domainNames.add("Name");
        domainNames.add("Kind");
        domainNames.add("Years");

        for (Attribute attribute : db.getRelationMap().get(relationName).getTuples().keySet()) {
            if (!domainNames.contains(attribute.getDomain().getName())) {
                System.out.println("Failed: CreateTest() Creation");
                return 1;
            }
        }
        return 0;
    }

    private int IOTest() throws Exception {
        //Create Table
        Database db = new Database();
        String relationName = "table";
        Vector<Domain<?>> domainList = new Vector<Domain<?>>();
        domainList.add(new Domain<String>(String.class, "Name"));
        domainList.add(new Domain<String>(String.class, "Kind"));
        domainList.add(new Domain<Integer>(Integer.class, "Years"));
        db.create(relationName, domainList, domainList.get(0).getName());
        Vector<String> domainNames = new Vector<String>();
        domainNames.add("Name");
        domainNames.add("Kind");
        domainNames.add("Years");

        //Insert Tuple
        Vector<Attribute> attrList = new Vector<Attribute>();
        attrList.add(new Attribute(new Domain<String>(String.class, "Name"), "Alex"));
        attrList.add(new Attribute(new Domain<String>(String.class, "Kind"), "Dog"));
        attrList.add(new Attribute(new Domain<Integer>(Integer.class, "Years"), 20));
        db.insert(relationName, attrList);

        //Write to File and Reopen, check if new database from open matches old
        db.write("table");
        Database db2 = new Database();
        db2.open("table");
        for (Attribute attribute : db2.getRelationMap().get(relationName).getTuples().keySet()) {
            if (!domainNames.contains(attribute.getDomain().getName())) {
                System.out.println("Failed: IOTest() Retrieval");
                return 1;
            }
        }

        return 0;
    }

    private int CloseTest() throws Exception{
        //Create Table
        Database db = new Database();
        String relationName = "table";
        Vector<Domain<?>> domainList = new Vector<Domain<?>>();
        domainList.add(new Domain<String>(String.class, "Name"));
        domainList.add(new Domain<String>(String.class, "Kind"));
        domainList.add(new Domain<Integer>(Integer.class, "Years"));
        db.create(relationName, domainList, domainList.get(0).getName());

        db.close("table");
        if (db.getRelationMap().size() != 0) {
            System.out.println("Failed: CloseTest() Size");
            return 1;
        }
        return 0;
    }

    private int ExitTest() throws Exception {
        //Create Table
        Database db = new Database();
        String relationName = "table";
        Vector<Domain<?>> domainList = new Vector<Domain<?>>();
        domainList.add(new Domain<String>(String.class, "Name"));
        domainList.add(new Domain<String>(String.class, "Kind"));
        domainList.add(new Domain<Integer>(Integer.class, "Years"));
        db.create(relationName, domainList, domainList.get(0).getName());

        db.close("table");
        if (db.getRelationMap().size() != 0) {
            System.out.println("Failed: ExitTest() Size");
            return 1;
        }
        return 0;
    }

    private int RenameTest() {
        //Create Table
        Database db = new Database();
        String relationName = "table";
        Vector<Domain<?>> domainList = new Vector<Domain<?>>();
        domainList.add(new Domain<String>(String.class, "Name"));
        domainList.add(new Domain<String>(String.class, "Kind"));
        domainList.add(new Domain<Integer>(Integer.class, "Years"));
        db.create(relationName, domainList, domainList.get(0).getName());

        //Insert Tuple
        Vector<Attribute> attrList = new Vector<Attribute>();
        attrList.add(new Attribute(new Domain<String>(String.class, "Name"), "Alex"));
        attrList.add(new Attribute(new Domain<String>(String.class, "Kind"), "Dog"));
        attrList.add(new Attribute(new Domain<Integer>(Integer.class, "Years"), 20));
        Tuple t = new Tuple(attrList);
        db.insert(relationName, attrList);

        db.renaming(relationName, "Kind", "Species");
        db.show(db.getRelationMap().get("table"));
        for (Map.Entry<String, Domain> mDomain : db.getRelationMap().get("table").getDomainMap().entrySet()) {
            if (mDomain.getKey() == "Species") {
                return 0;
            }
        }

        System.out.println("Failed: RenameTest() Comparison");
        return 1;
    }

    private int UpdateTest() {
        //Create Table
        Database db = new Database();
        String relationName = "table";
        Vector<Domain<?>> domainList = new Vector<Domain<?>>();
        domainList.add(new Domain<String>(String.class, "Name"));
        domainList.add(new Domain<String>(String.class, "Kind"));
        domainList.add(new Domain<Integer>(Integer.class, "Years"));
        db.create(relationName, domainList, domainList.get(0).getName());

        //Create Tuple
        Vector<Attribute> attrList = new Vector<Attribute>();
        attrList.add(new Attribute(new Domain<String>(String.class, "Name"), "Alex"));
        attrList.add(new Attribute(new Domain<String>(String.class, "Kind"), "Dog"));
        attrList.add(new Attribute(new Domain<Integer>(Integer.class, "Years"), 20));
        Tuple t = new Tuple(attrList);

        db.insert(relationName, attrList);
        db.update(relationName, attrList.get(0), "Aleks", attrList.get(1), "==", "Dog");
        if (!db.getRelationMap().get("table").getTuples().get(attrList.get(0)).getAttrMap()
                .get("Name").getValue().equals("Aleks")){
            System.out.println("Failed: UpdateTest()");
            return 1;
        }

        return 0;
    }

    private int InsertTest() {
        //Create Table
        Database db = new Database();
        String relationName = "table";
        Vector<Domain<?>> domainList = new Vector<Domain<?>>();
        domainList.add(new Domain<String>(String.class, "Name"));
        domainList.add(new Domain<String>(String.class, "Kind"));
        domainList.add(new Domain<Integer>(Integer.class, "Years"));
        db.create(relationName, domainList, domainList.get(0).getName());

        //Insert Tuple
        Vector<Attribute> attrList = new Vector<Attribute>();
        attrList.add(new Attribute(new Domain<String>(String.class, "Name"), "Alex"));
        attrList.add(new Attribute(new Domain<String>(String.class, "Kind"), "Dog"));
        attrList.add(new Attribute(new Domain<Integer>(Integer.class, "Years"), 20));
        Tuple t = new Tuple(attrList);
        db.insert(relationName, attrList);

        for (Attribute attribute : db.getRelationMap().get(relationName).getTuples().keySet()) {
            if (!attrList.contains(attribute)) {
                System.out.println("Failed: InsertTest() Insert Attribute List");
                return 1;
            }
        }

        //Test Insert From Relation
        Vector<Domain<?>> domainList2 = new Vector<Domain<?>>();
        domainList2.add(new Domain<String>(String.class, "Color"));
        attrList.add(new Attribute(domainList2.get(0), "Brown"));
        db.create("table2", domainList2, domainList2.get(0).getName());
        db.insert("table2", relationName);

        for (Attribute attribute : db.getRelationMap().get("table2").getTuples().keySet()) {
            if (!attrList.contains(attribute)) {
                System.out.println("Failed: InsertTest() Insert Relation From");
                return 1;
            }
        }

        return 0;
    }

    private int DeleteTest() {
        //Create Table
        Database db = new Database();
        String relationName = "table";
        Vector<Domain<?>> domainList = new Vector<Domain<?>>();
        domainList.add(new Domain<String>(String.class, "Name"));
        domainList.add(new Domain<String>(String.class, "Kind"));
        domainList.add(new Domain<Integer>(Integer.class, "Years"));
        db.create(relationName, domainList, domainList.get(0).getName());

        //Insert Table
        Vector<Attribute> attrList = new Vector<Attribute>();
        attrList.add(new Attribute(new Domain<String>(String.class, "Name"), "Alex"));
        attrList.add(new Attribute(new Domain<String>(String.class, "Kind"), "Dog"));
        attrList.add(new Attribute(new Domain<Integer>(Integer.class, "Years"), 20));
        Tuple t = new Tuple(attrList);
        db.insert(relationName, attrList);

        db.delete(relationName, attrList.get(2), "==", 20);
        if (db.getRelationMap().get(relationName).getTuples().containsKey(attrList.get(0))) {
            System.out.println("Failed: DeleteTest()");
            return 1;
        }
        return 0;
    }

    private int QueryTest() {
        Database db = new Database();

        //Create Table 1
        Vector<Domain<?>> domainList = new Vector<Domain<?>>();
        domainList.add(new Domain<String>(String.class, "Name"));
        domainList.add(new Domain<String>(String.class, "Kind"));
        domainList.add(new Domain<Integer>(Integer.class, "Years"));
        db.create("table1", domainList, domainList.get(0).getName());

        //Insert into Table 1
        Vector<Attribute> attrList = new Vector<Attribute>();
        attrList.add(new Attribute(new Domain<String>(String.class, "Name"), "Alex"));
        attrList.add(new Attribute(new Domain<String>(String.class, "Kind"), "Dog"));
        attrList.add(new Attribute(new Domain<Integer>(Integer.class, "Years"), 20));
        db.insert("table1", attrList);

        //Insert second Attribute
        Vector<Attribute> attrList2 = new Vector<Attribute>();
        attrList2.add(new Attribute(new Domain<String>(String.class, "Name"), "Davis"));
        attrList2.add(new Attribute(new Domain<String>(String.class, "Kind"), "Dog"));
        attrList2.add(new Attribute(new Domain<Integer>(Integer.class, "Years"), 10));
        Tuple t = new Tuple(attrList2);
        db.insert("table1", attrList2);

        Relation temp = db.selection("table1", attrList2.get(0), "==", "Davis");
        Tuple t2 = temp.getTuples().get(attrList2.get(0));
        if (!t.equal(t2)) {
            System.out.println("Failed: QueryTest()");
            return 1;
        }

        return 0;
    }

    private int UnionDifferenceProductTest() {
        Database db = new Database();

        //Create Table 1
        Vector<Domain<?>> domainList = new Vector<Domain<?>>();
        domainList.add(new Domain<String>(String.class, "Name"));
        domainList.add(new Domain<String>(String.class, "Kind"));
        domainList.add(new Domain<Integer>(Integer.class, "Years"));
        db.create("table1", domainList, domainList.get(0).getName());

        //Insert into Table 1
        Vector<Attribute> attrList = new Vector<Attribute>();
        attrList.add(new Attribute(new Domain<String>(String.class, "Name"), "Alex"));
        attrList.add(new Attribute(new Domain<String>(String.class, "Kind"), "Dog"));
        attrList.add(new Attribute(new Domain<Integer>(Integer.class, "Years"), 20));
        db.insert("table1", attrList);

        //Create Table 2
        Vector<Domain<?>> domainList2 = new Vector<Domain<?>>();
        domainList2.add(new Domain<String>(String.class, "Name"));
        domainList2.add(new Domain<String>(String.class, "Color"));
        db.create("table2", domainList2, domainList2.get(0).getName());

        //Insert into Table 2
        Vector<Attribute> attrList2 = new Vector<Attribute>();
        attrList2.add(new Attribute(new Domain<String>(String.class, "Name"), "Davis"));
        attrList2.add(new Attribute(new Domain<String>(String.class, "Color"), "Brown"));
        db.insert("table2", attrList2);

        //Compare union against the correct Tuples
        Relation temp = db.union("table1", "table2");
        Vector<Attribute> v1 = new Vector<Attribute>();
        v1.add(attrList.get(0));
        Tuple t1 = new Tuple(v1);
        Vector<Attribute> v2 = new Vector<Attribute>();
        v1.add(attrList2.get(0));
        Tuple t2 = new Tuple(v2);

        if (temp.getTuples().get(attrList.get(0)).equal(t1) && temp.getTuples().get(attrList2.get(0)).equal(t2)) {
            System.out.println("Failed: UnionDifferenceProductTest() Union");
            return 1;
        }

        //Compare Difference against the correct Tuples
        Relation temp2 = db.difference("table1", "table2");
        Vector<Attribute> v3 = new Vector<Attribute>();
        v1.add(attrList.get(1));
        Tuple t3 = new Tuple(v1);
        Vector<Attribute> v4 = new Vector<Attribute>();
        v1.add(attrList.get(2));
        Tuple t4 = new Tuple(v2);
        Vector<Attribute> v5 = new Vector<Attribute>();
        v1.add(attrList2.get(1));
        Tuple t5 = new Tuple(v2);

        if (temp2.getTuples().get(attrList.get(1)).equal(t3) &&
                temp2.getTuples().get(attrList.get(2)).equal(t4) &&
                temp2.getTuples().get(attrList2.get(1)).equal(t5)) {
            System.out.println("Failed: UnionDifferenceProductTest() Difference");
            return 1;
        }

        //Create Table 3
        Vector<Domain<?>> domainList3 = new Vector<Domain<?>>();
        domainList3.add(new Domain<String>(String.class, "Color"));
        db.create("table3", domainList3, domainList3.get(0).getName());

        //Insert 2 tuples
        Vector<Attribute> attrList3 = new Vector<Attribute>();
        attrList3.add(new Attribute(new Domain<String>(String.class, "Color"), "Brown"));
        db.insert("table3", attrList3);
        Vector<Attribute> attrList4 = new Vector<Attribute>();
        attrList4.add(new Attribute(new Domain<String>(String.class, "Color"), "Blue"));
        db.insert("table3", attrList4);

        //Check if Product Tuples are correct size
        Relation temp3 = db.product("table1", "table3");
        for (Map.Entry<Attribute, Tuple> attrTuplePair : temp3.getTuples().entrySet()) {
            if (attrTuplePair.getValue().size() != 4) {
                System.out.println("Failed: UnionDifferenceProductTest() Product");
                return 1;
            }
        }

        return 0;
    }
}