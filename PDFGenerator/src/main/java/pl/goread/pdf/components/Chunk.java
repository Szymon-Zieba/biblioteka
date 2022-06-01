package pl.goread.pdf.components;

import pl.goread.pdf.components.font.Font;

public class Chunk extends com.lowagie.text.Chunk {

    public Chunk() {
        super();
    }

    public Chunk(Chunk ck) {
        super(ck);
    }

    public Chunk(String content, Font font) {
        super(content, font);
    }

    public Chunk(String content) {
        super(content);
    }

    public Chunk(char c, Font font) {
        super(c, font);
    }

    public Chunk(char c) {
        super(c);
    }
}
