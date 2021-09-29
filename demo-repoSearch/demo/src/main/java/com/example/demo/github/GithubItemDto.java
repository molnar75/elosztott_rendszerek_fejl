package com.example.demo.github;

import java.util.List;

import lombok.Data;

@Data
public class GithubItemDto {
	private String name;
	private String path;
	private String url;
	private List<GithubRepoDto> githubRepoDto;
}
