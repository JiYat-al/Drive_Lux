package pdf;

import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class EnviarCorreo {
    private static String emailFrom = "jibsamalonso@gmail.com";
    private static String passwordFrom = "hpew gweq fbmy hjwl";
    private String emailTo;
    private String subject = "Logeo a la plataforma de Drive-Lux";
    private String content = "Mandamos tu contraseña mediante este medio, asegúrate que solamente tu sepas tu contraseña";

    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;
    private int id_employee;
    
    private File[] mArchivosAdjuntos;

    public EnviarCorreo(String emailTo,int id_employee) {
        this.id_employee = id_employee;
        mProperties = new Properties();
        this.emailTo = emailTo;
        createEmail();
        sendEmail();

        System.out.println(id_employee);
    }

    private void createEmail() {
        // Configuración de propiedades del correo
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");
        
        mSession = Session.getDefaultInstance(mProperties);
        
        try {
            MimeMultipart mElementosCorreo = new MimeMultipart();
            // Contenido del correo
            MimeBodyPart mContenido = new MimeBodyPart();
            mContenido.setContent(content, "text/html; charset=utf-8");
            mElementosCorreo.addBodyPart(mContenido);
            
            // Agregar archivos adjuntos
            MimeBodyPart mAdjuntos = new MimeBodyPart();
            String projectDir = System.getProperty("user.dir");
            File pdfFile = new File(projectDir, "pdf/Acceso_" + id_employee + ".pdf"); // Usa el ID del empleado aquí

            if (pdfFile.exists()) {
                mAdjuntos.setDataHandler(new DataHandler(new FileDataSource(pdfFile.getAbsolutePath())));
                mAdjuntos.setFileName(pdfFile.getName());
                mElementosCorreo.addBodyPart(mAdjuntos);
            } else {
                System.err.println("El archivo no existe: " + pdfFile.getAbsolutePath());
            }
            
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setContent(mElementosCorreo);
            
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

    private void sendEmail() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
            
            JOptionPane.showMessageDialog(null, "Correo enviado");
        } catch ( Exception ex) {
            ex.printStackTrace();
        }
    }

}
