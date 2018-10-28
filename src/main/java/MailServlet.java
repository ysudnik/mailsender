import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class MailServlet {
    @WebServlet(value = "/emailSender")
    public class EmailSenderServlet extends HttpServlet {
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
            String from = req.getParameter("from");
            String to = req.getParameter("to");
            String text = req.getParameter("text");
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.mail.ru");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.ssl.enable", "true");
            Session session = Session.getInstance(props, null);

            try {
                MimeMessage msg = new MimeMessage(session);
                msg.setFrom("ysudnik@mail.ru");
                msg.setRecipients(Message.RecipientType.TO, to);
                msg.setSubject("JavaMail");
                msg.setSentDate(new Date());
                msg.setText(text);
                Transport.send(msg, "ysudnik@mail.ru", "pass");
            } catch (MessagingException mex) {
                System.out.println("send failed, exception: " + mex);
            }

        }
    }
}
