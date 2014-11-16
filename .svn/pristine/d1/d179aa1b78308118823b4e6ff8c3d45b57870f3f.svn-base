/**
 * 
 */
package com.jufengniao.master.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jufengniao.framework.dao.BaseDao;
import com.jufengniao.framework.service.impl.BaseServiceImpl;
import com.jufengniao.framework.tools.CommonEnum;
import com.jufengniao.master.dao.MenuPermissionDao;
import com.jufengniao.master.dto.MenuOriginalDto;
import com.jufengniao.master.entity.MenuPermission;
import com.jufengniao.master.filter.MenuPermissionFilter;
import com.jufengniao.master.service.MenuPermissionService;
import com.jufengniao.master.tools.MasterEnum;

/**
 * @author ClientE
 *
 */
@Service
public class MenuPermissionServiceImpl extends BaseServiceImpl<MenuPermission> implements
		MenuPermissionService {
	
	@Autowired
	private MenuPermissionDao menuPermissionDao;

	@Override
	public BaseDao<MenuPermission> getDao() {
		return menuPermissionDao;
	}

	@Override
	public List<MenuPermission> findMenuPermissionList(Long rid) {
		if(rid != null){
			MenuPermissionFilter filter = new MenuPermissionFilter();
			filter.setR_id(rid);
			filter.setIsDelete(CommonEnum.DeleteEnum.NOTDELETE.getInteger());
			return menuPermissionDao.findByFilter(filter);
		}else{
			return null;
		}
		
	}

}
