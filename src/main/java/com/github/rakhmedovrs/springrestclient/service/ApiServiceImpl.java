package com.github.rakhmedovrs.springrestclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rakhmedovrs.springrestclient.api.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 29-Jul-20
 */
@Service
public class ApiServiceImpl implements ApiService
{
	private final RestTemplate restTemplate;
	private final String apiURL;

	public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String apiURL)
	{
		this.restTemplate = restTemplate;
		this.apiURL = apiURL;
	}

	@Override
	public List<User> getUsers(Integer limit)
	{
		UriComponentsBuilder builder = UriComponentsBuilder
			.fromUriString(apiURL)
			.queryParam("limit", limit);

		String userDataObject = restTemplate.getForObject(builder.toUriString(), String.class);
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			User[] users = mapper.readValue(userDataObject, User[].class);
			return Arrays.asList(users);
		}
		catch (IOException ignore)
		{
			return Collections.emptyList();
		}
	}
}
