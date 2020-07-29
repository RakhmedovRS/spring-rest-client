package com.github.rakhmedovrs.springrestclient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rakhmedovrs.springrestclient.api.domain.User;
import com.github.rakhmedovrs.springrestclient.api.domain.UserData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
	private RestTemplate restTemplate;

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
		catch (JsonProcessingException ignore)
		{
			return Collections.emptyList();
		}
	}
}
