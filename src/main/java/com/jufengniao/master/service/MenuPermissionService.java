/**
 * 
 */
package com.jufengniao.master.service;

import java.util.List;

import com.jufengniao.framework.service.BaseService;
import com.jufengniao.master.dto.MenuOriginalDto;
import com.jufengniao.master.entity.MenuPermission;

/**
 * @author ClientE
 *
 */
public interface MenuPermissionService extends BaseService<MenuPermission> {
	
	/**
	 * 根据角色生成菜单
	 * @return
	 */
	public List<MenuPermission> findMenuPermissionList(Long rid);

}
