package heejin.server.service;

import heejin.server.model.User;

import java.util.HashMap;

public class UserServiceImpl implements UserService {

	private HashMap<String, User> users;
	
	public UserServiceImpl() {
		// TODO load from database
		users = new HashMap<String, User>();
	}
	
	@Override
	public void addUser(User user) {
		users.put(user.getUserName(), user);
	}

	@Override
	public void removeUser(User user) {
		boolean validUser = users.containsKey(user.getUserName());
		
		if(validUser)
			users.remove(user.getUserName());
	}

	@Override
	public User getUser(String userName) {
		return users.get(userName);
	}


}
