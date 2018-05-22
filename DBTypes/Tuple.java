package DBTypes;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Vector;

public class Tuple {
    //---------------------PRIVATE---------------------------------------------//
    private HashMap<String, Attribute> attrMap;

    public Tuple(Vector<Attribute> attrList) {
        attrMap = new LinkedHashMap<>();

        for (Attribute attr : attrList) {
            // System.out.println(attr.getDomain().getName());
            attrMap.put(attr.getDomain().getName(), attr);
        }
    }

    public int size() {
        return attrMap.size();
    }

    public Attribute get(String attr) {
        return attrMap.get(attr);
    }

    public Map<String, Attribute> getAttrMap() {
        return attrMap;
    }

    // This will directly change the attribute lists associated with the tuples
    public void refactor(Vector<String> names, Vector<Object> values) {
        if (names.size() > attrMap.size()) {
            System.out.println("Too many names, unable to perform action\n");
            return;
        }
        for (int i = 0; i < names.size(); i++) {
            attrMap.get(names.get(i)).setValue(values.get(i));
        }
    }

    public void rename(String old, String newName) {
        // This works just fine
        // Since all you are doing is replacing a key name, you can simply
        // shove the new one in the original, after removing the old name
        // but saving it's attributes in a temp in order to put in with the
        // new name
        while (attrMap.containsKey(old)) {
            Attribute temp = attrMap.remove(old);
            attrMap.put(newName, temp);
        }

        // To test if this actually changed the old key to the new key
        /*for(Map.Entry<String, Attribute> origAttr1 : attrMap.entrySet()) {
            if(origAttr1.getKey() == newName) {
                System.out.println(origAttr1.getKey());
            }
        }*/
    }


    //Compares two Tuples to see if they are equivalent
    public boolean equal(Tuple tuple) {
        if (attrMap.size() != tuple.size())
            return false;
        for (Map.Entry<String, Attribute> mAttr : this.attrMap.entrySet()) {

            // To ensure even if key names are different, this code will still work
            Attribute b = tuple.attrMap.get(mAttr.getKey());
            if (b != null) {
                if (!mAttr.getValue().getValue().equals(tuple.attrMap.get(mAttr.getKey()).getValue()))
                    return false;
            }
            // If the key which exists in one tuple does not exist in the other,
            // then the 2 tuples are automatically not equal
            else if (b == null) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }

}

