package heejin.client.scene;

import heejin.client.Application;
import heejin.client.presentation.MusicListPresentation;
import heejin.server.model.Music;
import heejin.server.model.User;

import java.util.List;

public class SearchMusicScene extends AbstractScene {

	private User user;
	
	public SearchMusicScene(User user) {
		this.user = user;
	}
	
	@Override
	public void start() {
		System.out.println("- 음악 검색");
	}

	@Override
	public void resume() {
		System.out.println(">> 제목이나 가수 명을 적으세요.");
		
		String subject = Application.getScanner().next();
		List<Music> result = getServer().getMusicController().findMusic(subject);
		
		if(result.size() > 0) {
			Music selectedMusic = new MusicListPresentation().selectMusic(result);
			
			MusicManipulationScene musicScene = new MusicManipulationScene(user, selectedMusic);
			Application.replaceTopScene(musicScene);
		} else {
			// no
			System.out.println("* 결과 없음");
		}
		
		close();
	}

}
