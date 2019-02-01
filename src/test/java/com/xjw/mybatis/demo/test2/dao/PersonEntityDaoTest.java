package com.xjw.mybatis.demo.test2.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

//import com.xjw.mybatis.demo.test1.dao.impl.PersonEntityDao;
import com.xjw.mybatis.demo.test1.entity.PersonEntity;
import com.xjw.mybatis.demo.test1.util.MyBatisUtil;
import com.xjw.mybatis.demo.test2.mapper.UserMapper;


public class PersonEntityDaoTest {
	
	@Test
	public void testInsert() {
		PersonEntity person = new PersonEntity();
		//person.setId(213);
		person.setName("wangwu_2test");
		SqlSession session = MyBatisUtil.getSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		userMapper.insert(person); 
		session.commit();
		session.close();
	}
		
	
	/*
	@Test
	public void testQueryAll() {
		List<PersonEntity> personList = personEntityDao.queryAll();
		for(PersonEntity person : personList) {
			System.out.println(person);
		}
	}
	

	@Test
	public void testFindUserById() {
		PersonEntity person = personEntityDao.findUserById(200);
		System.out.println(person);
	}
	
	@Test
	public void testFindUserByName() {
		List<PersonEntity> person = personEntityDao.findUserByName("%gw%");	
		System.out.println(person);
	}
	
	@Test
	public void testDeleteUserById() {
		personEntityDao.deleteUserById(200);
	}
	
	@Test
	public void testUpdateUserById() {
		PersonEntity person = new PersonEntity();
		person.setId(201);
		person.setName("lisi");
		personEntityDao.updateUserById(person);
	}
	*/
}
