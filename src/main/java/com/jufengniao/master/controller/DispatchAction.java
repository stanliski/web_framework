/**
 * 
 */
package com.jufengniao.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author ClientE
 *
 */
@Controller
@RequestMapping(value="/")
public class DispatchAction {

	@RequestMapping(value="/login")
	public String loginPage(){
		return "index/login";
	}
	
	@RequestMapping(value="/index")
	public String indexPage(){
		return "index/index";
	}
	
}
