package DBTypes;

import org.w3c.dom.Attr;

import java.io.*;
import java.util.*;


public class Database {
    private LinkedHashMap<String, Relation> relationMap;

    public Database() {
        relationMap = new LinkedHashMap<String, Relation>();
    }

    public LinkedHashMap<String, Relation> getRelationMap() {
        return relationMap;
    }

    // Opens a .db file specified by the relationName and loads into database
    public void open(String relationName) throws Exception {
        try {
            String relationFile = "RelationFiles/" + relationName + ".db";
            Scanner input = new Scanner(new FileInputStream(relationFile));
            relationName = input.nextLine();
            Vector<String> domainString = new Vector<String>();
            Vector<Vector<String>> tupleString = new Vector<Vector<String>>();
            Scanner lineScanner = new Scanner(input.nextLine());
            String line;

            // Get Domain Names
            while (lineScanner.hasNext() && (line = lineScanner.next()) != null) {
                domainString.add(line);
            }

            // Get Values
            while (input.hasNextLine()) {
                line = input.nextLine();
                lineScanner = new Scanner(line);
                Vector<String> temp = new Vector<String>();
                while (lineScanner.hasNext() && (line = lineScanner.next()) != null)
                    temp.add(line);
                tupleString.add(temp);
            }

            // Set up data into structures and load into database
            Vector<Domain<?>> domainMap = new Vector<Domain<?>>();
            
            for (int i = 0; i < domainString.size(); i++) {
                if (tupleString.get(0).get(i).matches("^-?\\d+$"))
                    domainMap.add(new Domain<Integer>(Integer.class, domainString.get(i)));
                else
                    domainMap.add(new Domain<String>(String.class, domainString.get(i)));
            }

            Vector<Attribute> attrList = new Vector<Attribute>();

            Relation relation = new Relation(relationName, domainMap.get(0), domainMap);
            for (int i = 0; i < tupleString.size(); i++) {
                
                for (int j = 0; j < tupleString.get(i).size(); j++) {
                
                    if (tupleString.get(i).get(j).matches("^-?\\d+$"))
                        attrList.add(new Attribute(domainMap.get(j), Integer.parseInt(tupleString.get(i).get(j))));
                    else
                        attrList.add(new Attribute(domainMap.get(j), tupleString.get(i).get(j).replaceAll("_", " ")));
                }
                relation.set(attrList.get(0), new Tuple(attrList));
                attrList.clear();
            }

            relationMap.put(relationName, relation);
        }
        catch (IOException e) {
            System.out.println("Unable to get " + relationName);
            return;
        }
    }

    // Writes to and closes the .db specified by relationName
    public void close(String relationName) throws Exception {
        write(relationName);
        relationMap.remove(relationName);
    }

    // Writes table specified by relationName to the .db specified by relationName
    public void write(String relationName) throws Exception {
        try {
            String relationFile = "RelationFiles/" + relationName + ".db";
            
            FileOutputStream output = new FileOutputStream(relationFile);
            
            Relation relationToWrite = relationMap.get(relationName);
            
            output.write((relationToWrite.getRelation() + "\n").getBytes());
            
            for (Map.Entry<String, Domain<?>> domain : relationToWrite.getDomainMap().entrySet())
                output.write((domain.getKey() + "\t\t").getBytes());
            output.write(("\n").getBytes());


            int numTuples = 0;
            // Format and write Tuples
            for (Map.Entry<Attribute, Tuple> attrTuplePair : relationToWrite.getTuples().entrySet()) {

                for (Map.Entry<String, Attribute> attr : attrTuplePair.getValue().getAttrMap().entrySet()) {
                    output.write((attr.getValue().getValue().toString().replaceAll(" ", "_") + "\t\t").getBytes());
                }

                if (numTuples != relationToWrite.getTuples().size()-1) {
                    output.write(("\n").getBytes());
                }
                numTuples++;
            }
            output.close();
        }
        catch (IOException e) {
            System.out.println("Unable to get " + relationName);
            return;
        }
    }

    // Writes everything in the database to their respective files 
    // and closes the program
    public void exit() throws Exception {
        for (Relation relation: relationMap.values())
            write(relation.getRelation());
        relationMap.clear();
    }

    // Prints out the relation specified in tabular format
    public void show(String relationName) throws Exception {
		try {
			//System.out.println(relation.getRelation() + "\n");
			Relation relation = relationMap.get(relationName);

            System.out.println("Relation: " + relationName + "\n");
			for (Map.Entry<String, Domain<?>> domain : relation.getDomainMap().entrySet())
				System.out.print(domain.getKey() + "\t\t");
			System.out.println("\n");
			
			for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
				for (Map.Entry<String, Attribute> attr : attrTuplePair.getValue().getAttrMap().entrySet())
					System.out.print(attr.getValue().getValue().toString() + "\t\t");
				System.out.println("\n");
			}
		}
		catch (Exception e) {
            System.out.println("Unable to get " + relationName);
            return;
        }
    }

    // Creates a Relation in database with domainList and key
    public void create(String relationName, Vector<Domain<?>> domainList, String key) {
        Domain<?> domainKey = null;
        
        if (relationMap.containsKey(relationName)) {
            System.out.println("Relation Exists\n");
            return;
        }
        
        for (int i = 0; i < domainList.size(); i++) {
            if (domainList.get(i).getName().equals(key)) {
                domainKey = domainList.get(i);
            }
        }

        relationMap.put(relationName, new Relation(relationName, domainKey, domainList));
    }

    // Finds all Tuples which satisfy the Attribute comparison (attributeComp (op) valueComp)
    // and then updates the attribute in relation specified by relationName with value
    public void update(String relationName, Attribute attribute, Object value,
                       Attribute attributeComp, String op, Object valueComp) {
        Relation relation = relationMap.get(relationName);
        Relation r = selection(relationName, attributeComp, op, valueComp);

        // For each Tuple's Attributes, checks if in search Relation, if so, changes value to new value
        for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
            for (Map.Entry<String, Attribute> attr : attrTuplePair.getValue().getAttrMap().entrySet()) {
                for (Map.Entry<Attribute, Tuple> attrTuplePair2 : r.getTuples().entrySet()) {
                    for (Map.Entry<String, Attribute> attr2 : attrTuplePair.getValue().getAttrMap().entrySet()) {
                        if (attr.getValue().equal(attr2.getValue()) && attr.getKey().equals(attribute.getDomain().getName())) {
                            attr.getValue().setValue(value);
                        }
                    }
                }
            }
        }

        relationMap.put(relation.getRelation(), relation);
    }

    // Inserts a Vector of Attributes into a Relation
    public void insert(String relationName, Vector<Attribute> attrList) {
        Relation relation = relationMap.get(relationName);
        Tuple tuple = new Tuple(attrList);
        relation.set(attrList.get(0), tuple);
    }

    // Inserts all the Tuples into a Relation from another Relation
    public void insert(String relationName, String relationFrom) {
        Relation rFrom = relationMap.get(relationFrom);
        Relation relation = relationMap.get(relationName);
        
        for (Map.Entry<Attribute, Tuple> attrTuplePair : rFrom.getTuples().entrySet()) {
            relation.set(attrTuplePair.getKey(), attrTuplePair.getValue());
        }
    }

    // Deletes Tuples from Relation which meet the Attribute comparison
    public void delete(String relationName, Attribute attribute, String op, Object value) {
        Relation relation = relationMap.get(relationName);
        Relation r = selection(relationName, attribute, op, value);

        //Check if tuple in relation matches tuple in r, if so, delete
        for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
            for (Map.Entry<String, Attribute> attr : attrTuplePair.getValue().getAttrMap().entrySet()) {
                for (Map.Entry<Attribute, Tuple> attrTuplePair2 : r.getTuples().entrySet()) {
                    for (Map.Entry<String, Attribute> attr2 : attrTuplePair.getValue().getAttrMap().entrySet()) {
                        if (attr.getValue().equal(attr2.getValue()) && attr.getKey().equals(attribute.getDomain().getName())) {
                            relation.deleteTuple(attrTuplePair.getKey());
                        }
                    }
                }
            }
        }

    }

    // Returns a Relation of Tuples which satisfies the Attribute comparison 
    // from a given Relation
    public Relation selection(String relationName, Attribute attribute, String op, Object value) {
        Relation relation = relationMap.get(relationName);
        Relation r = new Relation("select" + attribute.getDomain().getName());
        r.setDomainMap(relation.getDomainMap());

        //Change Attribute Value to appropriate type
        if (attribute.getValue().toString().matches("^-?\\d+$") && attribute.getDomain().getType() != Integer.class) {
            attribute.setValue(Integer.parseInt((String)attribute.getValue()));
            attribute.setDomain(new Domain<Integer>(Integer.class, attribute.getDomain().getName()));
            value = (Integer)attribute.getValue();
        }
        
        // Compare differently depending on op argument
        switch (op) {
            case "==": {
                for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
                    for (Attribute attr : attrTuplePair.getValue().getAttrMap().values()) {
                        if (attr.equal(attribute)) {
                            // Compares value of attribute in relation to value in argument
                            if (attrTuplePair.getValue().getAttrMap().get(attribute.getDomain().getName()).getValue().equals(value)) {
                                r.set(attrTuplePair.getKey(), attrTuplePair.getValue());
                            }

                        }
                    }
                }
                break;
            }

            case "!=": {
                for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
                    for (Attribute attr : attrTuplePair.getValue().getAttrMap().values()) {
                        if (attr.getDomain().equal(attribute.getDomain())) {
                            // Compares value of attribute in relation to value in argument
                            if (!attrTuplePair.getValue().getAttrMap().get(attribute.getDomain().getName()).getValue().equals(value)) {
                                r.set(attrTuplePair.getKey(), attrTuplePair.getValue());
                            }

                        }
                    }
                }
                break;
            }

            case ">": {
                for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
                    for (Attribute attr : attrTuplePair.getValue().getAttrMap().values()) {
                        if (attr.getDomain().equal(attribute.getDomain())) {
                            // Compares value of attribute in relation to value in argument
                            if (compareTo(attrTuplePair.getValue().getAttrMap().get(attribute.getDomain().getName()).getValue(),
                                    value,
                                    attribute.getDomain()) > 0) {
                                r.set(attrTuplePair.getKey(), attrTuplePair.getValue());
                            }
                        }
                    }
                }
                break;
            }

            case ">=": {
                for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
                    for (Attribute attr : attrTuplePair.getValue().getAttrMap().values()) {
                        if (attr.getDomain().equal(attribute.getDomain())) {
                            // Compares value of attribute in relation to value in argument
                            if (compareTo(attrTuplePair.getValue().getAttrMap().get(attribute.getDomain().getName()).getValue(),
                                    value,
                                    attribute.getDomain()) >= 0) {
                                r.set(attrTuplePair.getKey(), attrTuplePair.getValue());
                            }
                        }
                    }
                }
                break;
            }

            case "<": {
                for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
                    for (Attribute attr : attrTuplePair.getValue().getAttrMap().values()) {
                        if (attr.getDomain().equal(attribute.getDomain())) {
                            // Compares value of attribute in relation to value in argument
                            if (compareTo(attrTuplePair.getValue().getAttrMap().get(attribute.getDomain().getName()).getValue(),
                                    value,
                                    attribute.getDomain()) < 0) {
                                r.set(attrTuplePair.getKey(), attrTuplePair.getValue());
                            }
                        }
                    }
                }
                break;
            }

            case "<=": {
                for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
                    for (Attribute attr : attrTuplePair.getValue().getAttrMap().values()) {
                        if (attr.getDomain().equal(attribute.getDomain())) {
                            // Compares value of attribute in relation to value in argument
                            if (compareTo(attrTuplePair.getValue().getAttrMap().get(attribute.getDomain().getName()).getValue(),
                                    value,
                                    attribute.getDomain()) <= 0) {
                                r.set(attrTuplePair.getKey(), attrTuplePair.getValue());
                            }
                        }
                    }
                }
                break;
            }
        }

        relationMap.put(r.getRelation(), r);
        return r;
    }

    // Takes a Relation and a Vector of Attribute Names and returns a new 
    // Relation of only the specified Attributes
    public Relation projection(String relationName, Vector<String> attrNames) {
        Relation relation = relationMap.get(relationName);
        LinkedHashMap<String, Domain<?>> domains = new LinkedHashMap<>();

        // Check if relation contains all attributes
        for (String attrName : attrNames) {
            boolean match = false;
            for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
                for (Attribute attribute : attrTuplePair.getValue().getAttrMap().values()){
                    if (attrName.equals(attribute.getDomain().getName())) {
                        match = true;
                        domains.put(attrName, attribute.getDomain());
                    }
                }
            }
            if (!match) return null;
        }


        // Create tuples consisting of attributes, add to new relation
        Relation r = new Relation("projectionFrom" + relation.getRelation());
        r.setDomainMap(domains);

        for (String attrName : attrNames) {
            Domain<String> dummy = new Domain<String>(String.class, attrName);

        }
        
        for (Map.Entry<Attribute, Tuple> attrTuplePair : relation.getTuples().entrySet()) {
            Vector<Attribute> attrList = new Vector<Attribute>();
            
            for (String attrName : attrNames) {
                attrList.add(attrTuplePair.getValue().get(attrName));
            }
            r.set(attrList.get(0), new Tuple(attrList));
        }

        return r;
    }

    // Renames the Attribute in the Relation from old to newName
    public void renaming(String relationName, String old, String newName) {
        Relation relation = relationMap.get(relationName);
        relation.rename(old, newName);
    }

    // Computes the union between two Relations and returns the new Relation
    public Relation union(String relationName1, String relationName2) {
        Relation relation1 = relationMap.get(relationName1);
        Relation relation2 = relationMap.get(relationName2);

        // Get the union of the domains
        //HashSet<Domain<?>> domains = new HashSet<Domain<?>>();
        Vector<Domain<?>> domains = new Vector<Domain<?>>();

        for (Domain<?> domain1 : relation1.getDomainMap().values()) {
            for (Domain<?> domain2 : relation2.getDomainMap().values()) {
                if (domain1.equal(domain2)) {
                    domains.add(domain1);
                }
            }
        }

        Relation relation = new Relation("union", domains.get(0), domains);

        // Add all tuples in relation1 with a Domain from domains to the
        // returned relation
        /*
        for (Map.Entry<Attribute, Tuple> mAttrTuplePair : relation1.getTuples().entrySet()) {
            Vector<Attribute> v = new Vector<Attribute>();
            for (Map.Entry<String, Attribute> mAttribute : mAttrTuplePair.getValue().getAttrMap().entrySet()) {
                for (Domain<?> domain : domains) {
                    if (domain.equal(mAttribute.getValue().getDomain())) {
                        v.add(new Attribute(domain, mAttribute.getValue().getValue()));
                    }
                }
            }
            Tuple t = new Tuple(v);
            relation.set(mAttrTuplePair.getKey(), t);
        }

        // Add all tuples in relation2 with a Domain from domains to the 
        // returned relation
        for (Map.Entry<Attribute, Tuple> mAttrTuplePair : relation1.getTuples().entrySet()) {
            Vector<Attribute> v = new Vector<Attribute>();
            for (Map.Entry<String, Attribute> mAttribute : mAttrTuplePair.getValue().getAttrMap().entrySet()) {
                for (Domain<?> domain : domains) {
                    if (domain.equal(mAttribute.getValue().getDomain())) {
                        v.add(new Attribute(domain, mAttribute.getValue().getValue()));
                    }
                }
            }
            Tuple t = new Tuple(v);
            relation.set(mAttrTuplePair.getKey(), t);
        }
        */
        for (Tuple t : relation1.getTuples().values()) {
            for (Tuple t2 : relation2.getTuples().values()) {
                if (t.equal(t2)) {
                    relation.set((Attribute)(t.getAttrMap().values().toArray()[0]), t);
                }
            }
        }

        return relation;
    }

    // Computes the difference between two Relations and returns the new Relation
    public Relation difference(String relationName1, String relationName2) {
        Relation relation1 = relationMap.get(relationName1);
        Relation relation2 = relationMap.get(relationName2);
        Relation relation = new Relation("difference");

        // Get Difference of Domain Names
        HashSet<String> domainNames = new HashSet<String>();
        domainNames.addAll(relation1.getDomainMap().keySet());
        domainNames.addAll(relation2.getDomainMap().keySet());
        
        HashSet<String> intersect = new HashSet<String>(relation1.getDomainMap().keySet());
        intersect.retainAll(relation2.getDomainMap().keySet());
        domainNames.removeAll(intersect);

        // Convert to Set of Domains from Domain Names
        HashSet<Domain<?>> domains = new HashSet<Domain<?>>();
        
        for (String s : domainNames) {
            if (relation1.getDomainMap().keySet().contains(s)) {
                domains.add(relation1.getDomainMap().get(s));
            } else {
                domains.add(relation2.getDomainMap().get(s));
            }

        }

        // Add all tuples in relation1 with a Domain from domains to the 
        // returned relation
        for (Map.Entry<Attribute, Tuple> mAttrTuplePair : relation1.getTuples().entrySet()) {
            for (Map.Entry<String, Attribute> mAttribute : mAttrTuplePair.getValue().getAttrMap().entrySet()) {
                for (Domain<?> domain : domains) {
                    if (domain.equal(mAttribute.getValue().getDomain())) {
                        Vector<Attribute> v = new Vector<Attribute>();
                        v.add(new Attribute(domain, mAttribute.getValue().getValue()));
                        Tuple t = new Tuple(v);
                        relation.set(mAttribute.getValue(), t);
                    }
                }
            }
        }

        // Add all tuples in relation2 with a Domain from domains to the 
        // returned relation
        for (Map.Entry<Attribute, Tuple> mAttrTuplePair : relation2.getTuples().entrySet()) {
            for (Map.Entry<String, Attribute> mAttribute : mAttrTuplePair.getValue().getAttrMap().entrySet()) {
                for (Domain<?> domain : domains) {
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

    // Computes the Cartesian Product of two Relations and returns the new Relation
    public Relation product(String relationName1, String relationName2) {
        Relation relation1 = relationMap.get(relationName1);
        Relation relation2 = relationMap.get(relationName2);

        // Create new relation comprised of every combination of concatenated
        // tuples in relations 1 and 2
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

    // Utility to compare either Strings or Integers
    private int compareTo(Object o1, Object o2, Domain<?> domain) {
        if (domain.getType() == Integer.class) {
            return (Integer) o1 - (Integer) o2;
        } else {
            return ((String) o1).compareTo((String) o2);
        }
    }
}
