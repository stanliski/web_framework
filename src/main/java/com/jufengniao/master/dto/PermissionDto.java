/**
 * 
 */
package com.jufengniao.master.dto;

import com.jufengniao.framework.dto.BaseDto;

/**
 * @author ClientE
 *
 */
public class PermissionDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5822373718728043523L;
	
	private Long p_id;
	
	private Long r_id;
	
	private Long parent_id;

	public Long getP_id() {
		return p_id;
	}

	public void setP_id(Long p_id) {
		this.p_id = p_id;
	}

	public Long getR_id() {
		return r_id;
	}

	public void setR_id(Long r_id) {
		this.r_id = r_id;
	}

	public Long getParent_id() {
		return parent_id;
	}

	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}
	

}
