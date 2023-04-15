package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void testAppendAndGetCount() {
        DoublyLinkedList list = new DoublyLinkedList();
        Album album1 = new Album(1, new String[]{"Artist1"}, "Album1", 10);
        Album album2 = new Album(2, new String[]{"Artist2"}, "Album2", 12);
        list.append(album1);
        assertEquals(1, list.getCount());
        list.append(album2);
        assertEquals(2, list.getCount());
    }

    @Test
    void testInsert() {
        DoublyLinkedList list = new DoublyLinkedList();
        Album album1 = new Album(1, new String[]{"Artist1"}, "Album1", 10);
        Album album2 = new Album(2, new String[]{"Artist2"}, "Album2", 12);
        Album album3 = new Album(3, new String[]{"Artist3"}, "Album3", 8);
        list.append(album1);
        list.append(album3);
        list.insert(1, album2);
        assertEquals(album1, list.delete(0));
        assertEquals(album2, list.delete(0));
        assertEquals(album3, list.delete(0));
    }

    @Test
    void testDelete() {
        DoublyLinkedList list = new DoublyLinkedList();
        Album album1 = new Album(1, new String[]{"Artist1"}, "Album1", 10);
        Album album2 = new Album(2, new String[]{"Artist2"}, "Album2", 12);
        Album album3 = new Album(3, new String[]{"Artist3"}, "Album3", 8);
        list.append(album1);
        list.append(album2);
        list.append(album3);
        assertEquals(album3, list.delete(2));
        assertEquals(album1, list.delete(0));
        assertEquals(album2, list.delete(0));
    }

    @Test
    void testGetIndex() {
        DoublyLinkedList list = new DoublyLinkedList();
        Album album1 = new Album(1, new String[]{"Artist1"}, "Album1", 10);
        Album album2 = new Album(2, new String[]{"Artist2"}, "Album2", 12);
        Album album3 = new Album(3, new String[]{"Artist3"}, "Album3", 8);
        list.append(album1);
        list.append(album2);
        list.append(album3);
        assertEquals(1, list.getIndex(album2));
        assertEquals(-1, list.getIndex(new Album(4, new String[]{"Artist4"}, "Album4", 14)));
    }

    @Test
    void testShuffle() {
        DoublyLinkedList list = new DoublyLinkedList();
        Album album1 = new Album(1, new String[]{"Artist1"}, "Album1", 10);
        Album album2 = new Album(2, new String[]{"Artist2"}, "Album2", 12);
        Album album3 = new Album(3, new String[]{"Artist3"}, "Album3", 8);
        list.append(album1);
        list.append(album2);
        list.append(album3);
        Node shuffledHead = list.shuffle();
        assertNotEquals(album1, shuffledHead.getData());
        assertNotEquals(album2, shuffledHead.getNext().getData());
        assertNotEquals(album3, shuffledHead.getNext().getNext().getData());
    }

    @Test
    void testPartition() {
        DoublyLinkedList list = new DoublyLinkedList();
        Album album1 = new Album(1, new String[]{"Artist1"}, "Album1", 10);
        Album album2 = new Album(2, new String[]{"Artist2"}, "Album2", 12);
        Album album3 = new Album(3, new String[]{"Artist3"}, "Album3", 8);
        Album album4 = new Album(4, new String[]{"Artist4"}, "Album4", 15);
        Album album5 = new Album(5, new String[]{"Artist5"}, "Album5", 20);
        Album album6 = new Album(6, new String[]{"Artist6"}, "Album6", 18);
        list.append(album1);
        list.append(album2);
        list.append(album3);
        list.append(album4);
        list.append(album5);
      //  list.append(album6);
        DoublyLinkedList list2 = new DoublyLinkedList();
        list2 = list.partition(album6);
        System.out.println(list2.toString());
        }
    }


