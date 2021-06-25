package com.store.bookStore.model;

import java.util.ArrayList;

public class CartRequestInfo {

	private ArrayList<CartItemRequest> cartItems;
	private String promotionCode = "OFFER";

	public ArrayList<CartItemRequest> getCartItems() {
		return cartItems;
	}

	public void setCartItems(ArrayList<CartItemRequest> cartItems) {
		this.cartItems = cartItems;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

}
