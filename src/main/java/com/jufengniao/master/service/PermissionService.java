/**
 * 
 */
package com.jufengniao.master.service;

import java.util.List;

import com.jufengniao.framework.service.BaseService;
import com.jufengniao.master.dto.PrivilegeTreeDto;
import com.jufengniao.master.entity.Menu;
import com.jufengniao.master.entity.MenuPermission;
import com.jufengniao.master.entity.Permission;
import com.jufengniao.master.entity.Privilege;

/**
 * @author ClientE
 *
 */
public interface PermissionService extends BaseService<Permission> {
	
	/**
	 * 
	 * @param rid
	 * @return
	 */
	public List<Permission> findPermissionByRole(Long rid);
	
	
	public List<PrivilegeTreeDto> findPrivilegeTreeDtoList(List<Menu> menuList,List<Privilege> pList);

}
