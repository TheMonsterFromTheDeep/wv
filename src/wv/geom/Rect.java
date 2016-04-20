package wv.geom;

/**
 * Defines a rectangular object whose sides are always horizontal or vertical. In order to do so,
 * Rect provides methods for positions and size - essentially, it provides methods for binding
 * an arbitrary position to an arbitrary size.
 * @author TheMonsterFromTheDeep
 */
public abstract class Rect {
    /**
     * @return The x-position of the upper-left corner of the Rect.
     */
    public abstract float getX();
    /**
     * @return The y-position of the upper-left corner of the Rect.
     */
    public abstract float getY();
    /**
     * @return The horizontal size of the Rect.
     */
    public abstract float getWidth();
    /**
     * @return The vertical size of the Rect.
     */
    public abstract float getHeight();
    /**
     * Sets the x position of the top-left corner of the Rect to the specified value. This
     * does not affect its size.
     * @param x The new x-position of the Rect.
     */
    public abstract void setX(float x);
    /**
     * Sets the y position of the top-left corner of the Rect to the specified value. This
     * does not affect its size.
     * @param y The new y-position of the Rect.
     */
    public abstract void setY(float y);
    /**
     * Sets the width of the Rect to the specified value. This does not affect its position.
     * @param width The new width of the Rect.
     */
    public abstract void setWidth(float width);
    /**
     * Sets the height of the Rect to the specified value. This does not affect its position.
     * @param height The new height of the Rect.
     */
    public abstract void setHeight(float height);
    
    public float getLeft() { return getX(); }
    public float getTop() { return getY(); }
    public float getRight() { return getX() + getWidth(); }
    public float getBottom() { return getY() + getHeight(); }
    
    public void setLeft(float x) { setWidth(getX() - x); setX(x); }
    public void setTop(float y) { setHeight(getY() - y); setY(y); }
    public void setRight(float x) { setWidth(x - getX()); }
    public void setBottom(float y) { setHeight(y - getY()); }
    
    public boolean contains(float x, float y) {
        return (x >= getX() && x < getX() + getWidth() && y >= getY() && y < getY() + getHeight());
    }
    
    public final boolean contains(Point p) {
        return contains(p.x, p.y);
    }
    
    public boolean intersects(Rect r) {
        float thisx = getX();
        float thisy = getY();
        float thiswidth = getWidth();
        float thisheight = getHeight();
        float rx = r.getX();
        float ry = r.getY();
        float rwidth = r.getWidth();
        float rheight = r.getHeight();
        return ((thisx + thiswidth > rx && thisx + thiswidth <= rx + rwidth) || (rx + rwidth > thisx && rx + rwidth <= thisx + thiswidth)) && ((thisy + thisheight > ry && thisy + thisheight <= ry + rheight) || (ry + rheight > thisy && ry + rheight <= thisy + thisheight));
    }
}