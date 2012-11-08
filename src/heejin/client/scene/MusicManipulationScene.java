package heejin.client.scene;

import heejin.client.Application;
import heejin.server.model.Music;
import heejin.server.model.User;

public class MusicManipulationScene extends AbstractScene {

	private User user;
	private Music music;
	
	public MusicManipulationScene(User user, Music music) {
		this.user = user;
		this.music = music;
	}
	
	@Override
	public void start() {
		System.out.println("- 음악 구입");
	}

	@Override
	public void resume() {
		System.out.println(music.getTitle());
		
		System.out.println(">> 1. 구입 2. 취소");
		int select = Application.getScanner().nextInt();
		
		switch(select) {
		case 1: // 구입
			boolean bought = getServer().getUserController().buyMusic(user, music);
			if(bought) {
				System.out.println("구입 성공.");
			} else {
				System.out.println("구입 실패.");
			}
			break;
		case 2: // 취소
		}
		
		close();
	}

}
