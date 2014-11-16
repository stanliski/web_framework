/**
 * 
 */
package com.jufengniao.framework.service;

import java.util.List;


import com.jufengniao.framework.filter.BaseFilter;
import com.jufengniao.framework.tools.Page;

/**
 * @author clientE
 *
 */
public interface BaseService<T> {
	
	/**
	 * 根据id获取实体
	 * @param id
	 * @return
	 */
	public T get(Long id);
	
	public T save(T t);
	
	public void saveOrUpdate(T t);
	
	public void saveOrUpdateAll(List<T> ts);
	
	public void deleteAll(List<T> ts);
	
	public void remove(T t);
	
	public boolean isExist(Long id);
	
	public void removeById(Long id);
	
	public List<T> findListByFilter(BaseFilter filter);
	
	public List<T> findPageByFilter(BaseFilter filter,Page page);
	
	public List<T> findLastnByFilter(BaseFilter filter,int n);
	
}
