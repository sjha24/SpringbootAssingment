package com.saurav.SendingMailUsingJava;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class HandelAttachment {
    void sendAttachment(String message, String subject , String Receiver, String Sender) throws MessagingException {
        //host - gmail is smtp
        String host = "smtp.gmail.com";
        Properties pr = System.getProperties();
        System.out.println(pr);
        pr.put("mail.smtp.host",host);
        pr.put("mail.smtp.port","465");
        pr.put("mail.smtp.ssl.enable","true");
        pr.put("mail.smtp.auth","true");

        //session

        Session mailSession = Session.getInstance(pr, new MailAuthenticator());

        //create a message object---->
        MimeMessage mimeMessage = new MimeMessage(mailSession);

        try {
            //sender
            mimeMessage.setFrom(MailConstant.SENDER);
            //receiver
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(MailConstant.RECEIVER_MAIL));
            //subject
            mimeMessage.setSubject(MailConstant.SUBJECT);
            //message
            mimeMessage.setText(MailConstant.MESSAGE);

            Transport.send(mimeMessage);
        }catch (MessagingException ex){
            ex.printStackTrace();
        }

    }
}
