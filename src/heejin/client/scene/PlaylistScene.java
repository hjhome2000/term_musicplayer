package heejin.client.scene;

import heejin.client.presentation.MusicListPresentation;
import heejin.server.model.User;

public class PlaylistScene extends AbstractScene {

	private User user;
	
	public PlaylistScene(User user) {
		this.user = user;
	}
	
	@Override
	public void start() {
		System.out.println("- 내 재생 목록");
	}

	@Override
	public void resume() {
		new MusicListPresentation().show(user.getPlaylist().toMusics());
		
		close();
	}

}
