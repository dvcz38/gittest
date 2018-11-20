package com.mm.bbs.dao.impl;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.mm.bbs.dao.BaseDao;
 
 
@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T, PK extends Serializable>  implements BaseDao<T, PK>{
 
	private static final Logger log = Logger.getLogger(BaseDaoImpl.class);
	 
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 获得当前事物的session
	 * 
	 * @return org.hibernate.Session
	 */
	
	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
 
	
	/**
	 * 是否存在指定条件数据。
	 * @param entityClass 映射类
	 * @param whereClause 条件
	 * @param values 条件值
	 * @return true:存在，false:不存在
	 */
	public boolean isExist(Class<?> entityClass,String whereClause, Map<String, Object> params ) {
		String selectHql = "select count(id) from "+ entityClass.getName() + "  where " + whereClause;
		return findLong(selectHql, params) > 0;
	}
	
	
	/**
	 * 执行update,delete,insert语句。
	 * @param hql
	 * 
	 * @return 执行影响的数量
	 */
	public int execute(final String hql, final Map<String, Object> params) {		
		Query query = this.getCurrentSession().createQuery(hql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return query.executeUpdate();
	}
	
 
	@Override
	public void delete(Object entity) {
		this.getCurrentSession().delete(entity);		
	}
	
	/**
	 * 持久化
	 * @param entity
	 */
	public void save(Object entity) {
		this.getCurrentSession().save(entity);
	}
 
	/**
	 * 更新
	 * @param entity
	 */
	public void update(Object entity) {
		this.getCurrentSession().update(entity);
	}
 
	/**
	 * 保存或更新。
	 * @param entity
	 */
	public void saveOrUpdate(Object entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
    
	/**
	 * 按照属性(id)条件查找数据。
	 * @param clasz 待查找的实体类
	 * @param id    根据条件id的值匹配实体类的id
	 * @return E 查找到的实体
	 */
	public <E> E getById(Class<E> clasz, Serializable id) {
		return (E) this.getCurrentSession().get(clasz, id);
	}
 
	/**
	 * 查找某实体类的第一条记录。
	 * @param clasz 待查找的实体类
	 * @return E 查找到的实体
	 */
	public <E> E findFirst(Class<?> clasz) {
		return findFirst(clasz, null, null, null, 0, null);
	}
 
	/**
	 * 查找某实体类的第一条记录。
	 * @param clasz 待查找的实体类
	 * @param includes  条件参数
	 * @return E 查找到的实体
	 */
	public <E> E findFirst(Class<?> clasz, String[] includes) {
		return findFirst(clasz, null, null, null, 0, includes);
	}
     
	/**
	 * 根据条件查找某实体类的第一条记录。
	 * @param clasz 待查找的实体类
	 * @param conditions 条件
	 * @return  E 查找到的实体
	 */
	public <E> E findFirst(Class<?> clasz, String conditions) {
		return findFirst(clasz, conditions, null, null, 0, null);
	}
  
	/**
	 * 查找某实体类的第一条记录。 
	 * @param clasz 待查找的实体类
     * @param conditions    条件
     * @param includes   需要关联取出的外键对象
	 * @return E 查找到的实体
	 */
	public <E> E findFirst(Class<?> clasz, String conditions, String[] includes) {
		return findFirst(clasz, conditions, null, null, 0, includes);
	}
     
	/**
	 * 查找某实体类的第一条记录。   
	 * @param clasz 待查找的实体类
     * @param conditions     条件
     * @param args    条件参数
	 * @return E 查找到的实体
	 */
	public <E> E findFirst(Class<?> clasz, String conditions, Map<String, Object> params) {
		return findFirst(clasz, conditions, params, null, 0, null);
	}
 
	/**
	 * 查找某实体类的第一条记录。  
	 * @param clasz 待查找的实体类
     * @param conditions    条件
     * @param args    参数条件
     * @param includes   需要关联取出的外键对象
	 * @return E 查找到的实体
	 */
	public <E> E findFirst(Class<?> clasz, String conditions, Map<String, Object> params,
			String[] includes) {
		return findFirst(clasz, conditions, params, null, 0, includes);
	}
    
	/**
	 * 查找某实体类的第一条记录。 
	 * @param clasz 待查找的实体类
     * @param conditions   条件
     * @param args   参数
     * @param order  排序条件（如"id desc,code"）
	 * @return E 查找到的实体
	 */
	public <E> E findFirst(Class<?> clasz, String conditions, Map<String, Object> params,
			String order) {
		return findFirst(clasz, conditions, params, order, 0, null);
	}
    
	/**
	 *  查找某实体类的第一条记录。 
	 * @param clasz 待查找的实体类
     * @param conditions   条件
     * @param includes   需要关联取出的外键对象
     * @param args    参数
     * @param order  排序条件
	 * @return E 查找到的实体
	 */
	public <E> E findFirst(Class<?> clasz, String conditions, Map<String, Object> params,
			String order, String[] includes) {
		return findFirst(clasz, conditions, params, order, 0, includes);
	}
  
	/**
	 * 查找某实体类的第一条记录。 
	 * @param clasz 待查找的实体类
     * @param conditions    条件
     * @param includes    需要关联取出的外键对象
     * @param args    参数
     * @param order  排序条件（如"id desc,code"）
     * @param start  分页开始条数
     * @param limit  分页每页显示条数
	 * @return E 查找到的实体
	 */
	public <E> E findFirst(Class<?> clasz, String conditions, Map<String, Object> params,
			String order, int start, String[] includes) {
		List<E> results = (List<E>) findAll(clasz, conditions, params, order, start, 1,includes);
		return results.size() == 0 ? null : results.get(0);
	}
    
	/**
	 * 查找全部实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @return E 查找到的实体（List集合）
	 */
	public <E> List<E> findAll(Class<E> clasz) {
		return findAll(clasz, null, null, null, 0, 0, null);
	}
   
	/**
	 * 根据条件查找全部符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 * @param includes     需要关联取出的外键对象
	 *  @return E 查找到的实体（List集合）
	 */
	public <E> List<E> findAll(Class<E> clasz, String[] includes) {
		return findAll(clasz, null, null, null, 0, 0, includes);
	}
   
	/**
	 * 根据条件查找符合条件全部实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param conditions    条件
	 *  @return E 查找到的实体（List集合）
	 */
	public <E> List<E> findAll(Class<E> clasz, String conditions) {
		return findAll(clasz, conditions, null, null, 0, 0, null);
	}
	
	/**
	 * 根据条件查找符合条件全部实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param conditions     条件
	 *  @param includes    需要关联取出的外键对象）
	 *  @return E 查找到的实体（List集合）
	 */
	public <E> List<E> findAll(Class<E> clasz, String conditions,
			String[] includes) {
		return findAll(clasz, conditions, null, null, 0, 0, includes);
	}
 
	/**
	 * 根据条件查找全部符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param conditions    条件
	 *  @param args             参数
	 *  @return E 查找到的实体（List集合）
	 */
	public <E> List<E> findAll(Class<E> clasz, String conditions, Map<String, Object> params) {
		return findAll(clasz, conditions, params, null, 0, 0, null);
	}
 
	/**
	 * 根据条件查找全部符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param conditions   条件
	 *  @param args            参数
	 *  @param includes     需要关联取出的外键对象
	 *  @return E 查找到的实体（List集合）
	 */
	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Map<String, Object> params, String[] includes) {
		return findAll(clasz, conditions, params, null, 0, 0, includes);
	}
 
	/**
	 * 根据条件查找全部符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param conditions   条件
	 *  @param args            参数
	 *  @param order           排序条件（如"id desc,code"）
	 *  @return E                  查找到的实体
	 */
	public <E> List<E> findAll(Class<E> clasz, String conditions, Map<String, Object> params, String order) {
		return findAll(clasz, conditions, params, order, 0, 0, null);
	}
 
	/**
	 * 根据条件查找全部符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param conditions 条件
	 *  @param args          参数
	 *  @param order        排序条件（如"id desc,code"）
	 *  @param includes    需要关联取出的外键对象）
	 *  @return E                查找到的实体
	 */
	public <E> List<E> findAll(Class<E> clasz, String conditions, Map<String, Object> params, String order, String[] includes) {
		return findAll(clasz, conditions, params, order, 0, 0, includes);
	}
 
	/**
	 * 根据条件查找全部符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param conditions    条件
	 *  @param args             参数
	 *  @param order            排序条件（如"id desc,code"）
	 *  @param limit             分页每页显示条数
	 *  @return E                   查找到的实体
	 */
	public <E> List<E> findAll(Class<E> clasz, String conditions, Map<String, Object> params, String order, int limit) {
		return findAll(clasz, conditions, params, order, limit, 0, null);
	}
 
	/**
	 * 根据条件查找全部符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param conditions    条件
	 *  @param args             参数
	 *  @param order         排序条件 （如"id desc,code"）
	 *  @param limit            分页每页显示条数
	 *  @param includes   需要关联取出的外键对象
	 *  @return E 查找到的实体（List集合）
	 */
	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Map<String, Object> params, String order, int limit, String[] includes) {
		return findAll(clasz, conditions, params, order, 0, limit, includes);
	}
 
	/**
	 * 根据条件查找全部符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param conditions  条件
	 *  @param args         参数
	 *  @param order       排序条件（如"id desc,code"）
	 *  @param   start      分页开始条数
	 *  @param limit         分页每页显示条数
	 *   @param includes    需要关联取出的外键对象
	 *  @return E 查找到的实体
	 */
	public <E> List<E> findAll(final Class<E> clasz, final String conditions, final Map<String, Object> params, final String order, final int start, final int limit, final String[] includes) {		
		String hql = "from " + clasz.getName() + " as e";
		if (includes != null && includes.length > 0) {
			for (String je : includes) {
				hql += " left outer join  fetch e." + je + " as " + (je.replaceAll("\\.", "")) + " ";
			}
		}
		if (StringUtils.isNotEmpty(conditions)) {
//			hql += " where (" + DaoHelper.insertAlias(conditions, clasz) + ")";
		}
		if (StringUtils.isNotEmpty(order))
			hql += " order by e." + order;
		
		Query query = this.getCurrentSession().createQuery(hql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return query.setFirstResult(start).setMaxResults((limit == 0 ? Integer.MAX_VALUE : limit)).list();
	}
 
	/**
	 * 根据条件查找第一个符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param hql  hql语句
	 *  @param args    参数
	 *  @return E 查找到的实体（List集合）
	 */
	public <E> E findFirstByHQL(Class<E> clasz, final String hql, final Map<String, Object> params) {				
		Query query = this.getCurrentSession().createQuery(hql);		
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		List<?> list = query.setFirstResult(0).setMaxResults(1).list();
		return (list != null && list.size() > 0 )? (E)list.get(0) : null;
	}
 
	/**
	 * HQL查询根据条件查找符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param hql  hql语句（必须完整写出 from Class）
	 *  @param args    hql 条件（Object数组）
	 *  @return E 查找到的实体（List集合）
	 */
	public  <E> List<E> findByHQL(Class<E> clasz, final String hql, final Map<String, Object> params) {
		Query query = this.getCurrentSession().createQuery(hql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return query.list();
	}
 
	/**
	 * 标量
	 * HQL查询根据条件查找符合条件第一个标量值。  
	 *  @param hql  hql语句
	 *  @param args   参数
	 *  @return Integer  标量值
	 */
	public Integer findInt(String hql, Map<String, Object> params) {
		Integer intValue = findFirstByHQL(Integer.class, hql, params);
		return intValue == null ? 0 : intValue;
	}
 
	/**
	 * 标量
	 * HQL查询根据条件查找符合条件第一个标量值。  
	 *  @param hql  hql语句
	 *  @param args   参数
	 *  @return Long  标量值
	 */
	public Long findLong(String hql, Map<String, Object> params) {
		Long longValue = findFirstByHQL(Long.class, hql, params);
		return longValue == null ? 0L : longValue;
	}
 
	/**
	 * 标量
	 * 根据条件查找符合条件第一个标量值。  
	 *  @param hql  hql语句
	 *  @param args    参数
	 *  @return Double 标量值
	 */
	public Double findDouble(String hql, Map<String, Object> params) {
		Double doubleValue = findFirstByHQL(Double.class, hql, params);
		return doubleValue == null ? 0.00 : doubleValue;
	}
 
	/**
	 * 标量
	 * HQL查询根据条件查找符合条件第一个标量值。  
	 *  @param hql  hql语句
	 *  @param args   参数
	 *  @return BigDecimal 标量值
	 */
	public BigDecimal findBigDecimal(String hql, Map<String, Object> params) {
		BigDecimal bigDecimalValue = findFirstByHQL(BigDecimal.class, hql, params);
		return bigDecimalValue == null ? new BigDecimal(0) : bigDecimalValue;
	}
 
	/**
	 * 标量
	 * HQL查询根据条件查找符合条件第一个标量值。  
	 *  @param hql  hql语句
	 *  @param args   参数
	 *  @return String 标量值
	 */
	public String findString(String hql, Map<String, Object> params) {
		String stringValue = findFirstByHQL(String.class, hql, params);
		return stringValue;
	}
 
 
	/**
	 * 分页条件查询 
	 *  @param DetachedCriteria  dc   条件
	 *  @param start    分页开始显示数
	 *  @param limit      分页每页显示条数
	 *  @return Page   分页对象
	 */
//	public  <E> Page<E> findPage(final DetachedCriteria dc, final int start, final int limit) {
//		
//		Criteria c = dc.getExecutableCriteria(this.getCurrentSession());
//		CriteriaImpl impl = (CriteriaImpl) c;
//		Projection projection = impl.getProjection();
//		ResultTransformer transformer = impl.getResultTransformer();
// 
//		
//		List<CriteriaImpl.OrderEntry> orderEntries = (List<CriteriaImpl.OrderEntry>) ReflectionUtils.getFieldValue(impl, "orderEntries");
//		ReflectionUtils.setFieldValue(impl, "orderEntries", new ArrayList<CriteriaImpl.OrderEntry>());
//		
//		
//		// 执行Count查询
//		c.setResultTransformer(CriteriaImpl.DISTINCT_ROOT_ENTITY);
//		long total = (Long) c.setProjection(Projections.countDistinct("id")).uniqueResult();
//	
//		// 将之前的Projection和OrderBy条件重新设回去
//		c.setProjection(projection);
//		c.setResultTransformer(transformer);
//		ReflectionUtils.setFieldValue(impl, "orderEntries", orderEntries);
//		
// 
//		c.setFirstResult(start);
//		c.setMaxResults(limit);
// 
//		List<E> list = c.list();
//		return  new Page<E>(start, limit, Integer.parseInt(String.valueOf(total)),(list == null ? new ArrayList() : list));
//	}
//	
//	public <T> Page<T> findPageByHQL(Class<T> clasz, final String hql, final Map<String, Object> params, final int start, final int limit) {
//		String countQueryString = "select count (*) " + DaoHelper.removeSelect(DaoHelper.removeOrders(hql));
//		
//		Long count = params ==null ? findLong(countQueryString, null):findLong(countQueryString, params);
//		
//		Query query = this.getCurrentSession().createQuery(hql);
//		// 参数组装
//		if ((params != null) && !params.isEmpty()) {
//			for (String key : params.keySet()) {
//				query.setParameter(key, params.get(key));
//			}
//		}
//		List<?> list =  query.setFirstResult(start).setMaxResults(limit).list();
//		
//		return new Page(start, limit,count.intValue(),list);
//	}
//	
//	
//	/**
//	 * 根据hql语句查找实体信息
//	 *  @param sql    createSQLQuery条件（hql语句)
//	 *  @param args     参数
//     *  @param start    分页开始显示数
//	 *  @param limit      分页每页显示条数
//	 *  @return  page   分页对象
//	 */
//	public <T> Page<T> findPageBySQL(final Class<T> clasz,final String sql, final Map<String, Object> params,final int start, final int limit) {		
//		Query query =  this.getCurrentSession().createSQLQuery(sql);
//		// 参数组装
//		if ((params != null) && !params.isEmpty()) {
//			for (String key : params.keySet()) {
//				query.setParameter(key, params.get(key));
//			}
//		}
//		// 结果转换
//		query.setResultTransformer(new CustomResultTransformer(clasz));
//		
//		List<?> list = query.setFirstResult(start).setMaxResults(limit).list();
//		
//		String countQueryString = "select count (*) " + DaoHelper.removeSelect(DaoHelper.removeOrders(sql));
//		Object o = findFirstBySQL(countQueryString,params);
//		
//		Long count = 0L;
//		if(o!=null&&o instanceof BigDecimal){
//			count = ((BigDecimal)o).longValue();
//		}else if(o!=null){
//			count= Long.valueOf(String.valueOf(o));
//		}
//		else{
//			count = 0L;
//		}
//		return new Page(start, limit,count.intValue(),list);
//	}
//	
//	/**
//	 * 根据hql语句查找实体信息
//	 *  @param sql    createSQLQuery条件（hql语句)
//	 *  @param args    参数
//	 *  @param count_sql
//     *  @param start    分页开始显示数
//	 *  @param limit      分页每页显示条数
//	 *  @return  page  分页对象
//	 */
//	public <T> Page<T> findPageBySQL(final Class<T> clasz,final String sql,String count_sql, final Map<String, Object> params,final int start, final int limit) {
//		Query query =  this.getCurrentSession().createSQLQuery(sql);
//		// 参数组装
//		if ((params != null) && !params.isEmpty()) {
//			for (String key : params.keySet()) {
//				query.setParameter(key, params.get(key));
//			}
//		}
//		// 结果转换
//		query.setResultTransformer(new CustomResultTransformer(clasz));
//		
//		List<T> list = query.setFirstResult(start).setMaxResults(limit).list();	
//		
//		Long count = (Long)findFirstBySQL(count_sql, params);		
//	
//		return new Page(start, limit,count.intValue(),list);
//	}
	
	/**
	 * 根据hql语句查找实体信息
	 *  @param sql    createSQLQuery条件（hql语句)
	 *  @param args    条件参数
	 *  @return List 集合
	 */
	public List<?> findListBySQL(final String sql,final Map<String, Object> params) {
		Query query =  this.getCurrentSession().createSQLQuery(sql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return  query.list();
	}	
	
	/**
	 * 根据hql语句查找第一个实体信息
	 *  @param sql    createSQLQuery条件（hql语句)
	 *  @param args    条件 参数
	 *  @return Object
	 */
	public Object findFirstBySQL(final String sql, final Map<String, Object> params) {
		 
		Query query = this.getCurrentSession().createSQLQuery(sql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		List<?> list =  query.setFirstResult(0).setMaxResults(1).list();
		
		return (list != null && list.size() > 0 ? list.get(0) : null);
	}
	
	
	/**
	 * SQL查询并将结果集自动转换成POJO的list
	 * @param clazz 最终转换成的类
	 * @param sql 查询条件
	 * @return
	 */
	public <T> List<T> findObjListBySql(final Class<T> clazz,final String sql){
		Query query = this.getCurrentSession().createSQLQuery(sql);
//		query.setResultTransformer(new CustomResultTransformer(clazz));
		return  query.list();
	}
		
	/**
	 * SQL查询并将结果集自动转换成POJO的list
	 * @param clazz 最终转换成的类
	 * @param sql 查询条件	
	 * @return
	 */
	public <T> List<T> findObjListBySql(final Class<T> clazz,final String sql,final Integer start,final Integer limit){
		Query query =  this.getCurrentSession().createSQLQuery(sql).setFirstResult(start==null?0:start).setMaxResults(limit==null?10:limit);
//		query.setResultTransformer(new CustomResultTransformer(clazz));
		return query.list();
	}
}
