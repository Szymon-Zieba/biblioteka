package pl.goread.pdf.components.font;

import com.lowagie.text.pdf.BaseFont;

import java.awt.*;

public class Font extends com.lowagie.text.Font {

    public Font(com.lowagie.text.Font other) {
        super(other);
    }

    public Font(int family, float size, int style, Color color) {
        super(family, size, style, color);
    }

    public Font(BaseFont bf, float size, int style, Color color) {
        super(bf, size, style, color);
    }

    public Font(BaseFont bf, float size, int style) {
        super(bf, size, style);
    }

    public Font(BaseFont bf, float size) {
        super(bf, size);
    }

    public Font(BaseFont bf) {
        super(bf);
    }

    public Font(int family, float size, int style) {
        super(family, size, style);
    }

    public Font(int family, float size) {
        super(family, size);
    }

    public Font(int family) {
        super(family);
    }

    public Font() {
        super();
    }
}
