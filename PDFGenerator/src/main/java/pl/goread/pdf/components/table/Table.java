package pl.goread.pdf.components.table;

public class Table extends com.lowagie.text.pdf.PdfPTable {

    protected Table() {
        super();
    }

    public Table(float[] relativeWidths) {
        super(relativeWidths);
    }

    public Table(int numColumns) {
        super(numColumns);
    }

    public Table(Table table) {
        super(table);
    }
}
