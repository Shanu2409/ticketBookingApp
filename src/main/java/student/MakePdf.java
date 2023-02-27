package student;

import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class MakePdf {

    static LocalDateTime now = LocalDateTime.now();

    public static String DAT() {
        // Get the current date and time

        // Format the date and time using a date/time formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm-HH_dd-MM-yyyy");
        String formattedDateTime = now.format(formatter);

        return formattedDateTime;
    }

    /**
     *
     * @param s
     */
    MakePdf(ArrayList<String> s) {
        try {
            // Create a new PDF document
            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD);
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\shanu\\Downloads\\pdfs\\" + DAT() + ".pdf"));

            // Open the document
            document.open();
            Paragraph ph;

            // Add data to the document
            Image image = Image.getInstance("C:\\Users\\shanu\\OneDrive\\Documents\\Java Ce2\\Sample\\src\\main\\java\\student\\t3 (Custom).png");
            image.scaleAbsolute(200, 200);
            image.setAlignment(Element.ALIGN_CENTER);
            document.add(image);
            document.add(new Paragraph("\n\n\n"));

            ph = new Paragraph("From : " + s.get(0), font);
            ph.setAlignment(Element.ALIGN_CENTER);
            document.add(ph);
            s.remove(0);

            ph = new Paragraph("To : " + s.get(0), font);
            ph.setAlignment(Element.ALIGN_CENTER);

            document.add(ph);
            s.remove(0);

            ph = new Paragraph("Price : " + s.get(0), font);
            ph.setAlignment(Element.ALIGN_CENTER);
            document.add(ph);
            s.remove(0);

            ph = new Paragraph("UID : " + s.get(0), font);
            ph.setAlignment(Element.ALIGN_CENTER);
            document.add(ph);
            s.remove(0);

            ph = new Paragraph("Type : " + s.get(0), font);
            ph.setAlignment(Element.ALIGN_CENTER);
            document.add(ph);
            s.remove(0);

            ph = new Paragraph("Platform : " + s.get(0), font);
            ph.setAlignment(Element.ALIGN_CENTER);
            document.add(ph);

            ph = new Paragraph("Date : " + now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), font);
            ph.setAlignment(Element.ALIGN_CENTER);
            document.add(ph);
            // Close the document
            
            document.add(new Paragraph("\n"));
            ph = new Paragraph("!!!!!HAPPY JOURNY!!!!!", new Font(Font.FontFamily.TIMES_ROMAN, 45, Font.BOLDITALIC));
//            ph.setAlignment(Element.ALIGN_CENTER);
            document.add(ph);
            document.close();

            System.out.println("PDF file created successfully.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
