package pl.goread.pdf.components.table;

import pl.goread.pdf.components.Phrase;

public class Cell extends com.lowagie.text.pdf.PdfPCell {

    public Cell() {
        super();
    }

    public Cell(Phrase phrase) {
        super(phrase);
    }

    public Cell(Table table) {
        super(table);
    }

    public Cell(Table table, Cell style) {
        super(table, style);
    }

    public Cell(Cell cell) {
        super(cell);
    }
}
