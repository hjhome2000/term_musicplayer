package heejin.server.controller;

import heejin.server.model.Music;
import heejin.server.model.User;
import heejin.server.service.ServiceManager;
import heejin.server.service.UserService;
import heejin.server.util.SecurityUtil;

public class UserController {

	UserService userService = ServiceManager.getUserService();
	
	public User createUser(String userName, String passwd) {
		User newUser = null;		
		boolean duplicated = userService.getUser(userName) != null;
		
		try {
			String md5hash = SecurityUtil.getCryptoMD5String(userName + passwd);
			newUser = new User(userName, md5hash);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(newUser == null || duplicated)
			return null;
		else
			userService.addUser(newUser);
		
		return newUser;
	}
	
	public void removeUser(User user) {
		if(user == null)
			return;
		
		userService.removeUser(user);
	}
	
	public boolean buyMusic(User user, Music music) {
		return userService.buyMusic(user, music);
	}

	public void chargeCash(User user, int chargeAmount) {
		userService.chargeCash(user, chargeAmount);
	}
	
	public void close() {
		userService.close();
	}
	
}
