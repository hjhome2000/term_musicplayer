package heejin.server.service;

import heejin.server.model.Music;
import heejin.server.model.Playlist;
import heejin.server.model.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;

public class UserServiceImpl implements UserService {

	private HashMap<String, User> users;
	
	public UserServiceImpl() {
		users = new HashMap<String, User>();
		load();
	}
	
	@Override
	public void addUser(User user) {
		users.put(user.getUserName(), user);
	}

	@Override
	public void removeUser(User user) {
		boolean validUser = users.containsKey(user.getUserName());
		
		if(validUser)
			users.remove(user.getUserName());
	}

	@Override
	public User getUser(String userName) {
		return users.get(userName);
	}

	@Override
	public void updatePlaylist(User user, Playlist playlist) {
	}

	@Override
	public Playlist getPlaylist(User user) {
		return user.getPlaylist();
	}

	@Override
	public void chargeCash(User user, int chargeAmount) {
		User original = users.get(user.getUserName());
		
		original.setCash(original.getCash() + chargeAmount);
	}

	@Override
	public boolean buyMusic(User user, Music music) {
		boolean success = false;
		boolean implicitlyNew = !user.getPlaylist().toMusics().contains(music);
		
		if(user.getCash() >= music.getPrice() && implicitlyNew) {
			user.getPlaylist().addMusic(music);
			user.setCash(user.getCash() - music.getPrice());
			
			success = true;
		}
		
		return success;
	}

	private String workDir = System.getProperty("user.dir");
	private void load() {
		File file = new File(workDir + "./users.txt");
		
		if(!file.exists()) return;
		
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			while(true) {
				String line = reader.readLine();
				if(line == null) break;
				if(line.trim().length() == 0) break;
				
				String[] components = line.split("&");
				String userName = components[0];
				String hash = components[1];
				int cash = Integer.parseInt(components[2]);
				User newUser = new User(userName, hash);
				newUser.setCash(cash);
				
				loadPlaylist(newUser);
				
				users.put(userName, newUser);
			}
			
			reader.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadPlaylist(User user) {
		File usersDir = new File(workDir + "./users");
		if(!usersDir.isDirectory())
			return;
		
		File playlistFile = new File(usersDir, user.getUserName() + ".txt");
		
		if(!playlistFile.exists())
			return;
		
		try {
			FileInputStream fis = new FileInputStream(playlistFile);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			while(true) {
				String line = reader.readLine();
				if(line == null) break;
				if(line.trim().length() == 0) break;
				
				String hash = line.trim();
				Music music = ServiceManager.getMusicService().getMusic(hash);
				
				if(music != null)
					user.getPlaylist().addMusic(music);
			}
			
			reader.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void savePlaylist(User user) {
		File usersDir = new File(workDir + "./users");
		if(!usersDir.isDirectory())
			usersDir.mkdir();
		
		File playlistFile = new File(usersDir, user.getUserName() + ".txt");
		
		if(playlistFile.exists())
			playlistFile.delete();
		
		try {
			FileOutputStream fos = new FileOutputStream(playlistFile);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
			
			Playlist playlist = user.getPlaylist();
			List<Music> musics = playlist.toMusics();
			
			for(Music music : musics) {
				writer.write(music.hashCode() + "\n");
			}
			
			writer.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void close() {
		File file = new File(workDir + "./users.txt");
		
		if(file.exists())
			file.delete();
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

			User[] users = this.users.values().toArray(new User[0]);
			int len = users.length;
			for(int i = 0; i < len; i++) {
				User user = users[i];
				writer.write(user.getUserName() + "&" + user.getHash() + "&" + user.getCash() + "\n");
				
				savePlaylist(user);
			}
			
			writer.flush();
			writer.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
