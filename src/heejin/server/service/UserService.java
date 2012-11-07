package heejin.server.service;

import heejin.server.model.User;

public interface UserService {
	
	public void addUser(User user);
	public void removeUser(User user);
	public User getUser(String userName);
	
}
