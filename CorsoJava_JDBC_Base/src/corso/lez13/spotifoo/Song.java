package corso.lez13.spotifoo;

public class Song {
	
	private int id;
	private String title;
	private double durata;
	private double prezzo;
	private int bitrate;
	
	public Song () {
	}

	public Song(String title, double durata, double prezzo, int bitrate) {
		this.title = title;
		this.durata = durata;
		this.prezzo = prezzo;
		this.bitrate = bitrate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDurata(double durata) {
		this.durata = durata;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public void setBitrate(int bitrate) {
		this.bitrate = bitrate;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public double getDurata() {
		return durata;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public int getBitrate() {
		return bitrate;
	}
	
	
	
	
	
	

}
