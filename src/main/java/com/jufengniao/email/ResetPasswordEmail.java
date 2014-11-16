package com.jufengniao.email;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jufengniao.master.entity.EmailTemplate;


/**
 * 
 * 重设密码邮件
 * 
 * @author stanley
 *
 */
public class ResetPasswordEmail extends BaseEmail{

	private static Log m_log = LogFactory.getLog(ActivationEmail.class);
	
	public ResetPasswordEmail(String sendTo, EmailTemplate template) {
		super(sendTo, template);
	}

	@Override
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
		//	m_log.info("Sent message successfully....");
			System.out.println("Sent message successfully....");
		} catch (MessagingException e){
		//	m_log.error("send message error");
			System.out.println("send message error");
		}
	}

	@Override
	public void cancel() {
		
	}

}
