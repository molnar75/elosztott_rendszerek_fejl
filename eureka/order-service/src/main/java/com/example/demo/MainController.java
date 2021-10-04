package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
public class MainController {
	
	private final StorageClient storageClient;
	
	public MainController(StorageClient storageClient) {
		super();
		this.storageClient = storageClient;
	}


	@GetMapping("/order")
	public String order() {
		int remainingProducts = storageClient.deliver();
		return "Order Confirmed! Remaining products: " + remainingProducts;
	}
}
