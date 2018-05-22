package DBTypes;
import org.w3c.dom.Attr;

import java.io.*;
import java.util.*;
import java.util.Set;


public class Database {
    private Map<String, Relation> relationMap;
    private Vector<String> relationList;
    
    public Database() {
        relationMap = new HashMap<String, Relation>();
        relationList = new Vector<String>();
    }

    public Map<String, Relation> getRelationMap() { return relationMap; }
    public Vector<String> getRelationList() { return relationList; }

    //Opens a .db file specified by the relationName and loads into database
    public void open(String relationName) throws Exception {
        try {
            String relationFile = relationName + ".db";
            Scanner input = new Scanner(new FileInputStream(relationFile));
            String relation = input.nextLine();
            Vector<String> domainString = new Vector<String>();
            Vector<Vector<String>> tupleString = new Vector<Vector<String>>();
            Scanner lineScanner = new Scanner(input.nextLine());
            String line;

            //Get Domain Names
            while(lineScanner.hasNext() && (line = lineScanner.next()) != null) {
                domainString.add(line);
            }

            //Get Values
            while(input.hasNextLine()) {
                line = input.nextLine();
                lineScanner = new Scanner(line);
                Vector<String> temp = new Vector<String>();
                while(lineScanner.hasNext() && (line = lineScanner.next()) != null)
                    temp.add(line);
                tupleString.add(temp);
            }

            //Set up data into structures and load into database
            Vector<Domain<?>> domainMap = new Vector<Domain<?>>();
            for(int i = 0; i < domainString.size(); i++) {
                if(tupleString.get(0).get(i).matches("^-?\\d+$"))
                    domainMap.add(new Domain<Integer>(Integer.class, domainString.get(i)));
                else
                    domainMap.add(new Domain<String>(String.class, domainString.get(i)));
            }
            Vector<Attribute> attrList = new Vector<Attribute>();
            HashMap<Attribute, Tuple> tupleMap = new HashMap<>();
            for(int i = 0; i < tupleString.size(); i++) {
                for(int j = 0; j < tupleString.get(i).size(); j++) {
                    if(tupleString.get(i).get(j).matches("^-?\\d+$"))
                        attrList.add(new Attribute(domainMap.get(j), Integer.parseInt(tupleString.get(i).get(j))));
                    else
                        attrList.add(new Attribute(domainMap.get(j), tupleString.get(i).get(j)));
                }
                tupleMap.put(attrList.get(0), new Tuple(attrList));
                attrList.clear();
            }
            relationMap.put(relation, new Relation(relation, domainMap.get(0), tupleMap));

        }
        catch(IOException e) {
            System.out.println("Unable to get " + relationName);
            return;
        }
    }

    //Writes to and closes the .db specified by relationName
    public void close(String relationName) throws Exception {  //FIXME DONE?
        write(relationName);
        relationMap.remove(relationName);
    }

    //Writes table specified by relationName to the .db specified by relationName
    public void write(String relationName) throws Exception {  //FIXME ARE
        try {
            String relationFile = relationName + ".db";
            FileOutputStream output = new FileOutputStream(relationFile);
            Relation relationToWrite = relationMap.get(relationName);
            output.write(((String)(relationToWrite.getRelation() + "\n")).getBytes());
            for(Map.Entry<String, Domain> domain: relationToWrite.getDomainMap().entrySet())
                output.write(((String)(domain.getKey() + "\t")).getBytes());
            output.write(((String)("\n")).getBytes());
            int count = 0;

            //Format and write Tuples
            for(Map.Entry<Attribute, Tuple> attrTuplePair: relationToWrite.getTuples().entrySet()) {
                for(Map.Entry<String, Attribute> attr: attrTuplePair.getValue().getAttrMap().entrySet())
                    output.write(((String)(attr.getValue().getValue().toString() + "\t")).getBytes());
                if (count == relationToWrite.getTuples().size()) {
                    output.write(((String)("\n")).getBytes());
                }
                count++;
            }
            output.close();
        }
        catch(IOException e) {
            System.out.println("Unable to get " + relationName);
            return;
        }
    }

    //Writes everything in the database to their respective files and closes the program
    public void exit() throws Exception {  //FIXME DONE?
        for(int i = 0; i < relationList.size(); i++)
            write(relationList.get(i));
        relationList.clear();
    }

    //Prints out the relation specified in tabular format
    public void show(Relation relation) {  //FIXME ARE
        System.out.println(relation.getRelation() + "\n");
        for(Map.Entry<String, Domain> domain: relation.getDomainMap().entrySet())
            System.out.print(domain.getKey() + "\t");
        System.out.println("\n");
        for(Map.Entry<Attribute, Tuple> attrTuplePair: relation.getTuples().entrySet()) {
            for(Map.Entry<String, Attribute> attr: attrTuplePair.getValue().getAttrMap().entrySet())
                System.out.print(attr.getValue().getValue().toString() + "\t");
            System.out.println("\n");
        }
    }

    //Creates a Relation in database with domainList and key
    public void create(String relationName, Vector<Domain<?>> domainList, String key) {  //FIXME DONE?
        Domain<?> domainKey = null;
        if(relationMap.containsKey(relationName)) {
            System.out.println("Relation Exists\n");
            return;
        }
        for(int i = 0; i < domainList.size(); i++) {
            if(domainList.get(i).getName().equals(key)) {
                domainKey = domainList.get(i);
            }
        }

        relationMap.put(relationName, new Relation(relationName, domainKey, domainList));
    }

    //Finds all Tuples which satisfy the Attribute comparison (attributeComp (op) valueComp)
    //and then updates the attribute in relation specified by relationName with value
    public void update(String relationName, Attribute attribute, Object value,
                       Attribute attributeComp, String op, Object valueComp) {  //FIXME DONE?
        Relation relation = relationMap.get(relationName);
        Relation r = selection(relationName, attributeComp, op, valueComp);

        //For each Tuple's Attributes, checks if in search Relation, if so, changes value to new value
        for(Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
            for(Map.Entry<String, Attribute> attr : attrTuplePair.getValue().getAttrMap().entrySet()) {
                for (Map.Entry<Attribute, Tuple> attrTuplePair2 : r.getTuples().entrySet()) {
                    for (Map.Entry<String, Attribute> attr2 : attrTuplePair.getValue().getAttrMap().entrySet()) {
                        if (attr.getValue().equal(attribute) && attr.getValue().getDomain().equal(attr2.getValue().getDomain())){
                            attr.getValue().setValue(value);
                        }
                    }
                }
            }
        }

        relationMap.put(relation.getRelation(), relation);
    }

    //Inserts a Vector of Attributes into a Relation
    public void insert(String relationName, Vector<Attribute> attrList) {
        Relation relation = relationMap.get(relationName);
        Tuple tuple = new Tuple(attrList);
        relation.set(attrList.get(0), tuple);
    }

    //Inserts all the Tuples into a Relation from another Relation
    public void insert(String relationName, String relationFrom) {
        Relation rFrom = relationMap.get(relationFrom);
        Relation relation = relationMap.get(relationName);
        for (Map.Entry<Attribute, Tuple> attrTuplePair : rFrom.getTuples().entrySet())
        {
            relation.set(attrTuplePair.getKey(), attrTuplePair.getValue());
        }
    }

    //Deletes Tuples from Relation which meet the Attribute comparison
    public void delete(String relationName, Attribute attribute, String op, Object value) {  //FIXME
        Relation relation = relationMap.get(relationName);
        Relation r = selection(relationName, attribute, op, value);
        for (Attribute attribute1 : r.getTuples().keySet()) {
            relation.deleteTuple(attribute1);
        }
    }

    //Returns a Relation of Tuples which satisfies the Attribute comparison from a given Relation
    //FIXME: Change to search if Domain is equal
    public Relation selection(String relationName, Attribute attribute, String op, Object value) {
        Relation relation = relationMap.get(relationName);
        Relation r = new Relation("Select");
        //compare differently depending on op argument
        switch (op) {
            case "==": {
                for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
                    if (attrTuplePair.getValue().getAttrMap().containsValue(attribute)) {
                        //Compares value of attribute in relation to value in argument
                        if (attrTuplePair.getValue().getAttrMap().get(attribute.getDomain().getName()).getValue().equals(value)) {
                            r.set(attrTuplePair.getKey(), attrTuplePair.getValue());
                        }

                    }
                }
                break;
            }

            case "!=": {
                for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
                    if (attrTuplePair.getValue().getAttrMap().containsValue(attribute)) {
                        //Compares value of attribute in relation to value in argument
                        if (!attrTuplePair.getValue().getAttrMap().get(attribute.getDomain().getName()).getValue().equals(value)) {
                            r.set(attrTuplePair.getKey(), attrTuplePair.getValue());
                        }

                    }
                }
                break;
            }

            case ">": {
                for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
                    if (attrTuplePair.getValue().getAttrMap().containsValue(attribute)) {
                        //Compares value of attribute in relation to value in argument
                        if (compareTo(attrTuplePair.getValue().getAttrMap().get(attribute.getDomain().getName()).getValue(),
                                value,
                                attrTuplePair.getKey().getDomain()) > 0) {
                            r.set(attrTuplePair.getKey(), attrTuplePair.getValue());
                        }

                    }
                }
                break;
            }

            case ">=": {
                for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
                    if (attrTuplePair.getValue().getAttrMap().containsValue(attribute)) {
                        //Compares value of attribute in relation to value in argument
                        if (compareTo(attrTuplePair.getValue().getAttrMap().get(attribute.getDomain().getName()).getValue(),
                                value,
                                attrTuplePair.getKey().getDomain()) >= 0) {
                            r.set(attrTuplePair.getKey(), attrTuplePair.getValue());
                        }

                    }
                }
            }

            case "<": {
                for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
                    if (attrTuplePair.getValue().getAttrMap().containsValue(attribute)) {
                        //Compares value of attribute in relation to value in argument
                        if (compareTo(attrTuplePair.getValue().getAttrMap().get(attribute.getDomain().getName()).getValue(),
                                value,
                                attrTuplePair.getKey().getDomain()) < 0) {
                            r.set(attrTuplePair.getKey(), attrTuplePair.getValue());
                        }

                    }
                }
                break;
            }

            case "<=": {
                for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
                    if (attrTuplePair.getValue().getAttrMap().containsValue(attribute)) {
                        //Compares value of attribute in relation to value in argument
                        if (compareTo(attrTuplePair.getValue().getAttrMap().get(attribute.getDomain().getName()).getValue(),
                                value,
                                attrTuplePair.getKey().getDomain()) <= 0) {
                            r.set(attrTuplePair.getKey(), attrTuplePair.getValue());
                        }

                    }
                }
                break;
            }
        }

        return r;
    }

    //Takes a Relation and a Vector of Attribute Names and returns a new Relation of only
    //the specified Attributes
    public Relation projection(String relationName, Vector<String> attrNames) {
        Relation relation = relationMap.get(relationName);
        //Check if relation contains all attributes
        for(Attribute attribute : relation.getTuples().keySet()) {
            if(!attrNames.contains(attribute.getValue())) {
                return null;
            }
        }

        //Create tuples consisting of attributes, add to new relation
        Relation r = new Relation("projection from " + relation.getRelation());
        for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
            Vector<Attribute> attrList = new Vector<Attribute>();
            for (String attrName : attrNames) {
                attrList.add(attrTuplePair.getValue().get(attrName));
            }
            r.set(attrList.get(0), new Tuple(attrList));
        }

        return r;
    }

    //Renames the Attribute in the Relation from old to newName
    public void renaming(String relationName, String old, String newName) {
        Relation relation = relationMap.get(relationName);
        relation.rename(old, newName);
    }

    //Computes the union between two Relations and returns the new Relation
    public Relation union(String relationName1, String relationName2) {  //FIXME
        Relation relation1 = relationMap.get(relationName1);
        Relation relation2 = relationMap.get(relationName2);
        Relation relation = new Relation("union");

        //Get the union of the domains
        HashSet<Domain> domains = new HashSet<Domain>();
        for (Domain domain1 : relation1.getDomainMap().values()) {
            for (Domain domain2 : relation2.getDomainMap().values()) {
                if (domain1.equal(domain2)) {
                    domains.add(domain1);
                }
            }
        }

        //Add all tuples in relation1 with a Domain from domains to the returned relation
        for (Map.Entry<Attribute, Tuple> mAttrTuplePair : relation1.getTuples().entrySet()) {
            for (Map.Entry<String, Attribute> mAttribute : mAttrTuplePair.getValue().getAttrMap().entrySet()){
                for (Domain domain : domains) {
                    if (domain.equal(mAttribute.getValue().getDomain())) {
                        Vector<Attribute> v = new Vector<Attribute>();
                        v.add(new Attribute(domain, mAttribute.getValue().getValue()));
                        Tuple t = new Tuple(v);
                        relation.set(mAttribute.getValue(), t);
                    }
                }
            }
        }

        //Add all tuples in relation2 with a Domain from domains to the returned relation
        for (Map.Entry<Attribute, Tuple> mAttrTuplePair : relation2.getTuples().entrySet()) {
            for (Map.Entry<String, Attribute> mAttribute : mAttrTuplePair.getValue().getAttrMap().entrySet()){
                for (Domain domain : domains) {
                    if (domain.equal(mAttribute.getValue().getDomain())) {
                        Vector<Attribute> v = new Vector<Attribute>();
                        v.add(new Attribute(domain, mAttribute.getValue().getValue()));
                        Tuple t = new Tuple(v);
                        relation.set(mAttribute.getValue(), t);
                    }
                }
            }
        }

        return relation;
    }

    //Computes the difference between two Relations and returns the new Relation
    public Relation difference(String relationName1, String relationName2) {
        Relation relation1 = relationMap.get(relationName1);
        Relation relation2 = relationMap.get(relationName2);
        Relation relation = new Relation("difference");

        //Get Difference of Domain Names
        HashSet<String> domainNames = new HashSet<String>();
        domainNames.addAll(relation1.getDomainMap().keySet());
        domainNames.addAll(relation2.getDomainMap().keySet());
        HashSet<String> intersect = new HashSet<String>(relation1.getDomainMap().keySet());
        intersect.retainAll(relation2.getDomainMap().keySet());
        domainNames.removeAll(intersect);

        //Convert to Set of Domains from Domain Names
        HashSet<Domain> domains = new HashSet<Domain>();
        for (String s : domainNames) {
            if (relation1.getDomainMap().keySet().contains(s)) {
                domains.add(relation1.getDomainMap().get(s));
            }
            else {
                domains.add(relation2.getDomainMap().get(s));
            }

        }

        //Add all tuples in relation1 with a Domain from domains to the returned relation
        for (Map.Entry<Attribute, Tuple> mAttrTuplePair : relation1.getTuples().entrySet()) {
            for (Map.Entry<String, Attribute> mAttribute : mAttrTuplePair.getValue().getAttrMap().entrySet()){
                for (Domain domain : domains) {
                    if (domain.equal(mAttribute.getValue().getDomain())) {
                        Vector<Attribute> v = new Vector<Attribute>();
                        v.add(new Attribute(domain, mAttribute.getValue().getValue()));
                        Tuple t = new Tuple(v);
                        relation.set(mAttribute.getValue(), t);
                    }
                }
            }
        }

        //Add all tuples in relation2 with a Domain from domains to the returned relation
        for (Map.Entry<Attribute, Tuple> mAttrTuplePair : relation2.getTuples().entrySet()) {
            for (Map.Entry<String, Attribute> mAttribute : mAttrTuplePair.getValue().getAttrMap().entrySet()){
                for (Domain domain : domains) {
                    if (domain.equal(mAttribute.getValue().getDomain())) {
                        Vector<Attribute> v = new Vector<Attribute>();
                        v.add(new Attribute(domain, mAttribute.getValue().getValue()));
                        Tuple t = new Tuple(v);
                        relation.set(mAttribute.getValue(), t);
                    }
                }
            }
        }

        return relation;
    }

    //Computes the Cartesian Product of two Relations and returns the new Relation
    public Relation product(String relationName1, String relationName2) {
        Relation relation1 = relationMap.get(relationName1);
        Relation relation2 = relationMap.get(relationName2);

        //Create new relation comprised of every combination of concatenated tuples in relations 1 and 2
        Relation r = new Relation("Cartesian Product of " + relation1.getRelation() + " and " + relation2.getRelation());
        for (Map.Entry<Attribute, Tuple> attrTuplePair1 : relation1.getTuples().entrySet()) {
            for (Map.Entry<Attribute, Tuple> attrTuplePair2 : relation2.getTuples().entrySet()) {
                Vector<Attribute> v = new Vector<Attribute>(attrTuplePair1.getValue().getAttrMap().values());
                v.addAll(attrTuplePair2.getValue().getAttrMap().values());      //get all attributes
                r.set(new Attribute(v.get(0).getDomain(), v.get(0).getValue()), new Tuple(v));
            }
        }
        return r;
    }

    //Utility to compare either Strings or Integers
    private int compareTo(Object o1, Object o2, Domain<?> domain) {
        if (domain.getType() == Integer.class) {
            return (Integer)o1 - (Integer)o2;
        }
        else {
            return ((String)o1).compareTo((String)o2);
        }
    }
}
