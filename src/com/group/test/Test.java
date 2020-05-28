package com.group.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.group.entity.Book;

public class Test {

	public static void main(String[] args) {
		/**
		 * 1.读取mybatis总的配置文件，将配置文件读取到输入流
		 * getResourceAsStream方法里面的参数表示classpath下面的文件
		 * 如果以斜杠开头，表示从classpath的根路径找文件，其实classpath根路径就是src
		 */
		InputStream in = Test.class.getResourceAsStream("/mybatis-config.xml");
		//2.创建sessionFactory
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		//3.创建session
		SqlSession session = sf.openSession();
		//4.查询
		List<Book> books = session.selectList("book.findBooks");
		//循环遍历
		for (Book book : books) {
			System.out.println(book.getBookName());
		}
		
	}

}
