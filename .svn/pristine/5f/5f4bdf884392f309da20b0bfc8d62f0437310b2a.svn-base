/**
 * 
 */
package com.jufengniao.master.service;

import java.util.List;

import com.jufengniao.framework.service.BaseService;
import com.jufengniao.master.dto.MenuDto;
import com.jufengniao.master.dto.MenuOriginalDto;
import com.jufengniao.master.entity.Menu;
import com.jufengniao.master.entity.MenuPermission;
import com.jufengniao.master.entity.Permission;
import com.jufengniao.master.entity.Privilege;

/**
 * @author ClientE
 *
 */
public interface MenuService extends BaseService<Menu> {

	/**
	 * 根据角色自动生成菜单
	 * @return
	 */
	public List<MenuOriginalDto> findMenuOriginalList(List<MenuPermission> menuPermissionList);
	
	/**
	 * 新增菜单
	 */
	public String addMenu(MenuDto menuDto);
	
}
