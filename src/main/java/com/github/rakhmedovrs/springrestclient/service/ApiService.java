package com.github.rakhmedovrs.springrestclient.service;

import com.github.rakhmedovrs.springrestclient.api.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author RakhmedovRS
 * @created 29-Jul-20
 */
public interface ApiService
{
	List<User> getUsers(Integer limit);

	Flux<User> getUsers(Mono<Integer> limit);
}
