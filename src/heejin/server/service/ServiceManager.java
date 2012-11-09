package heejin.server.service;

public class ServiceManager {

	static {
		// this order can't reordered. musicService > userService
		musicService = new MusicServiceImpl();
		userService = new UserServiceImpl();
	}
	
	private static UserService userService;
	private static MusicService musicService;
	
	public static UserService getUserService() {
		return userService;
	}

	public static MusicService getMusicService() {
		return musicService;
	}
	
}
