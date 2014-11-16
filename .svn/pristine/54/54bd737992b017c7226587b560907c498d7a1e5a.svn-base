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
 * 授权表
 * @author ClientE
 *
 */
@Entity
@Table(name = "tb_permission")
public class Permission extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1952129178206256058L;
	
	
	@ManyToOne
	@JoinColumn(name = "r_id")
	private Role role;//关联角色表
	
	@ManyToOne
	@JoinColumn(name = "p_id")
	private Privilege privilege;//关联权限表
	
	@Column
	private Long parent_id;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public Long getParent_id() {
		return parent_id;
	}

	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}

}
