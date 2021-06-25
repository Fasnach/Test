package com.store.bookStore.model;

public class CartItemResponse {
	private int bookid;
	private int quantity;
	private double subTotal;
	private double subTotalAfterDiscount;

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getSubTotalAfterDiscount() {
		return subTotalAfterDiscount;
	}

	public void setSubTotalAfterDiscount(double subTotalAfterDiscount) {
		this.subTotalAfterDiscount = subTotalAfterDiscount;
	}

}
