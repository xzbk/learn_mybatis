package com.group.basis;

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
public class TestBaseQuery {
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
	 * 返回值使用的是resultMap
	 */
	@Test
	public void test1() {
		List<Book> books = session.selectList("book.query.findBooks");
		for (Book book : books) {
			System.out.println(book.getBookName());
		}
	}
	/**
	 * 返回值使用的是map
	 */
	@Test
	public void test2() {
		List<Map> books = session.selectList("book.query.allMap");
		for (Map map : books) {
			System.out.println(map.get("book_name")+"---"+map.get("book_page"));
		}
	}
	/**
	 * 带一个条件的查询
	 */
	@Test
	public void test3() {
		List<Map> books = session.selectList("book.query.condition1",1);
		for (Map map : books) {
			System.out.println(map.get("book_name")+"---"+map.get("book_page"));
		}
	}
	/**
	 * 带多个条件的查询
	 */
	@Test
	public void test4() {
		//构建参数集合
		Map params= new HashMap();
		params.put("bookName", "%ink%");
		params.put("bookPage", 500);
		List<Map> books = session.selectList("book.query.condition2",params);
		for (Map map : books) {
			System.out.println(map.get("book_name")+"---"+map.get("book_page"));
		}
	}
	/**
	 * 带多个条件的查询,动态sql，使用if
	 */
	@Test
	public void test5() {
		//构建参数集合
		Map params= new HashMap();
		params.put("bookName", "%ink%");
		params.put("bookPage", 500);
		List<Map> books = session.selectList("book.query.condition3",params);
		for (Map map : books) {
			System.out.println(map.get("book_name")+"---"+map.get("book_page"));
		}
	}
	/**
	 * 带多个条件的查询,动态sql，使用trim
	 */
	@Test
	public void test6() {
		//构建参数集合
		Map params= new HashMap();
		params.put("bookName", "%ink%");
		params.put("bookPage", 500);
		List<Map> books = session.selectList("book.query.condition4",params);
		for (Map map : books) {
			System.out.println(map.get("book_name")+"---"+map.get("book_page"));
		}
	}
}
