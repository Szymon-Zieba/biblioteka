package pl.goread.pdf.components.list;

import pl.goread.pdf.components.Chunk;
import pl.goread.pdf.components.Phrase;
import pl.goread.pdf.components.font.Font;

public class ListItem extends com.lowagie.text.ListItem {

    public ListItem() {
        super();
    }

    public ListItem(float leading) {
        super(leading);
    }

    public ListItem(Chunk chunk) {
        super(chunk);
    }

    public ListItem(String string) {
        super(string);
    }

    public ListItem(String string, Font font) {
        super(string, font);
    }

    public ListItem(float leading, Chunk chunk) {
        super(leading, chunk);
    }

    public ListItem(float leading, String string) {
        super(leading, string);
    }

    public ListItem(float leading, String string, Font font) {
        super(leading, string, font);
    }

    public ListItem(Phrase phrase) {
        super(phrase);
    }
}
