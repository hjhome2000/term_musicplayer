package heejin.server.controller;

import heejin.server.model.User;
import heejin.server.service.ServiceManager;
import heejin.server.service.UserService;
import heejin.server.util.SecurityUtil;

public class SignController {

	UserService userService = ServiceManager.getUserService();
	
	public User login(String userName, String passwd){
		User user = userService.getUser(userName);

		if(user == null)
			return null;
		
		try {
			String md5hash_input = SecurityUtil.getCryptoMD5String(userName + passwd);
			String md5hash_user = user.getHash();
			boolean isSameUser = md5hash_user.equals(md5hash_input);
			
			if(!isSameUser)
				return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	// no logout
}
