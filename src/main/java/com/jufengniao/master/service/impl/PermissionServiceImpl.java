/**
 * 
 */
package com.jufengniao.master.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jufengniao.framework.dao.BaseDao;
import com.jufengniao.framework.service.impl.BaseServiceImpl;
import com.jufengniao.master.dao.PermissionDao;
import com.jufengniao.master.dto.PrivilegeTreeDto;
import com.jufengniao.master.entity.Function;
import com.jufengniao.master.entity.Menu;
import com.jufengniao.master.entity.MenuPermission;
import com.jufengniao.master.entity.Permission;
import com.jufengniao.master.entity.Privilege;
import com.jufengniao.master.filter.PermissionFilter;
import com.jufengniao.master.service.PermissionService;

/**
 * @author ClientE
 *
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements
		PermissionService {
	
	@Autowired
	private PermissionDao permissionDao;

	@Override
	public BaseDao<Permission> getDao() {
		return permissionDao;
	}

	@Override
	public List<Permission> findPermissionByRole(Long rid) {
		if(rid != null){
			PermissionFilter filter = new PermissionFilter();
			filter.setR_id(rid);
			return permissionDao.findByFilter(filter);
		}else{
			return null;
		}
		
	}

	@Override
	public List<PrivilegeTreeDto> findPrivilegeTreeDtoList(List<Menu> menuList,List<Privilege> pList) {
		
		List<PrivilegeTreeDto> ptDtoList = null;
		//先对菜单进行遍历
		if(menuList != null){
			ptDtoList = new ArrayList<PrivilegeTreeDto>();
			Map<String,PrivilegeTreeDto> menuMap = new HashMap<String, PrivilegeTreeDto>();
			for(Menu m : menuList ){
				PrivilegeTreeDto ptDto = new PrivilegeTreeDto();
				ptDto.setId("m" + m.getId());
				ptDto.setName(m.getName());
				ptDto.setLink(m.getLink());
				if(m.getP_id() == 0 ){//TODO
					ptDto.setState("closed");
					ptDtoList.add(ptDto);
					
					menuMap.put("m"+m.getId(), ptDto);
				}else{
					PrivilegeTreeDto pDto = menuMap.get("m"+m.getP_id());
					ptDto.setParentId("m"+m.getP_id());
					//ptDto.setState("closed");
					pDto.add(ptDto);
					menuMap.put("m"+m.getId(), ptDto);
				}
				//menuMap.put(m.getId(), ptDto);
			}
			
			//对菜单功能进行遍历
			if(pList != null){
				for(Privilege p : pList){
					Function f = p.getFunction();
					PrivilegeTreeDto ptDto = new PrivilegeTreeDto();
					ptDto.setId("f" + f.getId());
					ptDto.setName(f.getName());
					ptDto.setParentId("m"+p.getMenu().getId());
					PrivilegeTreeDto pDto = menuMap.get("m"+p.getMenu().getId());
					pDto.add(ptDto);
					pDto.setState("closed");
				}
			}
		}
		
		return ptDtoList;
	}

}
