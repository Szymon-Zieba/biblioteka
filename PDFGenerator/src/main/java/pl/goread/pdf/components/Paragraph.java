package pl.goread.pdf.components;

import pl.goread.pdf.components.font.Font;

public class Paragraph extends com.lowagie.text.Paragraph {

    public Paragraph() {
        super();
    }

    public Paragraph(float leading) {
        super(leading);
    }

    public Paragraph(Chunk chunk) {
        super(chunk);
    }

    public Paragraph(float leading, Chunk chunk) {
        super(leading, chunk);
    }

    public Paragraph(String string) {
        super(string);
    }

    public Paragraph(String string, Font font) {
        super(string, font);
    }

    public Paragraph(float leading, String string) {
        super(leading, string);
    }

    public Paragraph(float leading, String string, Font font) {
        super(leading, string, font);
    }

    public Paragraph(Phrase phrase) {
        super(phrase);
    }
}
