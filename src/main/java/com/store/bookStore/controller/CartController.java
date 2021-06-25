package com.store.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.store.bookStore.model.CartRequestInfo;
import com.store.bookStore.model.CartResponseInfo;
import com.store.bookStore.service.CartService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CartController {

	@Autowired
	CartService cartService;

	@PostMapping("/cart")
	public ResponseEntity<CartResponseInfo> addToCart(@RequestBody CartRequestInfo cartRequestInfo) {
		CartResponseInfo cartResponseInfo = cartService.addToCart(cartRequestInfo);

		return new ResponseEntity<CartResponseInfo>(cartResponseInfo, HttpStatus.OK);
	}

}
