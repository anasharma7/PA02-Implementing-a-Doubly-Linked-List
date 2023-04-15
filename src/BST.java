package src;
import java.util.ArrayList;


public class BST<A extends Comparable<A>> {

    private Node<A> root;

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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int height = getHeight(root);
        printNode(sb, root, 0, height);
        return sb.toString();
    }

    private void printNode(StringBuilder sb, Node<A> node, int level, int height) {
        if (node == null) {
            sb.append("N");
            if (level < height) {
                sb.append(", ");
                printNode(sb, null, level + 1, height);
            }
            return;
        }

        sb.append(node.data.toString());

        if (level < height) {
            sb.append(", ");
            printNode(sb, node.left, level + 1, height);
            sb.append(", ");
            printNode(sb, node.right, level + 1, height);
        }
    }

    private int getHeight(Node<A> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public void print() {
        System.out.println(root);
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

    public void rebalance() {
        ArrayList<A> list = new ArrayList<A>();
        inOrder(root, list);
        if (!list.isEmpty()) {
            buildBalancedTree(list, 0, list.size() - 1);
        }
    }

    private void inOrder(Node<A> node, ArrayList<A> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.data);
        inOrder(node.right, list);
    }

    private Node<A> buildBalancedTree(ArrayList<A> list, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node<A> node = new Node<A>(list.get(mid));
        node.left = buildBalancedTree(list, start, mid - 1);
        node.right = buildBalancedTree(list, mid + 1, end);

        return node;
    }


    public ArrayList<A> partition(A data) {
        ArrayList<A> result = new ArrayList<A>();
        partition(root, data, result);
        return result;
        }

private void partition(Node<A> node, A data, ArrayList<A> result) {
    if (node == null) {
        return;
    }
    partition(node.left, data, result);
    if (node.data.compareTo(data) >= 0) {
        result.add(node.data);
        partition(node.right, data, result);
    }
}
}



