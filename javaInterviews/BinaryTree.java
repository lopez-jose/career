class BinaryTree {
    Node root;

    BinaryTree(int key) {
        root = new Node(key);
    }

    BinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        // creates a new root initializes to null
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        /*
         * The following is the tree after the above statement
         * 
         * 1 / \ null null
         */

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
    }
}
