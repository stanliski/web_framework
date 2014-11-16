/**
 * 
 */
package com.jufengniao.master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.jufengniao.framework.entity.BaseEntity;

/**
 * @author ClientE
 *
 */
@Entity
@Table(name = "tb_user")
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 811821566512695785L;

	@Column
	private String usercode;//用户名

	@Column
	private String password;//密码
	
	@ManyToOne
	@JoinColumn(name = "r_id")
	private Role role;

	/*@Column
	private String role; // 角色
*/
/*	@Column
	private String company; // 公司 

	@Column
	private String email;  // 邮箱

	@Column
	private String mobile;  // 手机 

	@Column
	private String telephone; // 座机

	@Column
	private String address;  // 地址 

	@Column
	private String zipCode; // 邮政编码
*/

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


/*	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}*/

}
