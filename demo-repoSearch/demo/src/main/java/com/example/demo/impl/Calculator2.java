package com.example.demo.impl;

import org.springframework.stereotype.Service;

import com.example.demo.Calculator;

@Service
public class Calculator2 implements Calculator {

	@Override
	public Double add(Double operandus1, Double opreandus2) {
		return operandus1 + opreandus2;
	}

}
