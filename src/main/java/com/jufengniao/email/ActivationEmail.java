package com.jufengniao.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jufengniao.master.entity.EmailTemplate;


/**
 * 
 * 激活邮件实例
 * 
 * @author stanley_hwang
 *
 */
public class ActivationEmail extends BaseEmail{

	private static Log m_log = LogFactory.getLog(ActivationEmail.class);
	
	public ActivationEmail(String sendTo, EmailTemplate emailTemplate){
		super(sendTo, emailTemplate);
	}
	
	/**
	 * @param sendTo
	 * @param subject
	 * @param body
	 */
	public void send() {
		try {
			String from = "antosendmail@sina.com";
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO,
					new InternetAddress(sendTo));
			message.setSubject(subject);
			message.setText(content);
			Transport.send(message);
			m_log.info("Sent message successfully....");
		} catch (MessagingException e){
			m_log.error("send message error");
		}
	}

	public void cancel() {
		
	}

}
