/**
 * 
 */
package com.jufengniao.master.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jufengniao.framework.controller.BaseController;
import com.jufengniao.framework.entity.JsonResult;
import com.jufengniao.master.dto.MenuDto;
import com.jufengniao.master.dto.UserDto;
import com.jufengniao.master.entity.MenuPermission;
import com.jufengniao.master.entity.User;
import com.jufengniao.master.service.MenuPermissionService;
import com.jufengniao.master.service.MenuService;

/**
 * @author ClientE
 *
 */
@Controller
@RequestMapping(value="/menu")
public class MenuController extends BaseController{
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private MenuPermissionService menuPermissionService;
	
	@RequestMapping(value="/buildMenu",method = RequestMethod.POST) 
	@ResponseBody
	public JsonResult<List> buildMenu(HttpSession httpSession){
		User user = (User) httpSession.getAttribute("currUser");
		List<MenuPermission> menuPermissionList = menuPermissionService.findMenuPermissionList(user.getRole().getId());
		return new JsonResult(menuService.findMenuOriginalList(menuPermissionList));
	}
	
	/**
	 * 新增菜单
	 */
	@RequestMapping(value="/add",method = RequestMethod.POST) 
	@ResponseBody
	public JsonResult<String> add(@RequestBody MenuDto menuDto){
		String msg = menuService.addMenu(menuDto);
		return new JsonResult(msg);
	}

}
