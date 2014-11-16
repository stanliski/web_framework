/**
 * 
 */
package com.jufengniao.master.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jufengniao.framework.dao.BaseDao;
import com.jufengniao.framework.filter.BaseFilter;
import com.jufengniao.framework.service.impl.BaseServiceImpl;
import com.jufengniao.framework.tools.Page;
import com.jufengniao.master.dao.FunctionDao;
import com.jufengniao.master.entity.Function;
import com.jufengniao.master.service.FunctionService;

/**
 * @author ClientE
 *
 */
@Service
public class FunctionServiceImpl extends BaseServiceImpl<Function> implements
		FunctionService {
	
	@Autowired
	private FunctionDao functionDao;

	@Override
	public BaseDao<Function> getDao() {
		return functionDao;
	}

}
