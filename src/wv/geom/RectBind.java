package wv.geom;

/**
 * A RectBind is similar to a Rectangle, but rather it uses a Point and Size object to store
 * its position and size. This way, it is possible to get handles to these objects, and use
 * them to modify the RectBind's position and size.
 * @author TheMonsterFromTheDeep
 */
public class RectBind extends Rect {
    public Point position;
    public Size size;

    @Override
    public float getX() { return position.x; }

    @Override
    public float getY() { return position.y; }

    @Override
    public float getWidth() { return size.width; }

    @Override
    public float getHeight() { return size.height; }

    @Override
    public void setX(float x) { position.x = x; }

    @Override
    public void setY(float y) { position.y = y; }

    @Override
    public void setWidth(float width) { size.width = width; }

    @Override
    public void setHeight(float height) { size.height = height; }
}