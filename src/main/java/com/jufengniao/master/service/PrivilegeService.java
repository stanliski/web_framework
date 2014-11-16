/**
 * 
 */
package com.jufengniao.master.service;

import java.util.List;

import com.jufengniao.framework.service.BaseService;
import com.jufengniao.master.entity.Permission;
import com.jufengniao.master.entity.Privilege;

/**
 * @author ClientE
 *
 */
public interface PrivilegeService extends BaseService<Privilege> {
	
	/**
	 * 根据授权找到权限表
	 * @param permissionList
	 * @return
	 */
	public List<Privilege> findPrivilegeByPermission(List<Permission> permissionList);

}
