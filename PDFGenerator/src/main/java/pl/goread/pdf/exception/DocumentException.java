package pl.goread.pdf.exception;

public class DocumentException extends com.lowagie.text.DocumentException {
    public DocumentException(Exception ex) {
        super(ex);
    }

    public DocumentException() {
        super();
    }

    public DocumentException(String message) {
        super(message);
    }
}
