package wv.geom;

/**
 * A Size encapsulates a 2D size by storing a width (horizontal size) and height (vertical size).
 * @author TheMonsterFromTheDeep
 */
public class Size extends Vector2 {
    public float width;
    public float height;
    
    public Size() { width = 0; height = 0; }
    
    public Size(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public float getXComponent() { return width; }

    @Override
    public float getYComponent() { return height; }

    @Override
    public void setXComponent(float x) { this.width = x; }

    @Override
    public void setYComponent(float y) { this.height = y; }
}