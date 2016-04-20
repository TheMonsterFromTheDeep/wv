package wv.geom;

/**
 * A Vector2 represents some sort of x/y pairing in 2D space.
 * @author TheMonsterFromTheDeep
 */
public abstract class Vector2 {
    public abstract float getXComponent();
    public abstract float getYComponent();
    public abstract void setXComponent(float x);
    public abstract void setYComponent(float y);
    
    public void add(float x, float y) {
        setXComponent(getXComponent() + x);
        setYComponent(getYComponent() + y);
    }
    
    public void add(Vector2 v) {
        add(v.getXComponent(), v.getYComponent());
    }
    
    public void subtract(float x, float y) {
        setXComponent(getXComponent() - x);
        setYComponent(getYComponent() - y);
    }
    
    public void subtract(Vector2 v) {
        subtract(v.getXComponent(), v.getYComponent());
    }
}