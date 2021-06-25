package com.store.bookStore.model;

import java.util.ArrayList;

public class CartResponseInfo {

	private double promotionCode;
	private String amountPayable;
	private ArrayList<CartItemResponse> cartItems;

	public double getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(double promotionCode) {
		this.promotionCode = promotionCode;
	}

	public String getAmountPayable() {
		return amountPayable;
	}

	public void setAmountPayable(String amountPayable) {
		this.amountPayable = amountPayable;
	}

	public ArrayList<CartItemResponse> getCartItems() {
		return cartItems;
	}

	public void setCartItems(ArrayList<CartItemResponse> cartItems) {
		this.cartItems = cartItems;
	}

}
