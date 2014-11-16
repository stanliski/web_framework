/**
 * 
 */
package com.jufengniao.master.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.jufengniao.framework.entity.BaseEntity;

/**
 * 功能表
 * @author ClientE
 *
 */
@Entity
@Table( name = "tb_function")
public class Function extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -786428441128084928L;
	
	@Column
	private String code;//代码
	
	@Column
	private String name;//名称
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "function")
	private Set<Privilege> privilegeList;

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

	public Set<Privilege> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(Set<Privilege> privilegeList) {
		this.privilegeList = privilegeList;
	}
	
	

}
