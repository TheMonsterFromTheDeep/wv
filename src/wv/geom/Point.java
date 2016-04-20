package wv.geom;

import wv.util.F;

/**
 * A Point is s floating-point representation of a location. It contains both an x and a y coordinate.
 * @author TheMonsterFromTheDeep
 */
public class Point extends Vector2 {
    /**
     * The x coordinate of the Point.
     */
    public float x;
    /**
     * The y coordinate of the Point.
     */
    public float y;
    
    /**
     * Creates a new Point at 0,0.
     */
    public Point() {
        this.x = 0;
        this.y = 0;
    }
    
    /**
     * Creates a new Point with the specified x and y coordinates.
     * @param x The x coordinate of the Point.
     * @param y The y coordinate of the Point.
     */
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Creates a new Point by copying the location of another one.
     * @param p The Point to copy.
     */
    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    /**
     * Translates the Point the given distance along the x and y axes.
     * @param x The distance to translate the Point along the x-axis.
     * @param y The distance to translate the Point along the y-axis.
     */
    public void translate(float x, float y) {
        this.x += x;
        this.y += y;
    }
    
    /**
     * Returns whether this Point is the same location as the specified Point.<br><br>
     * 
     * This method compares the Point exactly; use {@link #equalsF(wv.geom.Point)} to compare
     * within the {@link wv.util.F} threshold.
     * @param p The Point to compare to.
     * @return Whether the two Points are equal.
     * @see #equalsF(wv.geom.Point) 
     */
    public boolean equals(Point p) {
        return (this.x == p.x) && (this.y == p.y);
    }
    
    /**
     * Compares the location of this Point and the location of the specified Point using
     * {@link wv.util.F}. This gives more lenient values and is better to use when floating-point
     * rounding errors may exist due to how this Point or the specified Point was manipulated.<br><br>
     * 
     * For a direct comparison of this Point and the specified Point, use {@link #equals(wv.geom.Point)}.
     * @param p The Point to compare with.
     * @return Whether this Point and the specified Point are equal by the standard of {@link wv.util.F}.
     * @see #equals(wv.geom.Point) 
     */
    public boolean equalsF(Point p) {
        return F.equals(this.x, p.x) && F.equals(this.y, p.y);
    }
    
    /**
     * Snaps the Point to a grid of a specific size.
     * @param size The increments in size to snap to.
     */
    public void snap(int size) {
        this.x = (this.x / size) * size; //Integer divides the size and re-multiplies it, causing the sizes to be snapped
        this.y = (this.y / size) * size;
    }
    
    /**
     * Sets a Vector object to be identical to another Vector object without requiring reallocation of memory.
     * @param v The Vector object to set this Vector identical to.
     */
    public void set(Point v) {
        this.x = v.x;
        this.y = v.y;
    }

    
    @Override
    public float getXComponent() { return this.x; }

    @Override
    public float getYComponent() { return this.y; }

    @Override
    public void setXComponent(float x) { this.x = x; }

    @Override
    public void setYComponent(float y) { this.y = y; }
}
