/**
 * 
 */
package com.jufengniao.master.filter;

import com.jufengniao.framework.filter.BaseFilter;

import framework.annotation.Operation;
import framework.annotation.OperationType;

/**
 * @author ClientE
 *
 */
public class MenuPermissionFilter extends BaseFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2155071314639654375L;
	
	private Long m_id;
	
	@Operation(name = "r_id" ,type = OperationType.EQ)
	private Long r_id;
	
	private Long p_id;
	
	@Operation(name = "is_delete" ,type = OperationType.EQ)
    private Integer isDelete; 

	public Long getM_id() {
		return m_id;
	}

	public void setM_id(Long m_id) {
		this.m_id = m_id;
	}

	public Long getR_id() {
		return r_id;
	}

	public void setR_id(Long r_id) {
		this.r_id = r_id;
	}

	public Long getP_id() {
		return p_id;
	}

	public void setP_id(Long p_id) {
		this.p_id = p_id;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}
