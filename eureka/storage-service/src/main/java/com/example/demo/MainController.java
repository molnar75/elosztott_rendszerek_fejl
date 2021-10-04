package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	private int productCount = 100;
	
	@GetMapping("/deliver")
	public int deliver() {
		return --productCount;
	}
}
