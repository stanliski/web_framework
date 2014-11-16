package com.jufengniao.master.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jufengniao.framework.dao.BaseDao;
import com.jufengniao.framework.filter.BaseFilter;
import com.jufengniao.framework.service.impl.BaseServiceImpl;
import com.jufengniao.master.dao.LogDao;
import com.jufengniao.master.entity.Log;
import com.jufengniao.master.service.LogService;


/**
 * 日志业务逻辑实现类
 * 
 * @author stanley
 *
 */
@Service
public class LogServiceImpl extends BaseServiceImpl<Log> implements LogService{

	@Autowired
	private LogDao logDao;
	
	@Override
	public BaseDao<Log> getDao() {
		return logDao;
	}

	/**
	 * 添加Log
	 * @param log
	 */
	@Override
	public void addLog(Log log) {
		logDao.save(log);
	}

	/**
	 *返回Log列表
	 */
	@Override
	public List<Log> listLog(BaseFilter filter) {
		return logDao.findByFilter(filter);
	}
	

}
