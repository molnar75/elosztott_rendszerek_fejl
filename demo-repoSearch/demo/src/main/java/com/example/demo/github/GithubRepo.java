package com.example.demo.github;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;
import com.example.demo.Repo;
import com.example.demo.RestCommunicationException;

import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GithubRepo implements Repo {
	
	private final String gitHubSearchRepositoryBaseUrl = "https://api.github.com/search/repositories";

	private final RestTemplate restTemplate;
	@Override
	public List<String> searchByText(String queryString) {
		String url = gitHubSearchRepositoryBaseUrl + "?q=" + queryString;
		
		ResponseEntity<GithubSearchResponseRoot> response = restTemplate.getForEntity(url, GithubSearchResponseRoot.class);
		
		if (response.getStatusCode() == HttpStatus.OK) {
				 return response.getBody().getItems().stream().map(GithubItemDto::getName).collect(Collectors.toList());
		} else {
			throw new RestCommunicationException();
		}
					
	}

}
