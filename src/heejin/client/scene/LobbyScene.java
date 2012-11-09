package heejin.client.scene;

import heejin.client.Application;
import heejin.server.model.User;

public class LobbyScene extends AbstractScene {

	private User user;
	
	public LobbyScene(User user) {
		this.user = user;
	}
	
	@Override
	public void start() {
		System.out.println("- Lobby");
		System.out.println(user.getUserName() + " Login Succeed");
		System.out.println("Total Cash is " + user.getCash());
	}

	@Override
	public void resume() {
		System.out.println(">> 1. Search Musics 2. My Playlist 3. Cash Charge 4. Exit");
		
		int select = Application.getScanner().nextInt();
		switch(select) {
		case 1:
			SearchMusicScene searchScene = new SearchMusicScene(user);
			Application.pushScene(searchScene);
			
			break;
		case 2:
			PlaylistScene playlistScene = new PlaylistScene(user);
			Application.pushScene(playlistScene);
			
			break;
		case 3: // Charge
			ChargeScene chargeScene = new ChargeScene(user);
			Application.pushScene(chargeScene);
			
			break;
		case 4:
			Application.closeApplication();
		}
		
		close();
	}

}
