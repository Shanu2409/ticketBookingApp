package student;

import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFCreator {
    public static void main(String[] args) {
        // Create a new PDF document
        Document document = new Document();
        try {
            // Create a PDF writer to write the document to a file
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\shanu\\Downloads\\pdfs\\one.pdf"));

            // Open the document
            document.open();

            // Add text to the document
            Paragraph paragraph = new Paragraph("Hello, World!");
            document.add(paragraph);

            // Add an image to the document
            Image image = Image.getInstance("C:\\Users\\shanu\\OneDrive\\Pictures\\PS\\sea.jpg");
            image.scaleAbsolute(200, 200);
            document.add(image);

            // Close the document
            document.close();
        } catch (Exception e) {}
    }
}
