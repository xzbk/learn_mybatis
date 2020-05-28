package com.group.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.group.dao.IBookDao;
import com.group.util.MybatisUtils;
/**
 * dao接口方式映射sql
 * @author Administrator
 *
 */
public class TestDao {
	
	private SqlSession session;

	@Before
	public void before(){
		session = MybatisUtils.getSession();
	}
	/**
	 * 查询
	 */
	@Test
	public void testFindBooks() {
		//创建一个具体的dao对象(动态代理机制)
		IBookDao dao = session.getMapper(IBookDao.class);
		List<Map> books = dao.allMap();
		for (Map map : books) {
			System.out.println(map.get("book_name"));
		}
	}
	/**
	 * 插入
	 */
	@Test
	public void testInsert() {
		//创建一个具体的dao对象(动态代理机制)
		IBookDao dao = session.getMapper(IBookDao.class);
		Map book = new HashMap();
		book.put("bookName", "test");
		book.put("bookPage", 200);
		int res = dao.insert(book);
		//提交事务
		session.commit();
	}
	
	@After
	public void after() {
		MybatisUtils.closeSession(session);
	}

}
