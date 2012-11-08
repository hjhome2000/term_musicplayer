package heejin.server.model;

public class User {

	private String md5hash;
	private String userName;
	private int cash;
	private Playlist playlist;
	
	public User(String userName, String md5hash) {
		this.userName = userName;
		this.md5hash = md5hash;
		this.playlist = new Playlist();
	}
	
	public String getHash() {
		return md5hash;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public int getCash() {
		return cash;
	}
	
	public void setCash(int cash) {
		this.cash = cash;
	}
	
	public Playlist getPlaylist() {
		return playlist;
	}

	@Override
	public int hashCode() {
		return md5hash.hashCode();
	}
	
}
