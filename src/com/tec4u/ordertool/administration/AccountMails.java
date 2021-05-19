/**
 * 
 */
package com.tec4u.ordertool.administration;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * @author david
 *
 */
public class AccountMails {

	public void sendEmail(String strReceiver, String strGeneratedPassword) {
		
		Mail m = EmailDAO.getMailServerSettingsToSendToNewUsers();

		String strHost = m.getStrSMTP_Host();
		System.out.println("HOST: " + strHost);
		
		String strSender = m.getStrSourceMail();
		System.out.println("Sender: " + strSender);
		
		String strPwd = m.getStrPwd();
		String strPort = m.getStrPort();

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", strHost);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", strPort);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(strSender, strPwd);
			}
		});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(strSender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(strReceiver));
			message.setSubject("Your generated password for IDIS Ordertool");
			message.setText("Your generated password is " + strGeneratedPassword
					+ ". Please change it inside the application.");

			// send the message
			Transport.send(message);

			System.out.println("message sent successfully...");
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
