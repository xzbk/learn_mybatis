package com.group.dao;

import java.util.List;
import java.util.Map;

import com.group.entity.Book;

/**
 * 关于book的增删改查
 * @author Administrator
 *
 */
public interface IBookDao {
	//查询所有的书籍
	List<Map> allMap();
	//增加一本书
	int insert(Map book);
}
