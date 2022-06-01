package pl.goread.pdf.util;

import com.lowagie.text.pdf.PdfWriter;
import pl.goread.pdf.components.Document;

import java.io.FileOutputStream;

public class PDFWriter extends PdfWriter {

    private final PdfWriter pdfWriter;

    public PDFWriter(Document document, FileOutputStream file){
        this.pdfWriter = PdfWriter.getInstance(document, file);
    }

    public void close(){
        pdfWriter.close();
    }

}
