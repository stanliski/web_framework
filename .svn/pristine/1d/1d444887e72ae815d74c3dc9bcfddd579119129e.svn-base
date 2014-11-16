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
@Table( name = "tb_menu_permission")
public class MenuPermission extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7159636928626562854L;
	
	@Column
	private Long p_id;//父id
	
	@ManyToOne
	@JoinColumn(name = "m_id")
	private Menu menu;//关联菜单id
	
	@ManyToOne
	@JoinColumn(name = "r_id")
	private Role role;//关联角色表

	public Long getP_id() {
		return p_id;
	}

	public void setP_id(Long p_id) {
		this.p_id = p_id;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
