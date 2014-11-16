/**
 * 
 */
package com.jufengniao.master.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jufengniao.framework.entity.JsonResult;
import com.jufengniao.master.dto.PrivilegeTreeDto;
import com.jufengniao.master.entity.Menu;
import com.jufengniao.master.entity.MenuPermission;
import com.jufengniao.master.entity.Privilege;
import com.jufengniao.master.entity.User;
import com.jufengniao.master.service.MenuService;
import com.jufengniao.master.service.PermissionService;
import com.jufengniao.master.service.PrivilegeService;

/**
 * @author ClientE
 *
 */
@Controller
@RequestMapping(value="/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@RequestMapping(value="/buildPermissionTree",method = RequestMethod.POST) 
	@ResponseBody
	public List<PrivilegeTreeDto> login(HttpSession httpSession){
		
		List<Menu> menuList = menuService.findListByFilter(null);
		
		List<Privilege> pList = privilegeService.findListByFilter(null);
		
		List<PrivilegeTreeDto> tree = permissionService.findPrivilegeTreeDtoList(menuList, pList);
		
		Map treeMap = new HashMap<String, List<PrivilegeTreeDto>>();
		treeMap.put("rows", tree);
		return tree;
	}

}
