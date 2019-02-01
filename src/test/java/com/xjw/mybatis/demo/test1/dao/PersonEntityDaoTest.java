package com.xjw.mybatis.demo.test1.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.xjw.mybatis.demo.test1.dao.impl.PersonEntityDao;
import com.xjw.mybatis.demo.test1.entity.PersonEntity;

public class PersonEntityDaoTest {
	private IPersonEntityDao personEntityDao;
	
	@Before
	public void befor() {
		personEntityDao = new PersonEntityDao();
	}
	
	@Test
	public void testQueryAll() {
		List<PersonEntity> personList = personEntityDao.queryAll();
		for(PersonEntity person : personList) {
			System.out.println(person);
		}
	}
	
	@Test
	public void testInsert() {
		PersonEntity person = new PersonEntity();
//		person.setId(201);
		person.setName("wangwu2_2_2");
		personEntityDao.insert(person);
		
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
	
}
