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
		System.out.println("- 로비");
		System.out.println(user.getUserName() + " 로그인 성공");
		System.out.println("총 " + user.getCash() + " 충전");
	}

	@Override
	public void resume() {
		System.out.println(">> 1. 음악 검색 2. 내 재생목록 3. 충전 4. 종료");
		
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
		case 3: // 충전
			ChargeScene chargeScene = new ChargeScene(user);
			Application.pushScene(chargeScene);
			
			break;
		case 4:
			Application.closeApplication();
		}
		
		close();
	}

}
