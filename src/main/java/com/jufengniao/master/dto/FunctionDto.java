/**
 * 
 */
package com.jufengniao.master.dto;

import com.jufengniao.framework.dto.BaseDto;

/**
 * @author ClientE
 *
 */
public class FunctionDto extends BaseDto {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1819720785868146710L;

	private String code;
	
	private String name;

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

}
