package heejin.server.service;

public class ServiceManager {

	private static UserService userService;
	
	public static UserService getUserService() {
		if(userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}
	
}
