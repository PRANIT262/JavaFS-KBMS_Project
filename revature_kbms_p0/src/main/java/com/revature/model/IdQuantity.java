package com.revature.model;

public class IdQuantity {
	private int pid;
	private int quantity;
	public int getPid() {
		return pid;
	}
	
	public IdQuantity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IdQuantity(int pid, int quantity) {
		super();
		this.pid = pid;
		this.quantity = quantity;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
