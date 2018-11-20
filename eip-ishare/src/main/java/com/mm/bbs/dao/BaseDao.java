package com.mm.bbs.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


public interface BaseDao<T, PK extends Serializable>  {
	
	/**
	 * 是否存在指定条件数据。
	 * @param entityClass 映射类
	 * @param whereClause 条件
	 * @param values 条件值
	 * @return true:存在，false:不存在
	 */
	public boolean isExist(Class<?> entityClass,String whereClause, Map<String, Object> params );
	
	/**
	 * 执行update,delete,insert语句。
	 * @param hql
	 * 
	 * @return 执行影响的数量
	 */
	public int execute(final String hql, final Map<String, Object> params);
	
	/**
	 * 持久化
	 * @param entity
	 */
	public void save(Object entity);
 
	/**
	 * 更新
	 * @param entity
	 */
	public void update(Object entity);
 
	/**
	 * 保存或更新。
	 * @param entity
	 */
	public void saveOrUpdate(Object entity);
	
	/**
	 * 删除操作。
	 * @param entity
	 */
	public void delete(Object entity);
	
	/**
	 * 按照属性(id)条件查找数据。
	 * @param clasz 待查找的实体类
	 * @param id    根据条件id的值匹配实体类的id
	 * @return E 查找到的实体
	 */
	public <E> E getById(Class<E> clasz, Serializable id);
 
	/**
	 * 查找某实体类的第一条记录。
	 * @param clasz 待查找的实体类
	 * @return E 查找到的实体
	 */
	public <E> E findFirst(Class<?> clasz);
 
	/**
	 * 查找某实体类的第一条记录。
	 * @param clasz 待查找的实体类
	 * @param includes  条件参数
	 * @return E 查找到的实体
	 */
	public <E> E findFirst(Class<?> clasz, String[] includes);
     
	/**
	 * 根据条件查找某实体类的第一条记录。
	 * @param clasz 待查找的实体类
	 * @param conditions 条件
	 * @return  E 查找到的实体
	 */
	public <E> E findFirst(Class<?> clasz, String conditions);
  
	/**
	 * 查找某实体类的第一条记录。 
	 * @param clasz 待查找的实体类
     * @param conditions    条件
     * @param includes   需要关联取出的外键对象
	 * @return E 查找到的实体
	 */
	public <E> E findFirst(Class<?> clasz, String conditions, String[] includes);
     
	/**
	 * 查找某实体类的第一条记录。   
	 * @param clasz 待查找的实体类
     * @param conditions     条件
     * @param args    条件参数
	 * @return E 查找到的实体
	 */
	public <E> E findFirst(Class<?> clasz, String conditions, Map<String, Object> params);
 
	/**
	 * 查找某实体类的第一条记录。  
	 * @param clasz 待查找的实体类
     * @param conditions    条件
     * @param args    参数条件
     * @param includes   需要关联取出的外键对象
	 * @return E 查找到的实体
	 */
	public <E> E findFirst(Class<?> clasz, String conditions, Map<String, Object> params,
			String[] includes);
    
	/**
	 * 查找某实体类的第一条记录。 
	 * @param clasz 待查找的实体类
     * @param conditions   条件
     * @param args   参数
     * @param order  排序条件（如"id desc,code"）
	 * @return E 查找到的实体
	 */
	public <E> E findFirst(Class<?> clasz, String conditions, Map<String, Object> params, String order);
    
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
			String order, String[] includes);
  
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
			String order, int start, String[] includes) ;
	/**
	 * 查找全部实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @return E 查找到的实体（List集合）
	 */
	public <E> List<E> findAll(Class<E> clasz) ;
	/**
	 * 根据条件查找全部符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 * @param includes     需要关联取出的外键对象
	 *  @return E 查找到的实体（List集合）
	 */
	public <E> List<E> findAll(Class<E> clasz, String[] includes) ;
	/**
	 * 根据条件查找符合条件全部实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param conditions    条件
	 *  @return E 查找到的实体（List集合）
	 */
	public <E> List<E> findAll(Class<E> clasz, String conditions);
	/**
	 * 根据条件查找符合条件全部实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param conditions     条件
	 *  @param includes    需要关联取出的外键对象）
	 *  @return E 查找到的实体（List集合）
	 */
	public <E> List<E> findAll(Class<E> clasz, String conditions,
			String[] includes) ;
 
	/**
	 * 根据条件查找全部符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param conditions    条件
	 *  @param args             参数
	 *  @return E 查找到的实体（List集合）
	 */
	public <E> List<E> findAll(Class<E> clasz, String conditions, Map<String, Object> params) ;
 
	/**
	 * 根据条件查找全部符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param conditions   条件
	 *  @param args            参数
	 *  @param includes     需要关联取出的外键对象
	 *  @return E 查找到的实体（List集合）
	 */
	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Map<String, Object> params, String[] includes);
 
	/**
	 * 根据条件查找全部符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param conditions   条件
	 *  @param args            参数
	 *  @param order           排序条件（如"id desc,code"）
	 *  @return E                  查找到的实体
	 */
	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Map<String, Object> params, String order) ;
 
	/**
	 * 根据条件查找全部符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param conditions 条件
	 *  @param args          参数
	 *  @param order        排序条件（如"id desc,code"）
	 *  @param includes    需要关联取出的外键对象）
	 *  @return E                查找到的实体
	 */
	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Map<String, Object> params, String order, String[] includes) ;
	/**
	 * 根据条件查找全部符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param conditions    条件
	 *  @param args             参数
	 *  @param order            排序条件（如"id desc,code"）
	 *  @param limit             分页每页显示条数
	 *  @return E                   查找到的实体
	 */
	public <E> List<E> findAll(Class<E> clasz, String conditions,
			Map<String, Object> params, String order, int limit);
 
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
			Map<String, Object> params, String order, int limit, String[] includes);
 
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
	public <E> List<E> findAll(final Class<E> clasz, final String conditions, final Map<String, Object> params, final String order, final int start, final int limit, final String[] includes);
 
	/**
	 * 根据条件查找第一个符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param hql  hql语句
	 *  @param args    参数
	 *  @return E 查找到的实体（List集合）
	 */
	public <E> E findFirstByHQL(Class<E> clasz, final String hql, final Map<String, Object> params) ;
 
	/**
	 * HQL查询根据条件查找符合条件实体类信息。  
	 * @param clasz 待查找的实体类
	 *  @param hql  hql语句（必须完整写出 from Class）
	 *  @param args    hql 条件（Object数组）
	 *  @return E 查找到的实体（List集合）
	 */
	public  <E> List<E> findByHQL(Class<E> clasz, final String hql, final Map<String, Object> params) ;
 
	/**
	 * 标量
	 * HQL查询根据条件查找符合条件第一个标量值。  
	 *  @param hql  hql语句
	 *  @param args   参数
	 *  @return Integer  标量值
	 */
	public Integer findInt(String hql, Map<String, Object> params);
 
	/**
	 * 标量
	 * HQL查询根据条件查找符合条件第一个标量值。  
	 *  @param hql  hql语句
	 *  @param args   参数
	 *  @return Long  标量值
	 */
	public Long findLong(String hql, Map<String, Object> params);
 
	/**
	 * 标量
	 * 根据条件查找符合条件第一个标量值。  
	 *  @param hql  hql语句
	 *  @param args    参数
	 *  @return Double 标量值
	 */
	public Double findDouble(String hql, Map<String, Object> params) ;
 
	/**
	 * 标量
	 * HQL查询根据条件查找符合条件第一个标量值。  
	 *  @param hql  hql语句
	 *  @param args   参数
	 *  @return BigDecimal 标量值
	 */
	public BigDecimal findBigDecimal(String hql, Map<String, Object> params);
	/**
	 * 标量
	 * HQL查询根据条件查找符合条件第一个标量值。  
	 *  @param hql  hql语句
	 *  @param args   参数
	 *  @return String 标量值
	 */
	public String findString(String hql, Map<String, Object> params);
 
 
	/**
	 * 分页条件查询 
	 *  @param DetachedCriteria  dc   条件
	 *  @param start    分页开始显示数
	 *  @param limit      分页每页显示条数
	 *  @return Page   分页对象
	 *//*
	public  <E> Page<E> findPage(final DetachedCriteria dc, final int start,
			final int limit) ;
 
	public <T> Page<T> findPageByHQL(Class<T> clasz, final String hql, final Map<String, Object> params,
			final int start, final int limit) ;
	
	
	*//**
	 * 根据hql语句查找实体信息
	 *  @param sql    createSQLQuery条件（hql语句)
	 *  @param args     参数
     *  @param start    分页开始显示数
	 *  @param limit      分页每页显示条数
	 *  @return  page   分页对象
	 *//*
	public <T> Page<T> findPageBySQL(final Class<T> clasz,final String sql, final Map<String, Object> params,final int start, final int limit) ;
	
	/**
	 * 根据hql语句查找实体信息
	 *  @param sql    createSQLQuery条件（hql语句)
	 *  @param args    参数
	 *  @param count_sql
     *  @param start    分页开始显示数
	 *  @param limit      分页每页显示条数
	 *  @return  page  分页对象
	 */
//	public <T> Page<T> findPageBySQL(final Class<T> clasz,final String sql,String count_sql, final Map<String, Object> params,final int start, final int limit) ;
	 
	/**
	 * 根据hql语句查找实体信息
	 *  @param sql    createSQLQuery条件（hql语句)
	 *  @param args    条件参数
	 *  @return List 集合
	 */
	public List<?> findListBySQL(final String sql,final Map<String, Object> params);
	
	
	/**
	 * 根据hql语句查找第一个实体信息
	 *  @param sql    createSQLQuery条件（hql语句)
	 *  @param args    条件 参数
	 *  @return Object
	 */
	public Object findFirstBySQL(final String sql, final Map<String, Object> params);
	
	
	/**
	 * SQL查询并将结果集自动转换成POJO的list
	 * @param clazz 最终转换成的类
	 * @param sql 查询条件
	 * @return
	 */
	public <T> List<T> findObjListBySql(final Class<T> clazz,final String sql);
	
	
	/**
	 * SQL查询并将结果集自动转换成POJO的list
	 * @param clazz 最终转换成的类
	 * @param sql 查询条件
	 * @return
	 */
	public <T> List<T> findObjListBySql(final Class<T> clazz,final String sql,final Integer start,final Integer limit);
}