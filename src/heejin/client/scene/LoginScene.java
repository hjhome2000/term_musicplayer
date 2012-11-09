package heejin.client.scene;

import heejin.client.Application;
import heejin.server.model.User;

public class LoginScene extends AbstractScene {

	@Override
	public void start() {
		System.out.println("- Login");
	}

	@Override
	public void resume() {

		System.out.println(">> 1. Create User 2. Sign in");
		
		int select = Application.getScanner().nextInt();
		boolean loginSuccess = false;
		User user = null;
		
		switch(select) {
		case 1: // create user
			System.out.println("username");
			String username = Application.getScanner().next();
			System.out.println("passwd");
			String passwd = Application.getScanner().next();
			
			user = getServer().getUserController().createUser(username, passwd);
			if(user != null)
				loginSuccess = true;
			
			break;
		case 2: // sign in
		default:
			System.out.println("username");
			username = Application.getScanner().next();
			System.out.println("passwd");
			passwd = Application.getScanner().next();
			
			user = getServer().getSignController().login(username, passwd);
			
			loginSuccess = (user != null);
			
			break;
		}
		
		if(loginSuccess) {
			LobbyScene lobbyScene = new LobbyScene(user);
			Application.pushScene(lobbyScene);
		} else {
			// failed
		}

		close();
	}

}
