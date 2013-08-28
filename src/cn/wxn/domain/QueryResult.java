package cn.wxn.domain;

import java.util.List;

public class QueryResult {
	
	private List<Person> list;
	private int totalRecord;
	public List<Person> getList() {
		return list;
	}
	public void setList(List<Person> list) {
		this.list = list;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	
	
}
