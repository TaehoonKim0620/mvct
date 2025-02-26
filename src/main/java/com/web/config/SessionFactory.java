package com.web.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {
	private static SqlSessionFactory ssf;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config2.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			ssf = ssfb.build(reader);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSSF() {
		return ssf;
	}
	public static void main(String[] args) {
		System.out.println(getSSF());
	}
}
