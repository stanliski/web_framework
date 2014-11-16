/**
 * 
 */
package com.jufengniao.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jufengniao.framework.dao.BaseDao;
import com.jufengniao.framework.service.impl.BaseServiceImpl;
import com.jufengniao.master.dao.PrivilegeDao;
import com.jufengniao.master.entity.Permission;
import com.jufengniao.master.entity.Privilege;
import com.jufengniao.master.service.PrivilegeService;

/**
 * @author ClientE
 *
 */
@Service
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements
		PrivilegeService {
	
	@Autowired
	private PrivilegeDao privilegeDao;

	@Override
	public BaseDao<Privilege> getDao() {
		return privilegeDao;
	}

	@Override
	public List<Privilege> findPrivilegeByPermission(List<Permission> permissionList) {
		if(permissionList != null){
			List<Privilege> pList = new ArrayList<Privilege>();
			for(Permission p : permissionList){
				pList.add(p.getPrivilege());
			}
			return pList;
		}else{
			return null;
		}
	}
}
