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
 * 菜单表
 * @author ClientE
 *
 */
@Entity
@Table(name = "tb_menu")
public class Menu extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1738146054044703847L;
	
	private String code;//代码
	
	private String name;//名称
	
	private Long p_id;//父节点id
	
	private int order_no;//组内顺序
	
	private String link;//连接
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "menu")
	private Set<Privilege> privilegeList;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "menu")
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

	public Long getP_id() {
		return p_id;
	}

	public void setP_id(Long p_id) {
		this.p_id = p_id;
	}


	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Set<Privilege> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(Set<Privilege> privilegeList) {
		this.privilegeList = privilegeList;
	}

	public Set<MenuPermission> getMenuPermissionList() {
		return menuPermissionList;
	}

	public void setMenuPermissionList(Set<MenuPermission> menuPermissionList) {
		this.menuPermissionList = menuPermissionList;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	

}
