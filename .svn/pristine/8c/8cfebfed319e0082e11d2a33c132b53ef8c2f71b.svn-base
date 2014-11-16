/**
 * 
 */
package com.jufengniao.master.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.jufengniao.framework.entity.BaseEntity;

/**
 * 权限表
 * @author ClientE
 *
 */
@Entity
@Table(name = "tb_privilege")
public class Privilege extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1042551712514906305L;
	
	@ManyToOne
	@JoinColumn(name = "f_id")
	private Function function;//关联功能表id
	
	@ManyToOne
	@JoinColumn(name = "m_id")
	private Menu menu;//关联菜单id

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
