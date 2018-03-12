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
	
	@Test
	public void testInsert() {
		SqlSession session = getSession();
		try {
			BlogDao blogDao = session.getMapper(BlogDao.class);
			Blog blog = new Blog(2,"AAA","123467@163.com");
			blogDao.insert(blog);
			session.commit();
			System.out.println("�������");
		} finally {
			session.close();
		}
		
	}
	
	@Test
	public void testFindById() {
		SqlSession session = getSession();
		try {
			BlogDao blogDao = session.getMapper(BlogDao.class);
			Blog blog = blogDao.findById(1);
			System.out.println(blog.getEmail());
		} finally {
			session.close();
		}
		
	}
	
	@Test
	public void testDelete() {
		SqlSession session = getSession();
		try {
			BlogDao blogDao = session.getMapper(BlogDao.class);
			blogDao.delete(3);
			session.commit();
			System.out.println("ɾ�����");
		} finally {
			session.close();
		}
		
		
	}
}
