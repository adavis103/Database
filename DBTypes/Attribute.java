package DBTypes;

public class Attribute {
    private Domain<?> d;
    private Object v;
    
    public Attribute(Domain<?> d, Object v) {
        this.d = d;
        this.v = v;
    }
    
    public Domain<?> getDomain() {return d;}
    
    public Object getValue() {return v;}
    
    public void setValue(Object o) {v = o;}
    
    public boolean equal(Attribute o) {return d.equal(o.getDomain()) && v.equals(o.getValue());}
}
