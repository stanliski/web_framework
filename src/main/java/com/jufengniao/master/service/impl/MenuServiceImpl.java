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
import com.jufengniao.master.dao.MenuDao;
import com.jufengniao.master.dto.MenuDto;
import com.jufengniao.master.dto.MenuOriginalDto;
import com.jufengniao.master.entity.Menu;
import com.jufengniao.master.entity.MenuPermission;
import com.jufengniao.master.filter.MenuFilter;
import com.jufengniao.master.service.MenuService;
import com.jufengniao.master.tools.MasterConstant;
import com.jufengniao.master.tools.MasterEnum.MenuEnum;
import com.jufengniao.framework.tools.CommonAssemble;

/**
 * @author ClientE
 *
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

	@Autowired
	private MenuDao menuDao;
	
	@Override
	public BaseDao<Menu> getDao() {
		return menuDao;
	}

	@Override
	public List<MenuOriginalDto> findMenuOriginalList(List<MenuPermission> menuPermissionList) {
		if(menuPermissionList != null){
			//找到所有menu
			List<MenuOriginalDto> menuList = new ArrayList<MenuOriginalDto>();
			Map<Long, MenuOriginalDto> menuMap = new HashMap<Long, MenuOriginalDto>();
			for(MenuPermission p : menuPermissionList){
				MenuOriginalDto mDto = new MenuOriginalDto();
				CommonAssemble.set(mDto, p.getMenu());
				if( p.getP_id() == MenuEnum.ISPARENT.getValue()){
					menuMap.put(p.getMenu().getId(), mDto);
				}else{
					MenuOriginalDto pDto = menuMap.get(mDto.getP_id());
					pDto.add(mDto);
				}
			}
			for(Long key : menuMap.keySet()){
				menuList.add(menuMap.get(key));
			}
			return menuList;
			
		}else{
			return null;
		}

	}

	@Override
	public String addMenu(MenuDto menuDto) {
		if(menuDto != null){
			
			MenuFilter filter = new MenuFilter();
			filter.setCode(menuDto.getCode());
			if(menuDao.isExist(filter)){
				return MasterConstant.MENU_IS_EXIT;
			}else{
				Menu menu = new Menu();
				CommonAssemble.set(menu, menuDto);
				menuDao.save(menu);
				return MasterConstant.SUCCESS;
			}
			
		}else{
			return MasterConstant.FAIL;
		}
		
	}

}
