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
 * mybatis基础部分(更新)
 * @author Administrator
 *
 */
public class TestBaseUpdate {
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
	 * 普通update
	 */
	@Test
	public void test1() {
		//构建参数集合
		Map params= new HashMap();
		params.put("id", 1);
		params.put("bookName", "Java编程思想");
		params.put("bookPage", 1000);
		int res = session.update("book.update.update1", params);
		//提交事务
		session.commit();
	}
}
