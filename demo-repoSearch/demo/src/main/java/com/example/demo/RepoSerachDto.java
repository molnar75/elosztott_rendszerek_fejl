package com.example.demo;


import org.hibernate.validator.constraints.Length;
import lombok.Data;
import lombok.NonNull;

@Data
public class RepoSerachDto {
	
	@NonNull
	@Length(min=3)
	private String queryString;
}
