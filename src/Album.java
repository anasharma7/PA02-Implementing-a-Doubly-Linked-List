package src;

import java.util.Arrays;

public class Album implements Comparable<Album> {
    private int id;
    private String[] artists;
    private String title;
    private int numSongs;

    public Album(int id, String[] artists, String title, int numSongs) {
        this.id = id;
        this.artists = artists;
        this.title = title;
        this.numSongs = numSongs;
    }

    public int getId() {
        return id;
    }

    public String[] getArtists() {
        return artists;
    }

    public String getTitle() {
        return title;
    }

    public int getNumSongs() {
        return numSongs;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArtists(String[] artists) {
        this.artists = artists;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumSongs(int numSongs) {
        this.numSongs = numSongs;
    }

    @Override
    public String toString() {
        return String.format("ID: %d -- %d [%s]", id, numSongs, Arrays.toString(artists));
    }

    @Override
    public int compareTo(Album otherAlbum) {
        return Integer.compare(this.numSongs, otherAlbum.getNumSongs());
    }
}
