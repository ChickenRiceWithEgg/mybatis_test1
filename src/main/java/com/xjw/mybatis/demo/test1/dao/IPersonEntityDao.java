package com.xjw.mybatis.demo.test1.dao;

import java.util.List;

import com.xjw.mybatis.demo.test1.entity.PersonEntity;

public interface IPersonEntityDao {
	/**
	 * 插入一条记录
	 */
	public void insert(PersonEntity person);
	
	/**
	 *查询所有记录
	 */
	public List<PersonEntity> queryAll();
	
	/**
	 * 根据id查询用户
	 */
	public PersonEntity findUserById(int id);
	
	/**
	 * 根据用户名称，模糊查询用户
	 */
	public List<PersonEntity> findUserByName(String expression);
	
	/**
	 * 根据id，删除用户
	 */
	public void deleteUserById(int id);
	
	/**
	 * 根据id，更新用户
	 */
	public void updateUserById(PersonEntity person);
	
	
	
}
