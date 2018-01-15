package com.test;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bigman.blog.bean.MicroBlog;
import com.bigman.blog.bean.User;
import com.bigman.blog.bean.User_info;
import com.bigman.blog.dao.MicroBlogDao;
import com.bigman.blog.dao.UserDao;
import com.bigman.blog.dao.UserInfoDao;

public class Test1 {

	private ClassPathXmlApplicationContext ac = null;
	
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("conf/spring-dao.xml",
				"conf/spring-service.xml"
				,"conf/spring-mvc.xml","conf/spring-db.xml",
				"conf/spring-mybatis.xml");
	}
	@After
	public void destroy() {
		ac.close();
	}
	
	@Test
	public void test11() {
		UserDao dao = ac.getBean("userDao",UserDao.class);
		
		dao.changePortrait(1, "/dfdfff//");
		
		User u = dao.findUserByName("刘栉风");
		System.out.println(u);
	}
	
	@Test
	public void test2() {
		MicroBlogDao dao = ac.getBean("microBlogDao",MicroBlogDao.class);
		List<MicroBlog> list = dao.selectMicroBlog(1);
		System.out.println(list);
	}
	
	@Test
	public void test3() {
		UserInfoDao dao = ac.getBean("userInfoDao",UserInfoDao.class);
		User_info u = dao.findUserInfoByName("刘栉风");
		System.out.println(u);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
