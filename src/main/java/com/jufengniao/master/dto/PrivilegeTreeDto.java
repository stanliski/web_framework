/**
 * 
 */
package com.jufengniao.master.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jufengniao.framework.dto.BaseDto;

/**
 * @author ClientE
 *
 */
public class PrivilegeTreeDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7896353395713148227L;

	private String id;
	
	private String name;
	
	private String state;
	
	private String link;
	
	private List<PrivilegeTreeDto> children;
	
	private String parentId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<PrivilegeTreeDto> getChildren() {
		return children;
	}

	public void setChildren(List<PrivilegeTreeDto> children) {
		this.children = children;
	}
	
	public void add(PrivilegeTreeDto dto){
		if(this.children == null){
			this.children = new ArrayList<PrivilegeTreeDto>();
		}
		this.children.add(dto);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	
}
