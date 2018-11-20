package com.mm.bbs.inf;

import java.io.Serializable;
import java.util.List;

public interface GenericInf <T, PK extends Serializable>{
	 
	T findById(PK id);
	
	List<T> findAll();
	
	PK save(T entity);
	
	void saveOrUpdate(T entity);
	
	void deleteById(PK id);
	
	void batchDelete(List<PK> lst);
	
	void batchImport(List<T> entity);
}
