package heejin.server.model;

import java.util.List;
import java.util.Vector;

public class Playlist {

	private List<Music> musics;
	
	public Playlist() {
		musics = new Vector<Music>();
	}
	
	public void addMusic(Music music) {
		musics.add(music);
	}
	
	public Music getMusic(int index) {
		return musics.get(index);
	}
	
	public void removeMusic(int index) {
		musics.remove(index);
	}
	
	public void reorderMusic(int from, int to) {
		Music src = musics.get(from);
		musics.remove(from);
		musics.add(to, src);
	}

	public List<Music> toMusics() {
		return musics;
	}
	
}
