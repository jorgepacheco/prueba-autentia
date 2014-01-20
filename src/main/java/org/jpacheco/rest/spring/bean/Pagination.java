package org.jpacheco.rest.spring.bean;

public class Pagination {
	
	private int page = 5;
	private int numberPage = 1;
	private int total = 0;	
	
	private String order = "desc";
	
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNumberPage() {
		return numberPage;
	}
	public void setNumberPage(int numberPage) {
		this.numberPage = numberPage;
	}
	
	public int getOffset(){
		
		
		return page * (numberPage - 1);
	}

	
}
