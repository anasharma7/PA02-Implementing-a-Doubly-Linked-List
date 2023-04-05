package src;

import java.util.LinkedList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // Create some albums
        Album album1 = new Album(1, new String[] {"Artist1", "Artist2"}, "Album Title 1", 10);
        Album album2 = new Album(2, new String[] {"Artist3", "Artist4"}, "Album Title 2", 8);
        Album album3 = new Album(3, new String[] {"Artist5", "Artist6"}, "Album Title 3", 12);

        // Create a linked list of albums
        LinkedList<Album> albumList = new LinkedList<>();
        albumList.add(album1);
        albumList.add(album2);
        albumList.add(album3);

        // Print the unsorted album list
        System.out.println("Unsorted Album List:");
        for (Album album : albumList) {
            System.out.println(album.toString());
        }

        // Sort the album list and print it again
        Collections.sort(albumList);
        System.out.println("\nSorted Album List:");
        for (Album album : albumList) {
            System.out.println(album.toString());
        }
    }
}
