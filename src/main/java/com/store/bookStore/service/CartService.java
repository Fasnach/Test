package com.store.bookStore.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.bookStore.entity.BookInfo;
import com.store.bookStore.model.CartItemRequest;
import com.store.bookStore.model.CartItemResponse;
import com.store.bookStore.model.CartRequestInfo;
import com.store.bookStore.model.CartResponseInfo;
import com.store.bookStore.repository.BookRepository;

@Service
public class CartService {

	@Autowired
	private BookRepository bookRepository;

	/**
	 * Add to cart
	 * 
	 * @param cartRequestInfo
	 * @return
	 */
	public CartResponseInfo addToCart(CartRequestInfo cartRequestInfo) {

		CartResponseInfo cartResponseInfo = new CartResponseInfo();
		double totalAmountPayable = 0;

		/**
		 * setting the promotion code in response Assuming OFFER promo code corresponds
		 * to 50 percent discount on books
		 */
		if (cartRequestInfo != null) {
			String promotionCode = cartRequestInfo.getPromotionCode();
			if (promotionCode.equals("OFFER")) {
				cartResponseInfo.setPromotionCode(50);
			} else {
				cartResponseInfo.setPromotionCode(0);
			}

			/**
			 * build the cartItems response
			 */
			ArrayList<CartItemResponse> cartItemResponses = new ArrayList<CartItemResponse>();
			ArrayList<CartItemRequest> cartItemRequests = cartRequestInfo.getCartItems();

			if (cartItemRequests != null) {
				cartItemRequests.forEach(p -> setCartItemResponse(p, promotionCode, cartItemResponses));
			}

			cartResponseInfo.setCartItems(cartItemResponses);

			/**
			 * total payable amount
			 */
			for (CartItemResponse c : cartItemResponses) {
				totalAmountPayable += c.getSubTotalAfterDiscount();
			}
			cartResponseInfo.setAmountPayable(Double.toString(totalAmountPayable));
		}

		return cartResponseInfo;

	}

	/**
	 * 
	 * @param pcartItemRequest
	 * @param promotionCode
	 * @param cartItemResponses
	 */
	private void setCartItemResponse(CartItemRequest pcartItemRequest, String promotionCode,
			ArrayList<CartItemResponse> cartItemResponses) {

		CartItemResponse cartItemResponse = new CartItemResponse();
		cartItemResponse.setBookid(pcartItemRequest.getBookId());
		cartItemResponse.setQuantity(pcartItemRequest.getQuantity());
		BookInfo book = bookRepository.findById(pcartItemRequest.getBookId()).orElse(null);
		if (book != null) {
			double subTotal = book.getPrice() * pcartItemRequest.getQuantity();
			double subTotalAfterDiscount = subTotal;
			if (promotionCode.equals("OFFER")) {
				subTotalAfterDiscount = subTotalAfterDiscount * 0.5;
			}
			cartItemResponse.setSubTotal(subTotal);
			cartItemResponse.setSubTotalAfterDiscount(subTotalAfterDiscount);
			cartItemResponses.add(cartItemResponse);

		}

	}

}
