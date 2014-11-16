package com.jufengniao.master.log;

import java.lang.reflect.Method;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jufengniao.master.dao.UserDao;
import com.jufengniao.master.entity.Log;
import com.jufengniao.master.service.LogService;

/**
 * 用户操作日志
 * 
 * @author stanley
 *
 */
@Aspect
@Component
public class LogAspect {

	@Autowired
	private UserDao userDao;

	/** 日志业务逻辑类 */
	@Autowired
	private LogService logService;

	/** 
	 * 添加业务逻辑方法切入点 
	 */  
	@Pointcut("execution(* com.jufengniao.master.service.UserService.login(..))")  
	public void insertServiceLogin() { }  

	@Pointcut("execution(* com.jufengniao.master.service.UserService.register(..))")
	public void insertServiceRegister(){}

	/**
	 * 添加登录日志 
	 * @param joinPoint
	 * @param error
	 */
	@AfterReturning(value="insertServiceLogin()", argNames="rtv", returning="rtv")  
	public void insertLoginLog(JoinPoint joinPoint, Object rtv) throws Throwable {
		if(joinPoint.getArgs() == null){ 
			return;  
		}  
		// 获取操作内容
		String optionContent = adminOptionContent(joinPoint.getArgs(), joinPoint.getSignature().getName());
		// 添加日志
		Log log = new Log();
		System.out.println("option Content:" + optionContent);
		log.setLastUpdate(new Date());
		log.setOperation(optionContent);
		log.setCreateTime(new Date());
		logService.addLog(log);
	}

	/**
	 * 添加注册日志
	 * @param joinPoint
	 * @param error
	 */
	@AfterReturning(value="insertServiceRegister()", argNames="rtv", returning="rtv")  
	public void insertRegisterLog(JoinPoint joinPoint, Object rtv) throws Throwable {
		if(joinPoint.getArgs() == null){ 
			return;  
		}  
		// 获取操作内容
		String optionContent = adminOptionContent(joinPoint.getArgs(), joinPoint.getSignature().getName());
		// 添加日志
		Log log = new Log();
		log.setLastUpdate(new Date());
		log.setOperation(optionContent);
		log.setCreateTime(new Date());
		logService.addLog(log);
	}

	/** 
	 * 使用Java反射来获取被拦截方法(insert、update)的参数值， 
	 * 将参数值拼接为操作内容 
	 */  
	public String adminOptionContent(Object[] args, String mName) throws Exception{  
		if (args == null) {  
			return null;  
		}  
		StringBuffer rs = new StringBuffer();  
		rs.append(mName);  
		String className = null;  
		int index = 1;  
		// 遍历参数对象  
		for (Object info : args) {  
			//获取对象类型  
			className = info.getClass().getName();  
			className = className.substring(className.lastIndexOf(".") + 1);  
			rs.append("[parameters" + index + ",type:" + className + ",value:");  
			// 获取对象的所有方法  
			Method[] methods = info.getClass().getDeclaredMethods();  
			// 遍历方法，判断get方法  
			for (Method method : methods) {  
				String methodName = method.getName();  
				// 判断是不是get方法  
				if (methodName.indexOf("get") == -1) {// 不是get方法  
					continue;// 不处理  
				}  
				Object rsValue = null;  
				try {  
					// 调用get方法，获取返回值  
					rsValue = method.invoke(info);  
					if (rsValue == null) {//没有返回值  
						continue;  
					}  
				} catch (Exception e) {  
					continue;  
				}  
				//将值加入内容中  
				rs.append("(" + methodName + " : " + rsValue + ")");  
			}  
			rs.append("]");  
			index++;  
		}  
		return rs.toString();  
	}  
}
