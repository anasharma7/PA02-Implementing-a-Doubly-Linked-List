package src;
import java.util.Random;


public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void append(Album data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    public int getCount() {
        return size;
    }

    public void insert(int location, Album data) {
        if (location < 0 || location > size) {
            throw new IllegalArgumentException("Location is out of bounds");
        }
        Node newNode = new Node(data);
        if (location == 0) {
            newNode.setNext(head);
            if (head != null) {
                head.setPrev(newNode);
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (location == size) {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        } else {
            Node curr = head;
            for (int i = 0; i < location - 1; i++) {
                curr = curr.getNext();
            }
            newNode.setNext(curr.getNext());
            newNode.setPrev(curr);
            curr.getNext().setPrev(newNode);
            curr.setNext(newNode);
        }
        size++;
    }

    public Album delete(int location) {
        if (location < 0 || location >= size) {
            throw new IllegalArgumentException("Location is out of bounds");
        }
        if (location == 0) {
            if (head == tail) {
                tail = null;
            }
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            }
        } else if (location == size - 1) {
            tail = tail.getPrev();
            tail.setNext(null);
        } else {
            Node curr = head;
            for (int i = 0; i < location; i++) {
                curr = curr.getNext();
            }
            curr.getPrev().setNext(curr.getNext());
            curr.getNext().setPrev(curr.getPrev());
        }
        size--;
        return null;
    }

    public int getIndex(Album data) {
        Node curr = head;
        for (int i = 0; i < size; i++) {
            if (curr.getData().equals(data)) {
                return i;
            }
            curr = curr.getNext();
        }
        return -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.getData().toString());
            if (curr.getNext() != null) {
                sb.append("->");
            }
            curr = curr.getNext();
        }
        sb.append("NULL");
        return sb.toString();
    }

    public Node shuffle() {
        Random rand = new Random();
        int count = getCount();
        Node[] arr = new Node[count];
        Node cur = head;
        for (int i = 0; i < count; i++) {
            arr[i] = cur;
            cur = cur.getNext();
        }
        for (int i = 0; i < count; i++) {
            int j = rand.nextInt(count);
            Node temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        head = arr[0];
        cur = head;
        for (int i = 1; i < count; i++) {
            cur.setNext(arr[i]);
            arr[i].setPrev(cur);
            cur = cur.getNext();
        }
        cur.setNext(null);
        tail = cur;
        return head;
    }
}