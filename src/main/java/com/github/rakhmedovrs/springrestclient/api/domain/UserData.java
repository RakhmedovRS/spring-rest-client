package com.github.rakhmedovrs.springrestclient.api.domain;

import java.util.List;

/**
 * @author RakhmedovRS
 * @created 29-Jul-20
 */
public class UserData
{
	private List<User> users;

	public UserData()
	{
	}

	public UserData(List<User> users)
	{
		this.users = users;
	}

	public List<User> getUsers()
	{
		return users;
	}

	public void setUsers(List<User> users)
	{
		this.users = users;
	}
}
