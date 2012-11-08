package heejin.server.controller;

import heejin.server.model.Music;
import heejin.server.service.MusicService;
import heejin.server.service.ServiceManager;

import java.util.List;

public class MusicController {

	MusicService musicService = ServiceManager.getMusicService();
	
	public List<Music> findMusic(String words) {
		Music condition = new Music();
		condition.setArtist(words);
		condition.setTitle(words);
		
		return musicService.findMusic(condition);
	}
	
	public void close() {
		musicService.close();
	}
	
}
