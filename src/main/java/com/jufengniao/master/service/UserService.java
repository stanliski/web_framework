/**
 * 
 */
package com.jufengniao.master.service;


import javax.servlet.http.HttpSession;


import java.util.List;

import com.jufengniao.framework.service.BaseService;
import com.jufengniao.master.dto.UserDto;
import com.jufengniao.master.entity.User;
import com.jufengniao.master.filter.UserFilter;


/**
 * @author ClientE
 *
 */
public interface UserService extends BaseService<User> {

	/**
	 * 登录
	 * @param userDto
	 * @return
	 */
	public String login(UserDto userDto,HttpSession httpSession);
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public void register(User user);

	/**
	 * 列表查询
	 * @param userDto
	 * @return
	 */
	public List<User> list(UserDto userDto);
	
	/**
	 * 更新信息
	 * @param userDto
	 */
	public void updateInfo(User user);
	
	/**
	 * 校验用户身份
	 * @param userDto
	 * @return
	 */
	public String verify(UserDto userDto);
	
	/**
	 * 重新设置新密码
	 * @param filter
	 * @return
	 */
	public String resetPassword(UserFilter filter);
	
	/**
	 * 发送重置密码邮件
	 * @param newPwd
	 * @return
	 */
	public void sendResetPwdEmail(String sendto, String newPwd);
	
}
