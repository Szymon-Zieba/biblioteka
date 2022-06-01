package pl.goread.pdf.components.list;

public class List extends com.lowagie.text.List {

    public static final boolean ORDERED = true;
    public static final boolean UNORDERED = false;
    public static final boolean NUMERICAL = false;
    public static final boolean ALPHABETICAL = true;
    public static final boolean UPPERCASE = false;
    public static final boolean LOWERCASE = true;

    public List() {
        super();
    }

    public List(float symbolIndent) {
        super(symbolIndent);
    }

    public List(boolean numbered) {
        super(numbered);
    }

    public List(boolean numbered, boolean lettered) {
        super(numbered, lettered);
    }

    public List(boolean numbered, float symbolIndent) {
        super(numbered, symbolIndent);
    }

    public List(boolean numbered, boolean lettered, float symbolIndent) {
        super(numbered, lettered, symbolIndent);
    }
}
