package pl.goread.pdf.components;

import pl.goread.pdf.components.font.Font;

public class Phrase extends com.lowagie.text.Phrase {

    public Phrase() {
        super();
    }

    public Phrase(com.lowagie.text.Phrase phrase) {
        super(phrase);
    }

    public Phrase(float leading) {
        super(leading);
    }

    public Phrase(Chunk chunk) {
        super(chunk);
    }

    public Phrase(float leading, Chunk chunk) {
        super(leading, chunk);
    }

    public Phrase(String string) {
        super(string);
    }

    public Phrase(String string, Font font) {
        super(string, font);
    }

    public Phrase(float leading, String string) {
        super(leading, string);
    }

    public Phrase(float leading, String string, Font font) {
        super(leading, string, font);
    }
}
