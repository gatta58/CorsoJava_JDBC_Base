package corso.lez13.spotifoo;

import java.util.ArrayList;

public class Album {
	
	private int id;
	private String title;
	private String data_rilascio;
	private double prezzo;
	private int nro_brani;
	private Producer producer;
	private ArrayList<Song> songs = new ArrayList<Song>();
	
	public Album() {
	}
	
	
}
