package cn.wxn.domain;

public class QueryInfo {

	private int currentPage = 1;
	private int pageSize = 5;
	private int begin = 0;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
System.out.println(this.currentPage);		
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	@Override
	public String toString() {
		return "QueryInfo [currentPage=" + currentPage + ", pageSize="
				+ pageSize + ", begin=" + begin + "]";
	}

}
