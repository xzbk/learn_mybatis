package com.group.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * mybatis的session工具类
 * @author Administrator
 *
 */
public class MybatisUtils {
	private static SqlSessionFactory sf;
	
	static {
		//读取配置文件到输入流
		InputStream in = MybatisUtils.class.getResourceAsStream("/mybatis-config.xml");
		//构建sqlsession工厂
		sf = new SqlSessionFactoryBuilder().build(in);
	}
	/**
	 * 获取session
	 * @return
	 */
	public static SqlSession getSession() {
		return sf.openSession();
	}
	/**
	 * 关闭session
	 * @param session
	 */
	public static void closeSession(SqlSession session) {
		if(session != null) {
			session.close();
		}
	}
}
