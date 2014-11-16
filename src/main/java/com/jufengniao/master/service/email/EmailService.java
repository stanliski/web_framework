package com.jufengniao.master.service.email;

import org.springframework.stereotype.Service;

import com.jufengniao.master.entity.EmailTemplate;


/**
 * 邮件 业务层
 * @author stanley
 *
 */
public interface EmailService {
	
	public void addTemplate(EmailTemplate email);
	
	public EmailTemplate getTemplate(int id);
	
	
}
