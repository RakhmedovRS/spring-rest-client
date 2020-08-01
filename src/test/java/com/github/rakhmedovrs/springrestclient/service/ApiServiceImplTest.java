package com.github.rakhmedovrs.springrestclient.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * @author RakhmedovRS
 * @created 29-Jul-20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ApiServiceImplTest
{
	@Autowired
	ApiService apiService;

	@Before
	public void setup()
	{

	}

	@Test
	public void testGetUsers()
	{
		assertTrue(!apiService.getUsers(3).isEmpty());
	}
}