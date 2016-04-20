package wv.geom;

/**
 * A Rectangle represents a rectangular object that cannot rotate - essentially,
 * its sides are always directly vertical or directly horizontal.<br><br>
 * 
 * A Rectangle is stored as a position and a size. This way, the position can easily
 * be changed without changing the size, and vice versa.
 * @author TheMonsterFromTheDeep
 */
public class Rectangle extends Rect {
    /**
     * The x-coordinate of the upper left corner of the Rectangle.
     */
    public float x;
    /**
     * The y coordinate of the upper left corner of the Rectangle.
     */
    public float y;
    /**
     * The width (horizontal size) of the Rectangle.
     */
    public float width;
    /**
     * The height (vertical size) of the Rectangle.
     */
    public float height;
    
    /**
     * Creates a new Rectangle with a position and size of zero.
     */
    public Rectangle() { this.x = this.y = this.width = this.height = 0; }
    
    /**
     * Creates a Rectangle with the specified position and size.
     * @param x The x coordinate of the Rectangle.
     * @param y The y coordinate of the Rectangle.
     * @param width The width of the Rectangle.
     * @param height The height of the Rectangle.
     * @see #x
     * @see #y
     * @see #width
     * @see #height
     */
    public Rectangle(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    /**
     * Creates a Rectangle identical to the specified Rectangle. This does not create
     * any pointer-level relationships, however.
     * @param r The Rectangle to duplicate.
     */
    public Rectangle(Rectangle r) {
        this.x = r.x;
        this.y = r.y;
        this.width = r.width;
        this.height = r.height;
    }
    
    /**
     * Creates a Rectangle with the specified position and size. This does not create
     * any pointer-level relationships, however.<br><br>
     * 
     * In order to create a pointer-level relationship between Rectangle objects
     * and Position and Size objects, use a RectBind.
     * @param position
     * @param size 
     */
    public Rectangle(Point position, Size size) {
        this.x = position.x;
        this.y = position.y;
        this.width = size.width;
        this.height = size.height;
    }
    
    /**
     * @return The x-coordinate of the left of the Rectangle (this is equal to {@link #x}).
     * @see #setLeft(float) 
     */
    @Override
    public float getLeft() { return x; }
    /**
     * @return The y-coordinate of the top of the Rectangle (this is equal to {@link #y}).
     * @see #setRight(float) 
     */
    @Override
    public float getTop() { return y; }
    /**
     * @return The x-coordinate of the right of the Rectangle (this is equal to {@link #x} + {@link #width}).\
     * @see #setRight(float) 
     * @see #getLeft()
     */
    @Override
    public float getRight() { return x + width; }
    /**
     * @return The y-coordinate of the bottom of the Rectangle (this is equal to {@link #y} + {@link #height}).
     * @see #getLeft()
     * @see #setBottom(float) 
     */
    @Override
    public float getBottom() { return y + height; }
    
    /**
     * Sets the x-coordinate of the left of the Rectangle to the specified value. This also sets the width
     * of the Rectangle so that {@link #getRight()} will stay the same. In order to directly set the x location
     * of the Rectangle, use {@link #setX(float)} or set {@link #x} directly.
     * @param x The x coordinate to move the left of the Rectangle to.
     * @see #getLeft() 
     */
    @Override
    public void setLeft(float x) { this.width += (this.x - x); this.x = x; }
    /**
     * Sets the y-coordinate of the top of the Rectangle to the specified value. This also sets the height
     * of the Rectangle so that {@link #getBottom()} will stay the same. In order to directly set the y location
     * of the Rectangle, use {@link #setY(float)} or set {@link #y} directly.
     * @param y The y coordinate to move the top of the Rectangle to.
     * @see #getTop() 
     */
    @Override
    public void setTop(float y) { this.height += (this.y - y); this.y = y; }
    /**
     * Sets the x-coordinate of the right of the Rectangle to the specified value. This sets the
     * exact position of the right of the Rectangle to the value. In order to set the actual width,
     * use {@link #setWidth(float)} or set {@link #width} directly.
     * @param x The x coordinate to move the right of the Rectangle to.
     * @see #getRight() 
     */
    @Override
    public void setRight(float x) { this.width = (x - this.x); }
    /**
     * Sets the y-coordinate of the bottom of the Rectangle to the specified value. This sets the
     * exact position of the bottom of the Rectangle to the value. In order to set the actual height,
     * use {@link #setHeight(float)} or set {@link #height} directly.
     * @param y The y coordinate to move the right of the Rectangle to.
     * @see #getBottom() 
     */
    @Override
    public void setBottom(float y) { this.height = (y - this.y); }
    
    /**
     * Sets the x position of the Rectangle to the specified value. This moves the Rectangle to the position
     * specified without changing the width. This is equivalent to setting {@link #x} directly.
     * @param x The new x position of the Rectangle.
     * @see #x
     * @see #setLeft(float) 
     */
    @Override
    public void setX(float x) { this.x = x; }
    /**
     * Sets the y position of the Rectangle to the specified value. This moves the Rectangle to the position
     * specified without changing the height. This is equivalent to setting {@link #y} directly.
     * @param y The new y position of the Rectangle.
     * @see #y
     * @see #setTop(float) 
     */
    @Override
    public void setY(float y) { this.y = y; }
    
    /**
     * Sets the width of the Rectangle to the specified value without changing its position. This is equivalent
     * to setting {@link #width} directly.
     * @param width The new width of the Rectangle.
     * @see #width
     * @see #setRight(float) 
     */
    @Override
    public void setWidth(float width) { this.width = width; }
    /**
     * Sets the height of the Rectangle to the specified value without changing its position. This is equivalent
     * to setting {@link #height} directly.
     * @param height The new height of the Rectangle.
     * @see #height
     * @see #setBottom(float) 
     */
    @Override
    public void setHeight(float height) { this.height = height; }
    
    @Override
    public float getX() { return x; }
    @Override
    public float getY() { return y; }
    @Override
    public float getWidth() { return width; }
    @Override
    public float getHeight() { return height; }
    
    /**
     * Changes the Rectangle's position by the specified amounts. This does not change its size.
     * @param dx
     * @param dy 
     */
    public void translate(float dx, float dy) {
        x += dx;
        y += dy;
    }
    
    @Override
    public boolean contains(float x, float y) {
        return (x >= this.x && x < this.x + width && y >= this.y && y < this.y + height);
    }
    
    public boolean intersects(Rectangle r) {
        float thisx = x;
        float thisy = y;
        float thiswidth = width;
        float thisheight = height;
        float rx = r.x;
        float ry = r.y;
        float rwidth = r.width;
        float rheight = r.height;
        return ((thisx + thiswidth > rx && thisx + thiswidth <= rx + rwidth) || (rx + rwidth > thisx && rx + rwidth <= thisx + thiswidth)) && ((thisy + thisheight > ry && thisy + thisheight <= ry + rheight) || (ry + rheight > thisy && ry + rheight <= thisy + thisheight));
    }

    
}