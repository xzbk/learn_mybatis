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
 * mybatis基础部分(删除)
 * @author Administrator
 *
 */
public class TestBaseDelete {
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
	 * 普通删除
	 */
	@Test
	public void test1() {
		int res = session.delete("book.delete.delete1", 5);
		//提交事务
		session.commit();
	}
}
