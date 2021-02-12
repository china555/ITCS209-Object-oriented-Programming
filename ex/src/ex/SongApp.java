package ex;

import java.util.ArrayList;

class Song{
	public String title;
	public double minutes;
	public Song(String title,double minute) {
		this.title = title;
		this.minutes = minute;
	}
}
class Playlist{
	public String name;
	public ArrayList<Song> listSongs = new ArrayList<Song>();
	public double duration;
	public Playlist(String name) {
		this.name = name;
	}
	public void addSong(Song song) {
		// TODO Auto-generated method stub
		listSongs.add(song);
		
	}
	public void addSongAtIndex(Song song, int i) {
		// TODO Auto-generated method stub
		listSongs.add(i,song);
		
	}
	public void showPlaylist() {
		// TODO Auto-generated method stub
		int i = 0;
		for(Song value: listSongs) {
		int d=seccal (value.minutes);
		System.out.println("["+i+"]"+value.title+", "+value.minutes+"("+(int)d+")");
		i++;
		}
	}
	public int seccal(double sec) {
		int intSec = (int) sec;
		double remainder  = (sec - intSec) * 100;
		double second = intSec * 60;
		int result = (int) Math.round(second + remainder) ;
		
		return result;
	}
	public void moveUp(int i) {
		// TODO Auto-generated method stub
		Song song = listSongs.get(i);
		removeSongByIndex(i);
		addSongAtIndex(song, i-1);
		
	}
	public void moveDown(int i) {
		// TODO Auto-generated method stub
		Song song = listSongs.get(i);
		removeSongByIndex(i);
		addSongAtIndex(song, i+1);

		
	}

	public void removeSongByTitle(String string) {
		// TODO Auto-generated method stub
		int i;
		for(i=0;i<this.listSongs.size();i++) {
			if(string == this.listSongs.get(i).title);
		}
		if(i<this.listSongs.size()) {
			System.out.println("Error: Couldn't add song at index 3\r\n" + 
					"Error: The title is not found\r\n" + 
					"Error: The index is invalid\r\n" + 
					"");
		}
		
	}
	public void removeSongByIndex(int i) {
		// TODO Auto-generated method stub
		listSongs.remove(i);
	
}
}
public class SongApp {
	public static void main(String[] args) {
		Playlist myPlaylist = new Playlist("My Favorite Songs Playlist");
		
		System.out.println("Welcome to SongAPP");
		System.out.println("\nAdd songs --------------------------");
		myPlaylist.addSong(new Song("Perfect", 4.21));
		myPlaylist.addSong(new Song("How long", 3.30));
		myPlaylist.addSongAtIndex(new Song("End Game", 4.11), 0);
		myPlaylist.addSongAtIndex(new Song("Anywhere", 3.35), 2);
		myPlaylist.showPlaylist();
	
		System.out.println("\nRearrange songs ---------------------");
		myPlaylist.moveUp(1);
		myPlaylist.moveDown(2);
		myPlaylist.showPlaylist();
		
		System.out.println("\nRemove songs -----------------------");
		myPlaylist.removeSongByTitle("End Game");
		myPlaylist.removeSongByIndex(2);
		myPlaylist.showPlaylist();
		
		System.out.println("\nCheck error ------------------------");
		myPlaylist.addSongAtIndex(new Song("Find you", 3.38), 3);
		myPlaylist.removeSongByTitle("Find you");
		myPlaylist.removeSongByIndex(3);
	}
	
}

