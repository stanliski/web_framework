/**
 * 
 */
package com.jufengniao.master.service.impl;



import javax.servlet.http.HttpSession;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jufengniao.framework.dao.BaseDao;
import com.jufengniao.framework.service.impl.BaseServiceImpl;
import com.jufengniao.master.dao.UserDao;
import com.jufengniao.master.dto.UserDto;
import com.jufengniao.master.entity.EmailTemplate;
import com.jufengniao.master.entity.User;
import com.jufengniao.master.filter.UserFilter;
import com.jufengniao.master.service.UserService;
import com.jufengniao.master.tools.MasterConstant;
import com.jufengniao.master.tools.email.BaseEmail;
import com.jufengniao.master.tools.email.EmailGenerator;


/**
 * @author ClientE
 *
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {


	@Autowired
	private UserDao userDao;

	@Override
	public BaseDao<User> getDao() {
		return userDao;
	}

	/**
	 * 登录
	 */
	@Override
	public String login(UserDto userDto,HttpSession httpSession) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		if(userDto != null){
			UserFilter filter = new UserFilter();
			filter.setUsercode(userDto.getUsercode());
			if(userDao.isExist(filter)){//校验用户名
				//filter.setPassword(encoder.encodePassword(userDto.getPassword(), null));
				filter.setPassword(userDto.getPassword());
				if(userDao.isExist(filter)){//校验密码
					User user = userDao.findByFilter(filter).get(0);
					//model.addAttribute("currUser", user);
					httpSession.setAttribute("currUser", user);
					return MasterConstant.LOGIN_SUCCESS;
				}else{
					return MasterConstant.PASSWORD_IS_WRONG;
				}
			}else{
				return MasterConstant.USER_IS_NOT_EXIT;//用户不存在
			}
		}else{
			return null;
		}
	}

	/**
	 * 注册
	 */
	@Override
	public void register(User user) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		user.setPassword(encoder.encodePassword(user.getPassword(), null));
		userDao.save(user);
	}

	/**
	 * 校验身份 用于找回密码
	 */
	@Override
	public String verify(UserDto userDto) {
		if(userDto != null){
			UserFilter filter = new UserFilter();
			filter.setUsercode(userDto.getUsercode());
			filter.setEmail(userDto.getEmail());
			filter.setMobile(userDto.getMobile());
			if(userDao.isExist(filter)){
				String newPwd = resetPassword(filter);
				sendResetPwdEmail(userDto.getEmail(), newPwd);
				return MasterConstant.USER_RESET_PASSWORD_SUCCESS;
			}else{
				return MasterConstant.USER_IS_NOT_EXIT;
			}
		}
		return null;
	}

	/**
	 * 重新设置新密码
	 * @param filter
	 * @return
	 */
	@Override
	public String resetPassword(UserFilter filter){
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		List<User> list = userDao.findByFilter(filter);
		User user = list.get(0);
		// 5位随机密码
		String password = String.valueOf((int)(Math.random()*100000 + 1));
		user.setPassword(encoder.encodePassword(password, null));
		userDao.saveOrUpdate(user);
		return password;
	}

	/**
	 * 发送重置密码邮件
	 * @param newPwd
	 * @return
	 */
	@Override
	public void sendResetPwdEmail(String sendto, String newPwd) {
		EmailTemplate emailTemplate = new EmailTemplate();
		emailTemplate.setContent("你的新密码是：" + newPwd);
		emailTemplate.setSubject("找回密码");
		BaseEmail email = EmailGenerator.getInstance().createResetPasswordEmail(sendto, 
				emailTemplate);
		email.send();
	}

	/**
	 * 返回用户列表
	 */
	@Override
	public List<User> list(UserDto userDto) {
		List<User> result = null;
		if(userDto != null){
			UserFilter filter = new UserFilter();
			filter.setUsercode(userDto.getUsercode());
			filter.setEmail(userDto.getEmail());
			filter.setMobile(userDto.getMobile());
			result = userDao.findByFilter(filter);
		}
		return result;
	}

	/**
	 * 更新 信息
	 */
	@Override
	public void updateInfo(User user) {
		userDao.saveOrUpdate(user);
	}



}
