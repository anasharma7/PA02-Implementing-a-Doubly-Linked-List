package src;

import java.util.LinkedList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // Create some albums
        Album album1 = new Album(1, new String[] {"Artist1", "Artist2"}, "Album Title 1", 10);
        Album album2 = new Album(2, new String[] {"Artist3", "Artist4"}, "Album Title 2", 8);
        Album album3 = new Album(3, new String[] {"Artist5", "Artist6"}, "Album Title 3", 12);

        // Create a doubly linked list of albums
        DoublyLinkedList albumList = new DoublyLinkedList();
        albumList.append(album1);
        albumList.append(album2);
        albumList.append(album3);

        // Print the unsorted album list
        System.out.println("Unsorted Album List:");
        System.out.println(albumList.toString());

        // Shuffle the album list and print it again
        albumList.shuffle();
        System.out.println("\nShuffled Album List:");
        System.out.println(albumList.toString());

        // Delete the album at index 0 and print the updated list
        System.out.println("\nAlbum List after deleting Index 0:");
        Album deletedAlbum = albumList.delete(0);
        System.out.println(albumList.toString());

        // Insert a new album at index 1 and print the updated list
        System.out.println("\nAlbum List after inserting new album at Index 1:");
        Album newAlbum = new Album(4, new String[] {"Artist7", "Artist8"}, "Album Title 4", 15);
        albumList.insert(1, newAlbum);
        System.out.println(albumList.toString());

        // Get the index of album3 and print it
        System.out.println("\nIndex of Album 3:");
        int album3Index = albumList.getIndex(album3);
        System.out.println(album3Index);


    }
}
