package com.github.rakhmedovrs.springrestclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rakhmedovrs.springrestclient.api.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

	public ApiServiceImpl(RestTemplate restTemplate)
	{
		this.restTemplate = restTemplate;
	}

	@Override
	public List<User> getUsers(Integer limit)
	{
		String userDataObject = restTemplate.getForObject(String.format("https://jsonplaceholder.typicode.com/users?limit=%d", limit), String.class);
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
