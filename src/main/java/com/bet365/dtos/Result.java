package com.bet365.dtos;

import java.util.List;

public class Result<T> {

	private T data;
	private List<T> list;
	private int page;
	private int size;
	private int noOfRecords;
	
	public Result(List<T> list, int page, int size, int noOfRecords) {
		this.list = list;
		this.page = page;
		this.size = size;
		this.noOfRecords = noOfRecords;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNoOfRecords() {
		return noOfRecords;
	}

	public void setNoOfRecords(int noOfRecords) {
		this.noOfRecords = noOfRecords;
	}
}
