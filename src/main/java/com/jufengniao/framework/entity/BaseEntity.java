package com.jufengniao.framework.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**  
 * 统一定义id的entity基类.  
 *   
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略.  
 * 子类可重载getId()函数重定义id的列名映射和生成策略.  
 *   
 * @author clientE
 */  
@MappedSuperclass
public class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6003092841572336099L;
	
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "create_time",updatable = false)   
    private Date createTime = new Date();   
       
    @Column(name = "update_time") 
    private Date updateTime;   
       
    @Column(name = "is_delete")
    private Integer isDelete; 
    
    @Column(name = "operator_id")
    private Long operatorId;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdate() {
		return updateTime;
	}

	public void setLastUpdate(Date updateTime) {
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




}
