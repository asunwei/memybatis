package com.learn.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.learn.dao.BlogDao;
import com.learn.entity.Blog;


/**
 * Blog的测试类
 * @author sunwei
 *
 */
public class BlogTest {

	private SqlSession getSession() {
		//1.读取配置文件sqMapConfig.xml来构建sqlSessionFactory实例。
		//通过类加载器读取.xml文件
		InputStream in = getClass().getClassLoader().getResourceAsStream("mybatis-config.xml");
		//2.每一个程序都是以一个sqlSessionFactory对象为核心，创建sqlSessionFactory.
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = builder.build(in);
		//3.创建sqlSession对象，该对象应该是线程私有的。每个方法都要创建一个，然后再finally块关闭。
		return sqlSessionFactory.openSession();
		
	}
	
	@Test
	public void testInsert() {
		SqlSession session = getSession();
		try {
			BlogDao blogDao = session.getMapper(BlogDao.class);
			for(int i=1; i<=5; i++) {
				Blog blog = new Blog(i,"BBB","464646546@163.com");
				blogDao.insert(blog);
				session.commit();
			}
			System.out.println("插入完成");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testDelete() {
		SqlSession session = getSession();
		try {
			BlogDao blogDao = session.getMapper(BlogDao.class);
			for(int i=1; i<=5; i++) {
				blogDao.delete(i);
				session.commit();
			}
			System.out.println("删除完成");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testUpdate() {
		SqlSession session = getSession();
		try {
			BlogDao blogDao = session.getMapper(BlogDao.class);
			Blog blog = new Blog(2,"MIC","AAAA@BB.com");
			blogDao.update(blog);
			session.commit();
			System.out.println("更新完成！");
		} catch (Exception e) {
			e.printStackTrace();
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
			System.out.println(blog);
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testFindAll() {
		SqlSession session = getSession();
		try {
			BlogDao blogDao = session.getMapper(BlogDao.class);
			List<Blog> blogList = blogDao.findAll();
			for(Blog blog : blogList) {
				System.out.println(blog);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			session.close();
		}
	}
}
