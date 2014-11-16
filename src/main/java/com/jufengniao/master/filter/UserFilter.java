/**
 * 
 */
package com.jufengniao.master.filter;


import javax.persistence.Column;

import com.jufengniao.framework.annotation.Operation;
import com.jufengniao.framework.annotation.OperationType;
import com.jufengniao.framework.filter.BaseFilter;

/**
 * @author ClientE
 *
 */
public class UserFilter extends BaseFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 884224317339773603L;
	
	@Operation(name = "usercode",type=OperationType.EQ)
	private String usercode;//用户名
	
	@Operation(name = "password",type=OperationType.EQ)
	private String password;//密码

	@Operation(name = "email",type=OperationType.EQ)
	private String email;  // 邮箱

	@Operation(name = "mobile",type=OperationType.EQ)
	private String mobile;  // 手机 

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
