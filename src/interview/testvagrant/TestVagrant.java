package interview.testvagrant;

import java.util.Arrays;

public class TestVagrant {
	
	public static void main(String[] args) {
		
	}
}
class Customer{
	String customerName = null;
	Playlist pl = new Playlist(3);
}

class Playlist {
	private String songs[];

	public Playlist(int countListSize) {
		this.songs = new String[countListSize];
	} 
	
	public void addSong(String song) {
		// if song is already there in the list
		if(Arrays.deepToString(songs).contains(song)) {
			boolean flag = false;
			for (int i = 0; i < songs.length; i++) {
				// add song to last when last index is reached in iteration
				if((songs[i] != null && !(songs[i+1] == null) && songs[i].equals(song)) || flag) {
					songs[i] = songs[i+1];
					songs[i+1] = song;
					if(!((i+1)<songs.length)) {
						songs[i+1] = song;
						break;
					}
					flag = true;
				}
			}
		}
		
		//If list is full of songs
		else if(songs[songs.length-1] != null) {
			for (int i = 0; i < songs.length; i++) {
				// add song to last when last index is reached in iteration
				if(i == songs.length-1) {
					songs[i] = song;
				} 
				//copy previous song to current index which will remove the least played song
				else {
					songs[i] = songs[i+1];
				}
			}
		} 
		
		//If list does not have N number of last played song
		else {
			for (int i = 0; i < songs.length; i++) {
				if(songs[i] == null) {
					songs[i] = song;
				}
			}
		}
	}
}