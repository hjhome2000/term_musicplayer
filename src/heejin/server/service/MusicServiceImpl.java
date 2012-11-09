package heejin.server.service;

import heejin.server.model.Music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MusicServiceImpl implements MusicService {

	private List<Music> musics;
	private HashMap<String, Music> musicMap;
	
	public MusicServiceImpl() {
		musics = new ArrayList<Music>();
		musicMap = new HashMap<String, Music>();
		
		load();
	}
	
	@Override
	public List<Music> findMusic(Music condition) {
		List<Music> result = new ArrayList<Music>();
		
		// Sequential Search
		for(Music music : musics) {
			boolean containsTitle = music.getTitle().contains(condition.getTitle());
			boolean containsArtist = music.getArtist().contains(condition.getArtist());
			
			if(containsTitle || containsArtist) {
				result.add(music);
			}
		}
		
		return result;
	}

	private String workDir = System.getProperty("user.dir");
	private void load() {
		File file = new File(workDir + "./musics.txt");
		
		if(!file.exists()) return;
		
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			while(true) {
				String line = reader.readLine();
				if(line == null) break;
				if(line.trim().length() == 0) break;
				
				String[] components = line.split("&");
				String artist = components[0];
				String title = components[1];
				int price = Integer.parseInt(components[2]);
				Music newMusic = new Music();
				
				newMusic.setArtist(artist);
				newMusic.setTitle(title);
				newMusic.setPrice(price);
				
				musics.add(newMusic);
				musicMap.put(newMusic.hashCode() + "", newMusic); // Save to Map also.
			}
			
			reader.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void close() {
		File file = new File(workDir + "./musics.txt");
		
		if(file.exists())
			file.delete();
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
			
			int len = musics.size();
			for(int i = 0; i < len; i++) {
				Music music = musics.get(i);
				writer.write(music.getArtist() + "&" + music.getTitle() + "&" + music.getPrice() + "\n");
			}
			
			writer.flush();
			writer.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Music getMusic(String hash) {
		return musicMap.get(hash);
	}

}
