package com.revature.model;

public class Order {
	private int orderId;
	private String productId;
	private int quantity;
	private double totalPrice;
	private String orderDate;
	private String status;
	private int cancellationId;
	private String cancellationDate;
	private String cancellationReson;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderId, String productId, int quantity, double totalPrice, String orderDate, String status,
			int cancellationId, String cancellationDate, String cancellationReson) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.status = status;
		this.cancellationId = cancellationId;
		this.cancellationDate = cancellationDate;
		this.cancellationReson = cancellationReson;
	}
	// TODO Auto-generated constructor stub

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getproductId() {
		return productId;
	}
	public void setproductId(String productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCancellationId() {
		return cancellationId;
	}
	public void setCancellationId(int cancellationId) {
		this.cancellationId = cancellationId;
	}
	public String getCancellationDate() {
		return cancellationDate;
	}
	public void setCancellationDate(String cancellationDate) {
		this.cancellationDate = cancellationDate;
	}
	public String getCancellationReson() {
		return cancellationReson;
	}
	public void setCancellationReson(String cancellationReson) {
		this.cancellationReson = cancellationReson;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + ", orderDate=" + orderDate + ", status=" + status + ", cancellationId=" + cancellationId
				+ ", cancellationDate=" + cancellationDate + ", cancellationReson=" + cancellationReson + "]";
	}

}