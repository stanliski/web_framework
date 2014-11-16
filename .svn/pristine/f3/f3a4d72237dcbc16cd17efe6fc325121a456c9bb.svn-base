package com.jufengniao.framework.dao.impl;

import java.util.List;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jufengniao.framework.annotation.Operation;
import com.jufengniao.framework.annotation.OperationType;
import com.jufengniao.framework.dao.BaseDao;
import com.jufengniao.framework.filter.BaseFilter;
import com.jufengniao.framework.tools.Page;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{
	protected Class<T> entityClass;    
	protected String className;
	
	protected HibernateTemplate hibernateTemplate=null;
	
	//protected Session session = null;
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		super();
		this.entityClass = null;
		
		Class<? extends Object> c = getClass();
		Type type = c.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
		   Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
		   this.entityClass = (Class<T>) parameterizedType[0];
		   className = entityClass.getName();
		}
		  
		     /*entityClass = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	         className = entityClass.getName(); */
	}
	
	
	
	@Resource
    public void setSessionFactoryUtil(SessionFactory sessionFactory){
            this.setSessionFactory(sessionFactory);
            hibernateTemplate=this.getHibernateTemplate();
    }
	
	@Override
	public T get(Long id) {
		return hibernateTemplate.get(entityClass, id);
	}
	
	@Override
	public T save(T t){
		return (T) hibernateTemplate.save(t);
	}
	
	
	@Override
	public void saveOrUpdate(T t) {
		
		 getHibernateTemplate().saveOrUpdate(t);
	}
	
	@Override
	public void saveOrUpdateAll(List<T> ts) {
		getHibernateTemplate().saveOrUpdateAll(ts);
	}
	
	@Override
	public void remove(T t) {
		getHibernateTemplate().delete(t);
	}
	
/*	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findRangeByFilter(BaseFilter filter,int curPage,int rowsPerPage) {
		Criteria c = getCriteria(filter);
		c.setFirstResult((curPage - 1) * rowsPerPage);
		c.setMaxResults(curPage * rowsPerPage);
		return (List<T>)c.list();
	}*/

	
	private Criteria getCriteria(BaseFilter filter) {
		Criteria c = getSession().createCriteria(entityClass);
		List<Criterion> criterionList = new ArrayList<Criterion>();
		c.setCacheable(false);
		if(filter != null ){
			if(filter.isCache() == true){
				c.setCacheable(true);
			}
			//TODO
			try {
				for(Field f : Class.forName(filter.getClass().getName()).getDeclaredFields()){
					f.setAccessible(true);//允许访问私有方法
					Object o = f.get(filter);
					Double d = 5.0;
					Double re;
					if(o != null){
						Operation op = f.getAnnotation(Operation.class);
						if(op != null ){
							if(op.association().equals("")){
								switch(op.type()){
								 	case OperationType.EQ:c.add(Restrictions.eq(op.name(), o));break;
								 	case OperationType.GREATER:c.add(Restrictions.gt(op.name(), o));break;
								 	case OperationType.GREATER_OR_EQ:c.add(Restrictions.ge(op.name(), o));break;
								 	case OperationType.LESS:c.add(Restrictions.lt(op.name(), o));break;
								 	case OperationType.LESS_OR_EQ:c.add(Restrictions.le(op.name(), o));break;
								 	case OperationType.LIKE:c.add(Restrictions.like(op.name(), "%"+o.toString()+"%", MatchMode.ANYWHERE));break;
								 	case OperationType.OR:criterionList.add(Restrictions.like(op.name(), "%"+o+"%"));break;
								 	case OperationType.Between:re = (Double)o;c.add(Restrictions.between(op.name(), Math.max(re, d)-Math.min(re, d), re+d));break;
								 	case OperationType.NE:c.add(Restrictions.ne(op.name(),o));break;
								}
							}else{
								c.createAlias(op.association(), "c_"+op.association(),CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq( "c_"+op.association()+".id" ,  o));
							}
						}
					
					}
					
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} 
		}
		int num = criterionList.size();
		if(num == 1){
			c.add(criterionList.get(0));
		}
		else if(num > 1){
			Criterion cri = criterionList.get(0);
			for(int i = 1; i < num; i++){
				cri = Restrictions.or(cri, criterionList.get(i));
			}
			c.add(cri);
		}
		return c;
	}

	@Override
	public boolean isExist(Long id) {
		return (this.get(id) != null);
	}

	@Override
	public void removeById(Long id) {
		String hql = "delete "+ className +" as o where o.id = ?";
		Query query = getSession().createQuery(hql);
		query.setLong(0, id);
		query.executeUpdate();
		getHibernateTemplate().flush();
	}
	
	
	private Field[] getAllField(Class<T> object) {
		Field[] superField = object.getSuperclass().getDeclaredFields();
		Field[] field = object.getDeclaredFields();
		Field[] all = new Field[superField.length + field.length];
		System.arraycopy(field, 0, all, 0, field.length);
		System.arraycopy(superField, 0, all, field.length, superField.length);
		return all;
	}



/*	@Override
	public Session getContextSession() {
		session = getSession();
		return session;
	}
*/

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByFilter(BaseFilter filter) {
		Criteria c = getCriteria(filter);
		if(filter != null && filter.getSort().equals("asc")){
			c.addOrder(Order.asc(filter.getOrderBy()));
		}
		else if(filter != null && filter.getSort().equals("desc")){
			c.addOrder((Order.desc(filter.getOrderBy())));
		}
		List<T> t = c.list().size() == 0 ? null : c.list();
		return t;
	}

	@Override
	public List<T> findPageByFilter(BaseFilter filter, Page page) {
		Criteria c = getCriteria(filter);

		
		
		
		//用于获取总的记录数  
		c.setFirstResult(0);
		Long size = (Long) c.setProjection(Projections.rowCount()).uniqueResult();  
		c.setProjection(null);
				
				
		page.setTotalCount(size.intValue());// 总记录数
		page.setTotalPage((int) Math.ceil(Float.valueOf(page.getTotalCount()) / page.getPageSize()));// 总页数
	
		
		c.setFirstResult((page.getCurPageNo() - 1) * page.getPageSize());
		c.setMaxResults(page.getPageSize());
	
		if(filter.getSort().equals("asc")){
			c.addOrder(Order.asc(filter.getOrderBy()));
		}else{
			c.addOrder(Order.desc(filter.getOrderBy()));
		}
		List<T> t = c.list().size() == 0 ? null : c.list();
		return t;
		//return (List<T>)c.list();
	}



	@Override
	public List<T> findLastnByFilter(BaseFilter filter,int n) {
		Criteria c = getCriteria(filter);
	
		
		//用于获取总的记录数  
		Long size = (Long) c.setProjection(Projections.rowCount()).uniqueResult();  
		c.setProjection(null);
		if(size >= n){
			c.setFirstResult(size.intValue() - n);
		}
		if(filter.getSort().equals("asc")){
			c.addOrder(Order.asc(filter.getOrderBy()));
		}else{
			c.addOrder(Order.desc(filter.getOrderBy()));
		}
		
		
		return (List<T>)c.list();
		
	}



	@Override
	public void deleteAll(List<T> ts) {
		getHibernateTemplate().deleteAll(ts);
	}



	@Override
	public Session getCurSession() {
		return getSession();
	}



	@Override
	public List<T> findNByFilter(BaseFilter filter, int n) {
		
		Criteria c = getCriteria(filter);
		
		//用于获取总的记录数  
		Long size = (Long) c.setProjection(Projections.rowCount()).uniqueResult();  
		c.setProjection(null);
		if(size >= n){
			c.setFirstResult(0);
			c.setMaxResults(n);
			
		}
		if(filter.getSort().equals("asc")){
			c.addOrder(Order.asc(filter.getOrderBy()));
		}else{
			c.addOrder(Order.desc(filter.getOrderBy()));
		}
		
		List<T> t = size == 0 ? null : c.list();
		
		return t;
	}



	/**
	 * 根据filter判断是否存在
	 */
	@Override
	public boolean isExist(BaseFilter filter) {
		boolean b = this.findByFilter(filter) == null ? false : true;
		return b;
	}




}
