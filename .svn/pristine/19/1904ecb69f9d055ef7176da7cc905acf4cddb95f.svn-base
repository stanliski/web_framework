/**
 * 
 */
package com.jufengniao.framework.service.impl;

import java.util.List;



import org.springframework.transaction.annotation.Transactional;

import com.jufengniao.framework.dao.BaseDao;
import com.jufengniao.framework.filter.BaseFilter;
import com.jufengniao.framework.service.BaseService;
import com.jufengniao.framework.tools.Page;

/**
 * @author clientE
 *
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	
	public abstract BaseDao<T> getDao();
	
	
	
	@Override
	public T get(Long id) {
		return (T) getDao().get(id);
	}

	@Override
	public T save(T t){
		return getDao().save(t);
	}
	
	@Override
	@Transactional
	public void saveOrUpdate(T t) {
		getDao().saveOrUpdate(t);
	}

	@Override
	@Transactional
	public void saveOrUpdateAll(List<T> ts) {
		getDao().saveOrUpdateAll(ts);
	}

	@Override
	@Transactional
	public void deleteAll(List<T> ts) {
		getDao().deleteAll(ts);
	}
	
	@Override
	@Transactional
	public void remove(T t) {
		getDao().remove(t);
	}
	
	@Override
	public boolean isExist(Long id) {
		return getDao().isExist(id);
	}
	
	@Override
	@Transactional
	public void removeById(Long id){
		getDao().removeById(id);
	}
	
	@Override
	public List<T> findListByFilter(BaseFilter filter){
		return getDao().findByFilter(filter);
	}
	
	
	@Override
	public List<T> findPageByFilter(BaseFilter filter,Page page){
		return getDao().findPageByFilter(filter, page);
	}
	
	public List<T> findLastnByFilter(BaseFilter filter,int n){
		return getDao().findLastnByFilter(filter, n);
	}
	
}
