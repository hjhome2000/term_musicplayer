package heejin.server.model;

public class Music {

	private String artist;
	private String title;
	private String fileName;
	
	// getters
	public String getArtist() {
		return artist;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getFileName() {
		return fileName;
	}

	// setters
	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
