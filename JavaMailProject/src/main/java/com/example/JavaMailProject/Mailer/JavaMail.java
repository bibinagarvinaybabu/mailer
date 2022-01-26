package com.example.JavaMailProject.Mailer;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class JavaMail {

	public void SendMailAPI(Mailer mailer) throws MessagingException {
		// TODO Auto-generated method stub
		
		final String username = "bibinagarvinaybabu@gmail.com";
        final String password = "Imagine143$&+";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
        	String[] recipientList = mailer.getTo_address().split(",");
        	InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
        	int counter = 0;
        	for (String recipient : recipientList) {
        	    recipientAddress[counter] = new InternetAddress(recipient.trim());
        	    counter++;
        	}

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("bibinagarvinaybabu@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO, recipientAddress
//                    InternetAddress.parse("bibinagarvinaybabu@gmail.com")
            );
            message.setSubject("Testing Gmail SSL");
            message.setText(mailer.getMailBody());

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

	}

}
