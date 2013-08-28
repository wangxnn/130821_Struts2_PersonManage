package cn.wxn.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.wxn.domain.Person;
import cn.wxn.domain.QueryResult;
import cn.wxn.utils.DaoUtils;

public class PersonDaoImpl {
	
	public void add(Person p){
		DataSource ds = DaoUtils.getDataSource();
		QueryRunner runner = new QueryRunner(ds);
		try {
			String sql = " insert into S_User values (null,?,?,?,?,?,?,?,?,?,?,?)";
			Object[] params = new Object[]{p.getUserName(),p.getLoginName(),p.getLoginPwd(),p.getSex(),p.getBirthday(),p.getEducation(),p.getTelephone(), p.getInterest(),p.getPath(),p.getFilename(),p.getRemark()};
			runner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("deprecation")
	public Person find(String name, String password){
		DataSource ds = DaoUtils.getDataSource();
		QueryRunner runner = new QueryRunner(ds);
	
		try {
			String sql = "select * from S_User where loginName=? and loginPwd=?";
			Object[] params = new Object[]{name, password};
			return (Person)runner.query(sql, params, new BeanHandler(Person.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public QueryResult query(int begin, int pageSize){
		DataSource ds = DaoUtils.getDataSource();
		QueryRunner runner = new QueryRunner(ds);
		
		try {
			String sql = "select * from S_User limit ?,?";
			Object[] params = new Object[]{begin, pageSize};
			List<Person> list =  (List<Person>)runner.query(sql, params, new BeanListHandler(Person.class));
			sql = "select count(userID) from S_User";
			int totalRecord =((Long)runner.query(sql, new ScalarHandler(1))).intValue();

			//封装数据返回
			QueryResult  ql = new QueryResult();
			ql.setList(list);
			ql.setTotalRecord(totalRecord);
			return ql;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void delete(int id){
			DataSource ds = DaoUtils.getDataSource();
			QueryRunner runner = new QueryRunner(ds);
			
			try {
				String sql = "delete from S_User where userID=?";
				runner.update(sql, id);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

	@SuppressWarnings("deprecation")
	public Person find(int id) {
		DataSource ds = DaoUtils.getDataSource();
		QueryRunner runner = new QueryRunner(ds);
		
		try {
			String sql = "select * from S_User where userID=?";
			return (Person)runner.query(sql, id, new BeanHandler(Person.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
