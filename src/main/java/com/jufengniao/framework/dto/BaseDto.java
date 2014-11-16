/**
 * 
 */
package com.jufengniao.framework.dto;

import java.io.Serializable;
import java.util.Date;


import org.apache.struts2.json.annotations.JSON;


/**
 * @author clientE
 *
 */
public class BaseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5285944664140455466L;

	private Long id;

    private Date createTime;   
       
    private Date updateTime;   
       
    private Integer isDelete; 
    
    private Long operatorId;
    
    private String sort;
    
    private String orderBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrderBy() {
		return orderBy;
	} 
    
}
