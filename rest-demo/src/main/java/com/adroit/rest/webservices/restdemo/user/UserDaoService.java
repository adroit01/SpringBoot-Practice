package com.adroit.rest.webservices.restdemo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	static 
	{
		users.add(new User("1", "Amit", 30, new Date()));
		users.add(new User("2", "Sumit", 25, new Date()));
		users.add(new User("3", "Vivek", 32, new Date()));
	}
	private static Integer userCount = users.size(); 
	//createUser
	public User createUser(User user)
	{
		if(user.getId() == null || user.getId().isEmpty())
		{
			userCount++;
			user.setId(userCount.toString());
		}
		users.add(user);
		return user;
	}
	public User getUser(String id)
	{
		for(User user:users)
		{
			if(user.getId().equals(id))
			{
				return user;
			}
		}
		return null;
	}
	
	public List<User> getAllUsers()
	{
		return users;
	}
	
	public boolean deleteUser(String id)
	{
		boolean isDeleted = false;
		for(Iterator<User> itr = users.iterator();itr.hasNext();)
		{
			User user= (User)itr.next();
			if(user.getId().equals(id))
			{
				itr.remove();
				isDeleted = true;
			}
		}
		return isDeleted;
	}
	
	public void deleteAllUsers()
	{
		users.clear();
	}
	
	public int getUserCount()
	{
		return userCount;
	}
}
