import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        }
        if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        return current;

    }

    // We are going to call this from the main method
    // Returns false if not found, if found returns true
    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    public void add(int value) {
        // Modifies root
        root = addRecursive(root, value);
    }

    private BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        return bt;
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            // removes a node the LinkedList nodes
            Node node = nodes.remove();

            System.out.println(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }

        }
    }

    public static void main(String[] args) {
        // creates a new root initializes to null

        /*
         * The following is the tree after the above statement
         * 
         * 1 / \ null null
         */
        System.out.println("Hello world");
        BinaryTree a = new BinaryTree();
        a = a.createBinaryTree();
        a.traverseInOrder(a.root);
        a.traversePreOrder(a.root);
        a.traversePostOrder(a.root);

    }

    public Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (current.value == value) {
            // If node has no children
            if (current.left == null && current.right == null) {
                return null;
            }
            // Case 2: Node only has 1 child
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            // Case 3: Node has 2 children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    // Depth first search in-order traversal
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.printf("%d ", node.value);
            traverseInOrder(node.right);
        }
    }

    // Visits the root node, then the left subtree, the the right subtree
    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.printf("%d ", node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.printf("%d ", node.value);
        }
    }

    @Test
    public void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() {
        BinaryTree bt = createBinaryTree();
        assertTrue(bt.containsNode(6));
        assertTrue(bt.containsNode(4));
        assertFalse(bt.containsNode(1));
    }

    @Test
    public void givenABinaryTree_WhenDeletingElements_ThenTreeDoesNotContainThoseElements() {
        BinaryTree bt = createBinaryTree();

        assertTrue(bt.containsNode(9));
        bt.delete(9);
        assertFalse(bt.containsNode(9));
        traverseInOrder(root);
    }
}
