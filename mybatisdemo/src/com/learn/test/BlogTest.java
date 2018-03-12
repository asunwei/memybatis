package com.learn.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.learn.dao.BlogDao;
import com.learn.entity.Blog;


/**
 * Blog�Ĳ�����
 * @author sunwei
 *
 */
public class BlogTest {

	private SqlSession getSession() {
		//1.��ȡ�����ļ�sqMapConfig.xml������sqlSessionFactoryʵ����
		//ͨ�����������ȡ.xml�ļ�
		InputStream in = getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
		//2.ÿһ����������һ��sqlSessionFactory����Ϊ���ģ�����sqlSessionFactory.
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = builder.build(in);
		//3.����sqlSession���󣬸ö���Ӧ�����߳�˽�еġ�ÿ��������Ҫ����һ����Ȼ����finally��رա�
		return sqlSessionFactory.openSession();
		
	}
	
	private BlogDao getBlogDao() {
		SqlSession session = getSession();
		return session.getMapper(BlogDao.class);
	}
	@Test
	public void testInsert() {
		BlogDao blogDao = getBlogDao();
		Blog blog = new Blog();
		blog.setId(2);
		blog.setName("AA");
		blog.setEmail("29730982739@ww.com");
		blogDao.insert(blog);
		System.out.println("�������");
	}
	
	@Test
	public void testFindById() {
		BlogDao blogDao = getBlogDao();
		Blog blog = blogDao.findById(1);
		System.out.println(blog.getEmail());
	}
	
	@Test
	public void testDelete() {
		BlogDao blogDao = getBlogDao();
		blogDao.delete(3);
		
	}
}
