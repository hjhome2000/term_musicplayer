package heejin.server.service;

public class ServiceManager {

	static {
		// 무조건 musicService가 먼저 로드되어야 함.
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
