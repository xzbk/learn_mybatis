一、入门mybatis
	1.建立项目，导包，书写配置文件(mybatis-config.xml,Book.xml)
	2.入门demo(Test)
		1)读取配置文件(mybatis-config.xml),注意在配置文件中配置Book.xml
		2)构建session工厂
		3)创建session
		4)查询
二、基础部分
	封装MybatisUtils
	1.查询
		1)返回值使用的是resultMap
		  TestBaseQuery.test1
		2)返回值使用的是map
		  TestBaseQuery.test2
		3)带一个条件的查询
		  TestBaseQuery.test3
		4)带多个条件的查询
		  TestBaseQuery.test4
		5)带多个条件的查询,动态sql，使用if
		  TestBaseQuery.test5
		6)带多个条件的查询,动态sql，使用trim
		  TestBaseQuery.test6
	2.插入
		1)普通insert
		  TestBaseInsert.test1
		2)insert,自动生成id(oracle数据库索引使用)
		  TestBaseInsert.test2
	3.更新
		1)普通update
		  TestBaseUpdate.test1
	4.删除
		1)普通删除
		  TestBaseDelete.test1
三、高级部分
	1.selectOne选择一条记录
	  TestSenior.testSelectOne
	2.selectIn
	  TestSenior.testSelectIn
	3.分页查询,查询第一页，每页2条，下标从0开始，一共2条
	  TestSenior.testPage
	4.关联查询
	  TestSenior.testFindBookByTypeId
四、Mybatis采用Dao接口直接映射sql
	1.书写接口IBookDao，配置IBookDao.xml文件的namespace属性值为IBookDao的全限定名
	2.将IBookDao.xml文件配置到mybatis-config.xml
	3.测试
		1)查询(TestDao.testFindBooks)
		2)插入(TestDao.testInsert)
五、mybatis的缓存机制
	1.一级缓存
		测试一级缓存,一级换存级别为session内部，不能够跨session的
		TestCache.testLevelOne	
	2.二级缓存
		测试二级缓存,只有commit提交数据库，确定修改了数据库后二级换存才会真正进行缓存，二级换存是跨session的
		TestCache.testLevelTwo	
		  

		  
		  
		  
		  
		  
		  
		  
		  
		  