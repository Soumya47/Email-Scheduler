package com.greenapex.email.scheduling.app.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailUtil {
    public static void sendEmail(String toEmail, String subject, String body) {
        try {
            final String fromEmail = "<email>";

            final String password="<password>";

           Authenticator auth = new Authenticator() {
               @Override
               protected PasswordAuthentication getPasswordAuthentication() {
                   return new PasswordAuthentication(fromEmail,password);
               }
           };

            Properties properties = new Properties();
            properties.put("mail.smtp.host","smtp.gmail.com");
            properties.put("mail.smtp.port","587");
            properties.put("mail.smtp.auth","true");
            properties.put("mail.smtp.starttls.enable","true");

            Session session = Session.getInstance(properties,auth);
            MimeMessage msg = new MimeMessage(session);

            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("<sender-email>","NoReply-JD"));
            msg.setReplyTo(InternetAddress.parse("<receiver-email>",false));
            msg.setSubject(subject,"UTF-8");
            msg.setText(body,"UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toEmail,false));
            Transport.send(msg);
            System.out.println("mail sent!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
