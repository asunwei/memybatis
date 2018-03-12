package com.learn.dao;

import java.util.List;

import com.learn.entity.Blog;

/**
 * BlogDao.java �ķ������� BlogDao.xml�ķ�����һ�¡�
 * @author sunwei
 *
 */
public interface BlogDao {
	public void insert(Blog blog);
    public void delete(int id);
    public void update(Blog blog);
    public Blog findById(int id);
    public List<Blog> findAll();
}
