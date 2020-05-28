package com.group.basis;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.group.entity.Book;
import com.group.util.MybatisUtils;
/**
 * mybatis基础部分(查询)
 * @author Administrator
 *
 */
public class TestBaseInsert {
	private SqlSession session;

	@Before
	public void before() throws Exception {
		session = MybatisUtils.getSession();
	}

	@After
	public void after() throws Exception {
		MybatisUtils.closeSession(session);
	}

	/**
	 * 普通insert
	 */
	@Test
	public void test1() {
		//构建参数集合
		Map params= new HashMap();
		params.put("bookName", "C--");
		params.put("bookPage", 500);
		int res = session.insert("book.insert.insert1", params);
		//提交事务
		session.commit();
	}
	/**
	 * insert,自动生成id(oracle数据库索引使用)
	 */
	@Test
	public void test2() {
		//构建参数集合
		Map params= new HashMap();
		params.put("bookName", "delphi");
		params.put("bookPage", 500);
		int res = session.insert("book.insert.insert2", params);
		//提交事务
		session.commit();
	}
}
