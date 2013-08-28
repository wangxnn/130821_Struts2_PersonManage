package cn.wxn.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DaoUtils {
	
	private static DataSource ds;
	
	static{
		try{
		ds = new ComboPooledDataSource();
		}catch(Exception ex){
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
}
