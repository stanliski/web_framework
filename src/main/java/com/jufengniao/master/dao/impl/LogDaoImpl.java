package com.jufengniao.master.dao.impl;

import org.springframework.stereotype.Repository;

import com.jufengniao.framework.dao.impl.BaseDaoImpl;
import com.jufengniao.master.dao.LogDao;
import com.jufengniao.master.entity.Log;
import com.jufengniao.master.entity.User;

/**
 * 日志数据访问接口实现类
 * @author stanley
 *
 */

@Repository
public class LogDaoImpl extends BaseDaoImpl<Log> implements LogDao{

}
