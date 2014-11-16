/**
 * 
 */
package com.jufengniao.master.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import com.jufengniao.framework.entity.BaseEntity;

/**
 * @author ClientE
 *
 */
@Entity
@Table(name = "tb_role")
public class Role extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2531386316847802572L;
	
	private String code;//角色代码
	
	private String name;//角色名称
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
	private Set<User> userList;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
	private Set<Permission> permissionList;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
	private Set<MenuPermission> menuPermissionList;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUserList() {
		return userList;
	}

	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}

	public Set<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(Set<Permission> permissionList) {
		this.permissionList = permissionList;
	}

	public Set<MenuPermission> getMenuPermissionList() {
		return menuPermissionList;
	}

	public void setMenuPermissionList(Set<MenuPermission> menuPermissionList) {
		this.menuPermissionList = menuPermissionList;
	}

}
