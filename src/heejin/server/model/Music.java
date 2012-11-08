package heejin.server.model;

public class Music {

	private String artist;
	private String title;
	private String fileName;
	private int price;
	
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
	
	public int getPrice() {
		return price;
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

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		String hashString = artist + title + fileName + price;
		return hashString.hashCode();
	}
	
}
