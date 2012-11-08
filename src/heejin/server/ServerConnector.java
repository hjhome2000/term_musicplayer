package heejin.server;

import heejin.server.controller.MusicController;
import heejin.server.controller.SignController;
import heejin.server.controller.UserController;

public class ServerConnector {
	
	private static ServerConnector instance;
	
	private UserController userController;
	private MusicController musicController;
	private SignController signController;
	
	public ServerConnector() {
		userController = new UserController();
		musicController = new MusicController();
		signController = new SignController();
	}
	
	public static ServerConnector getInstance() {
		if(instance == null) {
			instance = new ServerConnector();
		}
		
		return instance;
	}
	
	public UserController getUserController() {
		return userController;
	}
	
	public MusicController getMusicController() {
		return musicController;
	}
	
	public SignController getSignController() {
		return signController;
	}
	
	public void closeServer() {
		userController.close();
		musicController.close();
	}
}
