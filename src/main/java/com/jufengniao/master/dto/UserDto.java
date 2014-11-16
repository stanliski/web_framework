/**
 * 
 */
package com.jufengniao.master.dto;

import com.jufengniao.framework.dto.BaseDto;



/**
 * @author ClientE
 *
 */
public class UserDto extends BaseDto {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1909842525177849685L;

	private String usercode;//用户名
	
	private String password;//密码
	
	private Long r_id;//角色
	
	private String mobile; //手机 
	
	private String email;  //邮箱

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Long getR_id() {
		return r_id;
	}

	public void setR_id(Long r_id) {
		this.r_id = r_id;
	}
}
