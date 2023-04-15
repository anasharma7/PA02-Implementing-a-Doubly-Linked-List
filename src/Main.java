package src;

public class Main {
    public static void main(String[] args) {
        // Create some albums
        Album album1 = new Album(1, new String[]{"Artist1", "Artist2"}, "Album Title 1", 10);
        Album album2 = new Album(2, new String[]{"Artist3", "Artist4"}, "Album Title 2", 8);
        Album album3 = new Album(3, new String[]{"Artist5", "Artist6"}, "Album Title 3", 12);

        // Create a binary search tree of albums
        BST<Album> albumTree = new BST<Album>();
        albumTree.insert(album1);
        albumTree.insert(album2);
        albumTree.insert(album3);

        // Print the album tree
        System.out.println("Album Tree:");
        albumTree.print();

        // Delete album2 from the tree and print the updated tree
        albumTree.delete(album2);
        System.out.println("\nAlbum Tree after deleting Album 2:");
        albumTree.print();

        // Check if album1 and album3 are in the tree
        System.out.println("\nContains Album 1: " + albumTree.contains(album1));
        System.out.println("Contains Album 3: " + albumTree.contains(album3));
        System.out.println("Contains Album 2: " + albumTree.contains(album2)); // Should print false

        // Try to delete album2 again (should throw IllegalArgumentException)
        try {
            albumTree.delete(album2);
        } catch (IllegalArgumentException e) {
            System.out.println("\nTried to delete Album 2 again, got exception: " + e.getMessage());
        }
// Rebalance the tree and print the updated tree
        albumTree.rebalance();
        System.out.println("\nAlbum Tree after rebalancing:");
        System.out.println(albumTree.toString());

        // Partition the tree and print the updated tree
        Album data = new Album(4, new String[]{"Artist7", "Artist8"}, "Album Title 4", 15);
        albumTree.partition(data);
        System.out.println("\nAlbum Tree after partitioning:");
        System.out.println(albumTree.toString());




    }
}