package com.jufengniao.master.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jufengniao.master.dto.UserDto;
import com.jufengniao.master.entity.User;
import com.jufengniao.master.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) 
public class UserTest {

	@Autowired  
	private UserService userService;  

	@Test  
	public void test() {  
		User user = new User();
		user.setAddress("Beijing");
		user.setUsercode("andy");
		user.setPassword("123");
		user.setMobile("123");
		user.setEmail("1015757334@qq.com");
		userService.register(user);
	}  
	
	@Test  
	public void testVerify() {  
		UserDto userDto = new UserDto();
		userDto.setMobile("123");
		userDto.setEmail("1015757334@qq.com");
		userDto.setUsercode("andy");
		String result = userService.verify(userDto);
		System.out.println(result);
	}  
	
	@Test  
	public void testLogin(){
		UserDto user = new UserDto();
		user.setUsercode("terry");
		user.setPassword("1234");
		String result = userService.login(user);
		System.out.println(result);
	}

}
