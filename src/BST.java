package src;

public class BST<A extends Comparable<A>> {

    private Node<A> root;

    public void print() {
        print(root);
    }

    private void print(Node<A> node) {
        if (node != null) {
            print(node.left);
            System.out.print(node.data + " ");
            print(node.right);
        }
    }

    private static class Node<A> {
        private A data;
        private Node<A> left;
        private Node<A> right;

        public Node(A data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public BST() {
        root = null;
    }

    public void insert(A data) {
        root = insert(root, data);
    }

    private Node<A> insert(Node<A> node, A data) {
        if (node == null) {
            return new Node<A>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    public boolean contains(A data) {
        return contains(root, data);
    }

    private boolean contains(Node<A> node, A data) {
        if (node == null) {
            return false;
        }

        if (data.compareTo(node.data) == 0) {
            return true;
        } else if (data.compareTo(node.data) < 0) {
            return contains(node.left, data);
        } else {
            return contains(node.right, data);
        }
    }

    public void delete(A data) {
        root = delete(root, data);
    }

    private Node<A> delete(Node<A> node, A data) {
        if (node == null) {
            throw new IllegalArgumentException("Data not found");
        }

        if (data.compareTo(node.data) < 0) {
            node.left = delete(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = delete(node.right, data);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            Node<A> minNode = findMin(node.right);
            node.data = minNode.data;
            node.right = delete(node.right, minNode.data);
        }

        return node;
    }

    private Node<A> findMin(Node<A> node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}
