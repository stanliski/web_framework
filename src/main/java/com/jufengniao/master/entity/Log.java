package com.jufengniao.master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jufengniao.framework.entity.BaseEntity;

/**
 * 日志类 记录用户操作
 * @author stanley
 *
 */

@Entity
@Table(name="tb_log")
public class Log extends BaseEntity{

	private static final long serialVersionUID = 1024792477652984770L;  
	
	@Column(name="user_id")
	private Long userid;//管理员id  
	
	@Column
	private String operation;//操作(主要是"添加"、"修改"、"删除")  

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
}
