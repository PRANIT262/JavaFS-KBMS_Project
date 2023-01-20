package com.revature.dao;

public interface PlaceOrderDao {
	public  void getVegetables();

	public void getFruits();

	public void getSpices();

	public void getDetails();

	public void tempCart(int productID, int productQuantity);

	public void finalCart();

}
