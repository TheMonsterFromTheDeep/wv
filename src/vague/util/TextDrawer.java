package vague.util;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class TextDrawer {
    public static final int TEXT_HEIGHT = 14;
    public static final int TEXT_WIDTH = 10;
    public static final int TEXT_OFFSET = TEXT_WIDTH + 1;
    
    public static final double textHeight(double scale) {
        return TEXT_HEIGHT * scale;
    }
    
    public static final double textWidth(double scale) {
        return TEXT_WIDTH * scale;
    }
    
    public static final double stringWidth(String s, double scale) {
        return ((s.length() * (TEXT_WIDTH + 1)) - 1) * scale;
    }
    
    //Chars stores images of the ascii text characters. Characters are not drawn for ascii codes < 32, so this stores no images
    //for characters < 32.
    private BufferedImage[] chars;
    
    public TextDrawer(BufferedImage data) {
        chars = new BufferedImage[95];
        for(int i = 0; i < chars.length; i++) {
            chars[i] = data.getSubimage(i * TEXT_WIDTH, 0, TEXT_WIDTH, TEXT_HEIGHT);
            for(int x = 0; x < chars[i].getWidth(); x++) {
                for(int y = 0; y < chars[i].getHeight(); y++) {
                    if(chars[i].getRGB(x, y) != 0xff000000) {
                        chars[i].setRGB(x, y, 0x00000000);
                    }
                }
            }
        }
    }
    
    public BufferedImage draw(String text, double size) {
        if(text.length() == 0) {
            return new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        }
        BufferedImage render = new BufferedImage(text.length() * TEXT_OFFSET - 1, TEXT_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics renderer = render.createGraphics();
        
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(c >= 32 && c <= 126) {
                c -= 32;
                renderer.drawImage(chars[c], i * TEXT_OFFSET, 0, null);
            }
        }
        
        if(size > 1.0) {
            AffineTransform scale = new AffineTransform(AffineTransform.getScaleInstance(size, size));
            AffineTransformOp scaleop = new AffineTransformOp(scale, null);
            return scaleop.filter(render, null);
        }
        else {
            return render;
        }
    }
}