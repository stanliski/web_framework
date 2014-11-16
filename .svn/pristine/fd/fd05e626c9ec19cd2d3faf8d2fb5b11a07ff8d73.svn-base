/**
 * 
 */
package com.jufengniao.framework.controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.jufengniao.framework.tools.Page;


/**
 * @author ClientE
 *
 */
public class BaseController implements SessionAware {

	protected Page page;
	
	protected Long id;
	
	protected String ids;
	
	protected String msg;
	
	protected Map<String, Object> session;
	
	public BaseController(){
		if(page == null){
			page = new Page();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 * 
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public Map<String, Object> getSession(){
		return this.session;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
