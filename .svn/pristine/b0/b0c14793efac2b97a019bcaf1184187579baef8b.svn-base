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
import com.jufengniao.master.dao.RoleDao;
import com.jufengniao.master.entity.Role;
import com.jufengniao.master.service.RoleService;

/**
 * @author ClientE
 *
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public BaseDao<Role> getDao() {
		return roleDao;//复用service
	}


}
