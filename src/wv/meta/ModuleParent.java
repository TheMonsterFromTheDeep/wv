package wv.meta;

import wv.Module;
import wv.paint.GraphicsHandle;
import wv.util.Point;

/**
 * Defines an object that can be treated as the parent to a Module. An object that Modules are parentable
 * must implement certain basic operations.
 */
public interface ModuleParent {
    void drawChild(Module child);
    
    Point mousePosition();
    
    int getAbsoluteX();
    int getAbsoluteY();
    
    GraphicsHandle beginDraw(Module m);
    void endDraw(GraphicsHandle g);
}