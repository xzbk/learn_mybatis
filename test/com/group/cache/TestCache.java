package com.group.cache;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.group.util.MybatisUtils;
/**
 * 测试缓存
 * @author Administrator
 *
 */
public class TestCache {

	private SqlSession session;

	@Before
	public void before(){
		session = MybatisUtils.getSession();
	}
	/**
	 * 测试一级缓存
	 */
	@Test
	public void testLevelOne() {
		//两次查询，之出现条查询语句
		/*List<Map> books = session.selectList("com.group.dao.IBookDao.allMap");
		List<Map> books1 = session.selectList("com.group.dao.IBookDao.allMap");*/
		//一级换存级别为session内部，不能够跨session的,所以会出现两条查询语句
		List<Map> books3 = session.selectList("com.group.dao.IBookDao.allMap");
		SqlSession session2 = MybatisUtils.getSession();
		List<Map> books4 = session2.selectList("com.group.dao.IBookDao.allMap");
	}
	/**
	 * 测试二级缓存,只有commit提交数据库，确定修改了数据库后二级换存才会真正进行缓存
	 */
	@Test
	public void testLevelTwo() {
		List<Map> books3 = session.selectList("com.group.dao.IBookDao.allMap");
		session.commit();//为了让集合进入二级缓存
		SqlSession session2 = MybatisUtils.getSession();
		List<Map> books4 = session2.selectList("com.group.dao.IBookDao.allMap");
	}
	@After
	public void after() {
		MybatisUtils.closeSession(session);
	}

}
