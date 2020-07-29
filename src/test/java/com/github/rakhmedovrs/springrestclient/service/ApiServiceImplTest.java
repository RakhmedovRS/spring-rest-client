package com.github.rakhmedovrs.springrestclient.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author RakhmedovRS
 * @created 29-Jul-20
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ApiServiceImplTest
{
	@Autowired
	ApiService apiService;

	@BeforeEach
	public void setup()
	{

	}

	@Test
	public void testGetUsers()
	{
		assertTrue(!apiService.getUsers(3).isEmpty());
	}
}