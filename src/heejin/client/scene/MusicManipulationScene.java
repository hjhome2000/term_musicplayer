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
		System.out.println("- Buy Music");
	}

	@Override
	public void resume() {
		System.out.println(music.getTitle());
		
		System.out.println(">> 1. Buy 2. Cancel");
		int select = Application.getScanner().nextInt();
		
		switch(select) {
		case 1: // Buy
			boolean bought = getServer().getUserController().buyMusic(user, music);
			if(bought) {
				System.out.println("Success.");
			} else {
				System.out.println("Failed to buy (not enough cash).");
			}
			break;
		case 2: // 취소
		}
		
		close();
	}

}
