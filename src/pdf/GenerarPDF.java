package pdf;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GenerarPDF {

      public void generar(int id_employee, String contrasenia) {
        // Creación del objeto documento
        Document document = new Document(PageSize.A3);

        try {
      // Crear la carpeta "pdf" si no existe
            File pdfDir = new File("pdf");
            if (!pdfDir.exists()) {
                pdfDir.mkdir();
            }

            // Creación del escritor
            String nameFile = "pdf/Acceso_" + id_employee + ".pdf";
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(nameFile));

            // step 3: we open the document
            document.open();

            // Obtener el ContentByte y hacer cosas con él
            PdfContentByte cb = writer.getDirectContent();
            Graphics g = cb.createGraphicsShapes(PageSize.A3.getWidth(), PageSize.A3.getHeight());

            // Página 1
            g.setColor(Color.BLACK);
            Font font1 = new Font("Tahoma", Font.BOLD + Font.ITALIC, 25);
            g.setFont(font1);
            g.drawString("Bienvenido a la Plataforma de la Empresa", 40, 100);

            Font font2 = new Font("Tahoma", Font.PLAIN, 18);
            g.setFont(font2);
            g.drawString("Has iniciado sesión correctamente.", 40, 150);
            g.drawString("Aquí está tu contraseña para ingresar:", 40, 200);

            Font font3 = new Font("Tahoma", Font.BOLD, 20);
            g.setFont(font3);
            g.setColor(Color.BLUE);
            g.drawString(contrasenia, 40, 250);

            // Agregar imagen
            String imgPath1 = "/img/coche-electrico.png";
            URL imgURL1 = getClass().getResource(imgPath1);
            if (imgURL1 != null) {
                ImageIcon img1 = new ImageIcon(imgURL1);
                g.drawImage(img1.getImage(), 30, 10, 50, 50, null);
            } else {
                System.err.println("Error: La imagen " + imgPath1 + " no se pudo encontrar.");
            }

            // Mensaje de éxito
            JOptionPane.showMessageDialog(null, "Se creó el archivo 'Acceso_" + id_employee + ".pdf' en la carpeta del proyecto");

            // Cerrar el gráfico
            g.dispose();

        } catch (DocumentException | FileNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            // Cerrar el documento
            document.close();
        }
    }
}
