package wv.geom;

/**
 * A Vector2 represents some sort of x/y pairing in 2D space.
 * @author TheMonsterFromTheDeep
 */
public abstract class Vector2 {
    /**
     * @return The x component of the Vector2.
     */
    public abstract float getXComponent();
    /**
     * @return The y component of the Vector2.
     */
    public abstract float getYComponent();
    /**
     * Sets the x component of the Vector2 to the specified value.
     * @param x The new x component of the Vector2.
     */
    public abstract void setXComponent(float x);
    /**
     * Sets the y component of the Vector2 to the specified value.
     * @param y The new y component of the Vector2.
     */
    public abstract void setYComponent(float y);
    
    /**
     * Adds the specified x and y values to this Vector2. This may perform
     * different operations based on what sort of Vector2 this object is.
     * @param x The x value to add.
     * @param y The y value to add.
     * @see #subtract(float, float) 
     */
    public void add(float x, float y) {
        setXComponent(getXComponent() + x);
        setYComponent(getYComponent() + y);
    }
    
    /**
     * Adds the specified Vector2 to this Vector2. This acts the same as
     * {@link #add(float, float)} but is passed a Vector2 rather than two floats.
     * This may perform different operations based on what this Vector2 object is.
     * @param v The Vector2 to add.
     * @see #add(float, float) 
     * @see #subtract(wv.geom.Vector2) 
     */
    public final void add(Vector2 v) {
        add(v.getXComponent(), v.getYComponent());
    }
    
    /**
     * Subtracts the specified x and y values from this Vector2. This is done
     * by calling {@link #add(float, float)} with the negatives of the parameters.
     * This may perform different operations based on what this Vector2 object is.
     * @param x The x value to subtract.
     * @param y The y value to subtract.
     * @see #add(float, float) 
     */
    public final void subtract(float x, float y) {
        add(-x, -y);
    }
    
    /**
     * Adds the specified Vector2 to this Vector2. This acts the same as
     * {@link #subtract(float, float)} but is passed a Vector2 rather than two floats.
     * This may perform different operations based on what this Vector2 object is.
     * @param v The Vector2 to subtract.
     * @see #subtract(float, float) 
     * @see #add(wv.geom.Vector2) 
     */
    public final void subtract(Vector2 v) {
        subtract(v.getXComponent(), v.getYComponent());
    }
    
    /**
     * Sets the x and y components of the Vector2 to the specified values. This may
     * perform different operations based on what this Vector2 object is.
     * @param x The new x value.
     * @param y The new y value.
     */
    public void set(float x, float y) {
        setXComponent(x);
        setYComponent(y);
    }
    
    /**
     * Sets the x and y components of the Vector2 to the x and y components of the specified
     * Vector2. This behaves identically to {@link #set(float, float)} but is passed a Vector2
     * rather than two floats. This may perform different operations based on what this Vector2
     * object is.
     * @param v The Vector2 to set the components based off of.
     */
    public final void set(Vector2 v) {
        set(v.getXComponent(), v.getYComponent());
    }
}