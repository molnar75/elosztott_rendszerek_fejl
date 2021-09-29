package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MainController {
	
	private final Calculator calculator;
	private final Repo repo;

	@RequestMapping("/")
	String main() {
		return "Hello World!";
	}
	
	@RequestMapping(path = "/calculator", produces = MediaType.APPLICATION_JSON_VALUE)
	Double calculate(@Valid CalculatorRequestDto calculatorRequestDto) {
		return calculator.add(calculatorRequestDto.getOperandus1(), calculatorRequestDto.getOperandus2());
	}
	
	@RequestMapping(path = "/repoSearch", produces = MediaType.APPLICATION_JSON_VALUE)
	List<String> repoSearch(@Valid RepoSerachDto repoSerachDto) {
		return repo.searchByText(repoSerachDto.getQueryString());
	}
	
	
}

//with Controller annotation we need ResponseBody
/*@Controller
public class MainController {
	
	@RequestMapping("/")
	@ResponseBody
	String main() {
		return "Hello World";
	}
	
}*/
