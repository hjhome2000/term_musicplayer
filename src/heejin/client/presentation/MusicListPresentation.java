package heejin.client.presentation;

import heejin.client.Application;
import heejin.server.model.Music;

import java.util.List;

public class MusicListPresentation {
	
	public void show(List<Music> musics) {
		int len = musics.size();
		
		for(int i = 0; i < len; i++) {
			Music music = musics.get(i);
			System.out.println((i+1) + ". " + music.getArtist() + " - " + music.getTitle() + " :: " + music.getPrice());
		}
	}
	
	public Music selectMusic(List<Music> musics) {
		Music selectedMusic = null;
		
		show(musics);
		int which = Application.getScanner().nextInt();
		
		boolean found = (which > 0) && (which <= musics.size());
		if(found) {
			selectedMusic = musics.get(which - 1);
		}
		
		return selectedMusic;
	}
	
}
