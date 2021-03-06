package wv.meta;

import java.awt.image.BufferedImage;
import wv.Module;
import wv.paint.GraphicsHandle;
import wv.geom.Point;

/**
 * The NullParent represents a null module parent. It might be good in the future for it to not silently ignore everything a module does.
 */
public final class NullParent implements ModuleParent {   
    @Override
    public void drawChild(Module child) { }

    @Override
    public Point mousePosition() { return Point.ZERO; }

    @Override
    public int getAbsoluteX() { return 0; }

    @Override
    public int getAbsoluteY() { return 0; }

    @Override
    public GraphicsHandle beginDraw(Module m) {
        //TODO: Figure out better way to get null graphics
        return new GraphicsHandle(0, 0, 0, 0, new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB).createGraphics());
    }

    @Override
    public void endDraw(GraphicsHandle g) {
    }
    
}