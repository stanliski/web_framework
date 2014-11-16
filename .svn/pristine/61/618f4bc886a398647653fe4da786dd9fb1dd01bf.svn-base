/**
 * 
 */
package com.jufengniao.master.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.jufengniao.framework.dto.BaseDto;

/**
 * @author ClientE
 *
 */
public class MenuOriginalDto extends BaseDto {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3284837884610052771L;

	private String code;//代码
	
	private String name;//名称
	
	private Long p_id;//父节点id
	
	private int order;//组内顺序
	
	private String link;//连接
	
	private List<MenuOriginalDto> subMenu;

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

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<MenuOriginalDto> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<MenuOriginalDto> subMenu) {
		this.subMenu = subMenu;
	}
	
	public void add(MenuOriginalDto menuDto){
		if(this.subMenu == null){
			this.subMenu = new ArrayList<MenuOriginalDto>();
		}
		this.subMenu.add(menuDto);
	}


}
