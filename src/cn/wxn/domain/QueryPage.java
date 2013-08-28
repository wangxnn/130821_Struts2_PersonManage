package cn.wxn.domain;

import java.util.List;

public class QueryPage {
	private List<Person> list;
	private int totalRecord;
	private int pageSize;
	private int currentPage;
	private int previousPage;
	private int nextPage;
	private int[] pageBar;
	
	private int totalPage;
	
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
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	
	public int getPreviousPage() {
		if(this.getCurrentPage()<=1){
			this.previousPage = 1;
		}else{
			this.previousPage = this.getCurrentPage() -1;
		}
		return previousPage;
	}


	public int getTotalPage() {
		if(this.totalRecord%this.pageSize==0){
			this.totalPage = this.totalRecord / this.pageSize;
		}else{
			this.totalPage = this.totalRecord / this.pageSize + 1;
		}
		return totalPage;
	}
	
	public int getNextPage() {
		if(this.currentPage>= this.getTotalPage()){
			this.nextPage = this.currentPage;
		}else{
			this.nextPage = this.currentPage + 1;
		}
		return nextPage;
	}
	
	public int[] getPageBar() {
		int begin=0 ;
		int end =0;
		
		//当总页数大于或者等于10的时候，数字条 只显示10个页面
		if(this.getTotalPage()>=10){
			this.pageBar = new int[10];
			
			begin = this.currentPage - 4;
			end = this.currentPage + 5;
			if(end >this.getTotalPage()){
				end = this.getTotalPage();
				begin = end  - 9 ;
			}
			if(begin < 1){
				begin = 1;
				end = begin + 9;
			}
		}else{
			//当数据库中没有数据的时候, 直接返回就可以了，数组中保留一个1
			if(this.getTotalPage() ==0){
				this.pageBar = new int[1];
				this.pageBar[0] = 1;
				return this.pageBar;
			}
			//有数据，但页面数不足10的时候
			this.pageBar = new int[this.getTotalPage()];
			begin = 1;
			end = this.getTotalPage();
		}
		
		//为正常情况下的pageBar赋值
		for(int i=0; i<this.pageBar.length; i++){
			this.pageBar[i] = begin + i;
		}
		
		return pageBar;
	}

	
}
