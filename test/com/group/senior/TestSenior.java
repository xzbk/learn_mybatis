package com.group.senior;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.group.entity.Book;
import com.group.util.MybatisUtils;
/**
 * mybatis高级部分
 * @author Administrator
 *
 */
public class TestSenior {
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
	 * selectOne
	 */
	@Test
	public void testSelectOne() {
		Map book = session.selectOne("book.senior.oneBook",1);
		System.out.println(book.get("book_name"));
	}
	/**
	 * selectIn
	 */
	@Test
	public void testSelectIn() {
		//构建参数集合
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(1);
		lst.add(2);
		lst.add(3);
		lst.add(4);
		List<Map> books = session.selectList("book.senior.in",lst);
		for (Map map : books) {
			System.out.println(map.get("book_name"));
		}
		//提交事务
		session.commit();
	}
	/**
	 * 分页查询,查询第一页，每页2条，下标从0开始，一共2条
	 */
	@Test
	public void testPage() {
		//创建一个分页对象
		RowBounds rb = new RowBounds(0,2);
		List<Book> books = session.selectList("book.senior.findBooks",null,rb);
		for (Book book : books) {
			System.out.println(book.getBookName());
		}
	}
	/**
	 * 关联查询
	 */
	@Test
	public void testFindBookByTypeId() {
		List<Map> books = session.selectList("book.senior.findBookByTypeId");
		for (Map map : books) {
			System.out.println(map.get("book_name"));
		}
	}
}
