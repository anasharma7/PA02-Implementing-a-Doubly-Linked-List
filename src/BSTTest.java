package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;

public class BSTTest {

    private BST<Integer> bst;

    @BeforeEach
    public void setUp() {
        bst = new BST<Integer>();
    }

    @Test
    public void testInsert() {
        bst.insert(4);
        bst.insert(2);
        bst.insert(6);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);

        assertEquals("4, 2, 1, N, N, 3, N, N, 6, 5, N, N, 7, N, N", bst.toString());
    }

    @Test
    public void testContains() {
        bst.insert(4);
        bst.insert(2);
        bst.insert(6);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);

        assertTrue(bst.contains(4));
        assertTrue(bst.contains(2));
        assertTrue(bst.contains(6));
        assertTrue(bst.contains(1));
        assertTrue(bst.contains(3));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(7));
        assertFalse(bst.contains(0));
        assertFalse(bst.contains(8));
    }

    @Test
    public void testDelete() {
        bst.insert(4);
        bst.insert(2);
        bst.insert(6);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);

        bst.delete(4);

        assertEquals("5, 2, 1, N, N, 3, N, N, 6, N, N, 7, N, N", bst.toString());
    }

    @Test
    public void testRebalance() {
        bst.insert(4);
        bst.insert(2);
        bst.insert(6);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);


        assertEquals("4, 2, 1, N, N, 3, N, N, 6, 5, N, N, 7, N, N", bst.toString());
        bst.rebalance();
        assertEquals("4, 2, 1, N, N, 3, N, N, 6, 5, N, N, 7, N, N", bst.toString());

    }

    @Test
    public void testPartition() {
        bst.insert(4);
        bst.insert(2);
        bst.insert(6);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);

        ArrayList<Integer> partitioned = bst.partition(4);
        assertEquals(4, partitioned.size());
        assertTrue(partitioned.contains(4));
        assertTrue(partitioned.contains(5));
        assertTrue(partitioned.contains(6));
        assertTrue(partitioned.contains(7));
    }
}
