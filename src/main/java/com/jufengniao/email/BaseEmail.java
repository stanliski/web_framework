package com.jufengniao.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jufengniao.master.entity.EmailTemplate;


/**
 * 邮件客户端接口 
 * 
 * @author stanley_hwang
 *
 */
public abstract class BaseEmail {

	public final static String MAIL_AUTH = "true";

	public final static String MAIL_HOST = "smtp.sina.com";

	public final static String MAIL_PORT = "25";

	public final static String MAIL_USERNAME = "antosendmail@sina.com";

	public final static String MAIL_PASSWORD = "auto123456";

	public final static String EMAIL_SMTP_AUTH = "mail.smtp.auth";

	public final static String EMAIL_SMTP_HOST = "mail.smtp.host";

	public final static String EMAIL_SMTP_PORT = "mail.smtp.port";
	
	public String sendTo;

	public static String content;

	public static String subject;
	
	public Properties properties;
	
	public Session session;
	
	private EmailTemplate template;
	
	public BaseEmail(String sendTo, EmailTemplate template){
		this.template = template;
		this.sendTo = sendTo;
	}
	
	/**
	 * Set email configurations.
	 */
	public void config(){
		properties = System.getProperties();
		properties.put(EMAIL_SMTP_AUTH, MAIL_AUTH);
		properties.put(EMAIL_SMTP_HOST, MAIL_HOST);
		properties.put(EMAIL_SMTP_PORT, MAIL_PORT); 
		session = Session.getDefaultInstance(properties, new Authenticator(){
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MAIL_USERNAME, MAIL_PASSWORD); 
			}
		});
	}
	
	public void create() {
		this.subject = template.getSubject();
		this.content = template.getContent();
	}
	
	/**
	 * Send this email;
	 */
	public abstract void send();

	/**
	 * Cancel this email;
	 */
	public abstract void cancel();

}
