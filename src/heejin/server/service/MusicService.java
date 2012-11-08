package heejin.server.service;

import heejin.server.model.Music;

import java.util.List;

public interface MusicService {
	
	public List<Music> findMusic(Music condition);
	public void close();
	public Music getMusic(String hash);
	
}
