package cn.wxn.service.impl;

import java.util.List;

import cn.wxn.dao.impl.PersonDaoImpl;
import cn.wxn.domain.Person;
import cn.wxn.domain.QueryInfo;
import cn.wxn.domain.QueryPage;
import cn.wxn.domain.QueryResult;

public class ServiceImpl {
	private PersonDaoImpl pdao = new PersonDaoImpl();
	
	public void addPerson(Person p){
		if(p==null){
			return;
		}
		pdao.add(p);
	}
	
	public Person findPerson(String name, String password){
		return pdao.find(name, password);
	}

	public QueryPage query(QueryInfo info){
		
		//从接收参数中得到数据
		int pageSize = info.getPageSize();
		int begin = info.getBegin();
		int currentPage = info.getCurrentPage();

		//从查询结果中得到数据
		QueryResult qr = pdao.query(begin, pageSize);
		List<Person> list = qr.getList();
		int totalRecord = qr.getTotalRecord();
		
		//综合数据交给Bean，然后返回给页面
		QueryPage page = new QueryPage();
		page.setCurrentPage(currentPage);
		page.setList(list);
		page.setPageSize(pageSize);
		page.setTotalRecord(totalRecord);
		
		return page;
	}
	
	
	public void deletePerson(int id){
		pdao.delete(id);
	}

	public Person find(int id) {
		return pdao.find(id);
	}
}
