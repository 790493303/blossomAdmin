/**
 * Copyright &copy; 2015-2015  Jeedcp All rights reserved.
 */
package com.blossom.site.common.persistence.sql.dao;

import com.blossom.site.common.persistence.sql.dao.BaseDao;

import java.util.List;

/**
 * @description DAO支持类实现
 * @author Blossom
 * @DateTime 2017/3/23 16:25
 */
public interface TreeDao<T> extends BaseDao {

	/**
	 * 找到所有子节点
	 * @param entity
	 * @return
	 */
	List<T> findByParentIdsLike(T entity);

	/**
	 * 更新所有父节点字段
	 * @param entity
	 * @return
	 */
	int updateParentIds(T entity);
	
}