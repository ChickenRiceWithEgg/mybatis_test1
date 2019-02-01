package com.xjw.mybatis.demo.test1.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory = null;
	
	public static void initialFactory() {
		//mybatis配置文件的名字
		String resource = "mybatis-config.xml";
		try {
			
			//读取mybatis配置文件中的信息
			InputStream in = Resources.getResourceAsStream(resource);
			//将mybatis配置文件中的信息传入到factoryBuilder中，创建SqlSessionFactory
			//单例模式，创建factory时只new一次
			factory = new SqlSessionFactoryBuilder().build(in);
		}catch(IOException e) {
			System.out.println("出错了==================================");
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession() {
		if(factory == null) {
			initialFactory();
		}
		//通过SqlSessionFactryory创建SqlSession
		return factory.openSession();
	}
}
