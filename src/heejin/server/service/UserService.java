package heejin.server.service;

import heejin.server.model.Music;
import heejin.server.model.Playlist;
import heejin.server.model.User;

public interface UserService {
	
	public void addUser(User user);
	public void removeUser(User user);
	public User getUser(String userName);
	
	public void updatePlaylist(User user, Playlist playlist);
	public Playlist getPlaylist(User user);
	
	public void chargeCash(User user, int chargeAmount);
	public boolean buyMusic(User user, Music music);
	public void close();
	
}
