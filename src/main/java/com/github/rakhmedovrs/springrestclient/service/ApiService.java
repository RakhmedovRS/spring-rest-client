package com.github.rakhmedovrs.springrestclient.service;

import com.github.rakhmedovrs.springrestclient.api.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RakhmedovRS
 * @created 29-Jul-20
 */
public interface ApiService
{
	List<User> getUsers(Integer limit);
}
