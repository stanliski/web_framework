/**
 * 
 */
package com.jufengniao.master.controller;

import javax.servlet.http.HttpSession;

import org.apache.struts2.json.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jufengniao.framework.controller.BaseController;
import com.jufengniao.framework.entity.JsonResult;
import com.jufengniao.master.dto.UserDto;
import com.jufengniao.master.service.UserService;

/**
 * @author ClientE
 *
 */
@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 登录校验模块
	 * @param userDto
	 * @return
	 */
	/*@RequestMapping(value="/login",method = RequestMethod.POST) 
	public @ResponseBody String login(@ModelAttribute UserDto userDto){
		return userService.login(userDto);
	}*/
	
	@RequestMapping(value="/login",method = RequestMethod.POST) 
	@ResponseBody
	public JsonResult<String> login(@RequestBody UserDto userDto,HttpSession httpSession){
		return new JsonResult(userService.login(userDto,httpSession));
	}

}
