package DBTypes;

import java.io.*;

public class Domain<T extends Serializable> implements Serializable {
    private Class<T> type;
    private int lowerBound;
    private int upperBound;
    private String name;

    public Domain(Class<T> type, String name) {
        this.type = type;
        this.name = name;
    }

    public Domain(Class<T> type, int lowerBound, int upperBound, String name) {
        this.type = type;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.name = name;
    }

    public void rename(String name) {
        this.name = name;
    }

    public Class<T> getType() {
        return type;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public String getName() {
        return name;
    }

    public boolean equal(Domain d) {
        return type == d.getType() && lowerBound == d.getLowerBound() && upperBound == d.getUpperBound() && name.equals(d.getName());
    }

}
