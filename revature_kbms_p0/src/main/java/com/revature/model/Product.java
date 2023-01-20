package com.revature.model;

public class Product {

	private int productId;
	private String productName;
	private int productCount;
	private double totalStock;
	private String bestBefore;
	private double pricePerUnit;

	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(int productId, String productName, int productCount, double totalStock, String bestBefore,double pricePerUnit) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCount = productCount;
		this.totalStock = totalStock;
		this.bestBefore = bestBefore;
		this.pricePerUnit=pricePerUnit;
	}
	
	
	public Product(int int1, String string, double double1) {
		// TODO Auto-generated constructor stub
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public double getTotalStock() {
		return totalStock;
	}
	public void setTotalStock(double totalStock) {
		this.totalStock = totalStock;
	}
	public String getBestBefore() {
		return bestBefore;
	}
	public void setBestBefore(String bestBefore) {
		this.bestBefore = bestBefore;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCount=" + productCount
				+ ", totalStock=" + totalStock + ", bestBefore=" + bestBefore + ", pricePerUnit=" + pricePerUnit + "]";
	}

}