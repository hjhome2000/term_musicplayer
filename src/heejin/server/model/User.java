package heejin.server.model;

public class User {

	private String md5hash;
	private String userName;
	
	public User(String userName, String md5hash) {
		this.userName = userName;
		this.md5hash = md5hash;
	}
	
	public String getHash() {
		return md5hash;
	}
	
	public String getUserName() {
		return userName;
	}
	
}
