package com.xjw.mybatis.demo.test1.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xjw.mybatis.demo.test1.dao.IPersonEntityDao;
import com.xjw.mybatis.demo.test1.entity.PersonEntity;
import com.xjw.mybatis.demo.test1.util.MyBatisUtil;

public class PersonEntityDao implements IPersonEntityDao{
	//映射文件
	public static final String NAMESPACE = "com.xjw.mybatis.demo.test1.mapper.PersonEntityMapper";
	
	//原始的DAO开发，在DAO接口的实现类中存在大量重复的模板代码
	
	@Override
	public void insert(PersonEntity person) {
		//注入SqlSession工厂（这里是将创建SqlSessionFactory封装成了MyBatisUtil类），来获得SqlSession
		//因为SqlSession是线程不安全的，所以没有将获取SqlSession也封装起来，而是在具体的方法体内部使用。
		SqlSession session = MyBatisUtil.getSession();
		//第一个参数是，映射文件的路径加上映射文件中select中的id值，表示一条statement
		session.insert(NAMESPACE + ".insert",person);
		session.commit();
		session.close();
	}
	
	@Override
	public List<PersonEntity> queryAll() {
		SqlSession session = MyBatisUtil.getSession();
		List<PersonEntity> personList = session.selectList(NAMESPACE + ".queryAll");
		session.commit();
		session.close();
		return personList;
	}
	
	@Override
	public PersonEntity findUserById(int id) {
		SqlSession session = MyBatisUtil.getSession();
		//selectOne()方法
		//第一个参数：映射文件中statement的id，等于namespace+“.”+映射文件中<select>标签中的id属性的值
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		//SqlSession.selectOne方法的返回值，是与映射文件<select resultType=“类型”>所匹配的对象
		PersonEntity person = session.selectOne(NAMESPACE+".findUserById", id);
		session.commit();
		session.close();
		return person;
	}
	
	@Override
	public List<PersonEntity> findUserByName(String expression) {
		SqlSession session = MyBatisUtil.getSession();
		List<PersonEntity> person = session.selectList(NAMESPACE+".findUserByName", expression);
		session.commit();
		session.close();
		return person;
	}
	
	@Override
	public void deleteUserById(int id) {
		SqlSession session = MyBatisUtil.getSession();
		session.delete(NAMESPACE+".deleteById", id);
		session.commit();
		session.close();
	}
	
	@Override
	public void updateUserById(PersonEntity person) {
		SqlSession session = MyBatisUtil.getSession();
		session.update(NAMESPACE+".updateById", person);
		session.commit();
		session.close();
	}
}
