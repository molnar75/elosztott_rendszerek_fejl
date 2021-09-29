package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.github.GithubItemDto;
import com.example.demo.github.GithubRepo;
import com.example.demo.github.GithubSearchResponseRoot;

class RepoTest {
	
	private final String gitHubSearchRepositoryBaseUrl = "https://api.github.com/search/repositories";

	@Test
	void test_searchByText_OK() {
		
		//GIVEN
		RestTemplate mockRestTemplate = mock(RestTemplate.class);
		GithubRepo repo = new GithubRepo(mockRestTemplate);
		String qs = "ize";
		
		GithubItemDto item = new GithubItemDto();
		item.setName("demo");
		
		List<GithubItemDto> items = new ArrayList();
		items.add(item);
		
		GithubSearchResponseRoot mockRoot = new GithubSearchResponseRoot();
		mockRoot.setItems(items);
		
		when(mockRestTemplate.getForEntity(gitHubSearchRepositoryBaseUrl + "?q=" +  qs, 
				GithubSearchResponseRoot.class)).thenReturn(
						new ResponseEntity(mockRoot, HttpStatus.OK));
		
		//WHEN
		List<String> response = repo.searchByText(qs);
		
		assertThat(response, hasSize(1));
		assertThat(response.get(0), is("demo"));
		
		//THEN
		verify(mockRestTemplate).getForEntity(gitHubSearchRepositoryBaseUrl + "?q=" + qs, GithubSearchResponseRoot.class);
	}
	
	@Test
	void test_searchByText_404() {
		
		//GIVEN
		RestTemplate mockRestTemplate = mock(RestTemplate.class);
		GithubRepo repo = new GithubRepo(mockRestTemplate);
		String qs = "ize";
		
		when(mockRestTemplate.getForEntity(gitHubSearchRepositoryBaseUrl + "?q=" +  qs, 
				GithubSearchResponseRoot.class)).thenReturn(
						new ResponseEntity(null, HttpStatus.NOT_FOUND));
		
		//WHEN
		try {
			List<String> response = repo.searchByText(qs);
			fail("Exception not thrown");
		} catch(RestCommunicationException ex) {
			//Exception thrown
		}
		
		//THEN
		verify(mockRestTemplate).getForEntity(gitHubSearchRepositoryBaseUrl + "?q=" + qs, GithubSearchResponseRoot.class);
	}

}
