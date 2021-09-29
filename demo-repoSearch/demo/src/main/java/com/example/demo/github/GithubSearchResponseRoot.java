package com.example.demo.github;

import java.util.List;

import lombok.Data;

@Data
public class GithubSearchResponseRoot {
	private int total_count;
	private boolean incomplete_results;
	private List<GithubItemDto> items;
}
