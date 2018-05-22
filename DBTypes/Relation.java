package DBTypes;

import java.util.*;

public class Relation {
    private String relation;
    private Domain<?> relationDomain;
    private LinkedHashMap<String, Domain<?>> domainMap;
    private HashMap<Attribute, Tuple> tuples;

    public Relation(String name) {
        domainMap = new LinkedHashMap<>();
        this.relationDomain = null;
        relation = name;
        tuples = new HashMap<>();
    }

    public Relation(String name, Domain<?> relationDomain, Vector<Domain<?>> domain) {
        if (relationDomain == null) return;

        domainMap = new LinkedHashMap<>();
        relation = name;
        this.relationDomain = relationDomain;
        for (int i = 0; i < domain.size(); i++) {
            // System.out.println("DOMAIN: " + domain.get(i).getName());
            domainMap.put(domain.get(i).getName(), domain.get(i));
        }
        tuples = new HashMap<>();
    }

    public Relation(String name, Domain<?> relationDomain, Map<Attribute, Tuple> tupleMap) {
        domainMap = new LinkedHashMap<>();
        tuples = new HashMap<>();
        relation = name;
        this.relationDomain = relationDomain;
        for (Map.Entry<Attribute, Tuple> attrTuplePair : tupleMap.entrySet())
            tuples.put(attrTuplePair.getKey(), attrTuplePair.getValue());
    }

    public String getRelation() {
        return relation;
    }

    public Domain<?> getRelationDomain() {
        return relationDomain;
    }

    public Domain<?> getDomain(String domainName) {
        return domainMap.get(domainName);
    }

    public int getTupleCount() {
        return tuples.size();
    }

    public LinkedHashMap<String, Domain<?>> getDomainMap() {
        return domainMap;
    }

    public void setDomainMap(LinkedHashMap<String, Domain<?>> mDomain) {
        this.domainMap = mDomain;
    }

    public Map<Attribute, Tuple> getTuples() {
        return tuples;
    }

    public void renameRelation(String tableName) {
        relation = tableName;
    }

    //Removes Tuple specified by Attribute key
    public void deleteTuple(Attribute attr) {
        //System.out.println(tuples.size());
        for (Map.Entry<Attribute, Tuple> attrTuplePair : tuples.entrySet()) {
            // To make sure we are removing the specified attribute
            if (attrTuplePair.getKey().equal(attr)) {
                tuples.remove(attrTuplePair.getKey());
            }
        }

        //System.out.println("SIZE: " + tuples.size());
    }

    //Renames domain from old to newName
    public void rename(String old, String newName) {
        while (domainMap.containsKey(old)) {
            Domain<?> temp = domainMap.remove(old);
            domainMap.put(newName, temp);
        }
    }

    //Adds Tuple to Relation using Attribute as key
    public void set(Attribute attr, Tuple tuple) {
        if (tuples.containsKey(attr))
            System.out.println("Key In Use\n");
        else
            tuples.put(attr, tuple);
    }

    // Checks a specific attribute and returns a vector of all tuples 
    // containing the specified attribute
    public Vector<Tuple> selectByAttribute(Attribute comp) {
        Vector<Tuple> selected = new Vector<Tuple>();
        for (Map.Entry<Attribute, Tuple> attrTuplePair : tuples.entrySet())
            for (Map.Entry<String, Attribute> attribute : attrTuplePair.getValue().getAttrMap().entrySet())
                if (comp == attribute.getValue())
                    selected.add(attrTuplePair.getValue());

        return selected;
    }
}


