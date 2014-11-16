/**
 * 
 */
package com.jufengniao.master.dto;

import com.jufengniao.framework.dto.BaseDto;

/**
 * @author ClientE
 *
 */
public class MenuDto extends BaseDto {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5625732013077872213L;

	private String code;//代码
	
	private String name;//名称
	
	private Long p_id;//父节点id
	
	private int order_no;//组内顺序
	
	private String link;//连接

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

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	

}
