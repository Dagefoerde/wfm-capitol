package de.wwu.wfm.sc4.mail;
 
import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class Mail
{
    public static void send(MailAccounts acc, String recipient, String subject,
            String text) throws AddressException, MessagingException
    {
        
        Properties properties = System.getProperties();
 
        properties.setProperty("mail.smtp.host", acc.getSmtpHost());
        properties.setProperty("mail.smtp.port", String.valueOf(acc.getPort()));
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.tls", "true");
        
        Session session = Session.getDefaultInstance(properties, acc.getPasswordAuthentication());
 
        // Eine neue Nachricht wird erzeugt
        MimeMessage msg = new MimeMessage(session);
 
        // Von wem kommt die E-Mail?
        msg.setFrom(new InternetAddress(acc.getEmail()));
 
        // Wohin soll die Reise gehen?
        // CC geht beispielsweise an Message.RecipientType.CC
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient, false));
 
        // Betreff
        msg.setSubject(subject);
         
        // Nachricht
        msg.setText(text);
         
        // E-Mail versenden
        Transport.send(msg);
    }
}