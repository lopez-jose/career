class BinaryTree {
    Node root;

    BinaryTree(int key) {
        root = new Node(key);
    }

    BinaryTree() {
        root = null;
    }

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

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public static void main(String[] args) {
        // creates a new root initializes to null
        BinaryTree tree = new BinaryTree();
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);

        /*
         * The following is the tree after the above statement
         * 
         * 1 / \ null null
         */

    }
}
