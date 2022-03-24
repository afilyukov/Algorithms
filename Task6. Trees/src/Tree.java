public class Tree {
    private TreeNode root;

    public void insert(int value) {
        TreeNode node = new TreeNode(value);
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while (true) {
                parent = current;
                if (value < current.value) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }

                }
            }
        }
    }

    public TreeNode getNode(int key) {
        TreeNode current = root;
        while (current.value != key) {
            if (key < current.value)
                current = current.left;
            else
                current = current.right;

            if (current == null)
                return null;
        }
        return current;
    }

    private void inOrderTravers(TreeNode root) {
        if (root != null) {
            inOrderTravers(root.left);
            System.out.println(root);
            inOrderTravers(root.right);
        }
    }

    private int lh = 0;
    private int rh = 0;

    private void leftHeight(TreeNode root) {
        if (root != null) {
            leftHeight(root.left);
            lh = lh + 1;
        }
    }

    private void rightHeight(TreeNode root) {
        if (root != null) {
            rightHeight(root.right);
            rh = rh + 1;
        }
    }

    public boolean balance() {
        //leftHeight(root);
        //rightHeight(root);
        //int res = lh - rh;
        //lh = rh = 0;
        //return res <= 1;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public boolean isBalanced(TreeNode node) {
        return (node == null) ||
                isBalanced(node.left) &&
                        isBalanced(node.right) &&
                        Math.abs(height(node.left) - height(node.right)) <= 1;
    }

    private int height(TreeNode node) {
        return node == null ? 0 : 1 + Math.max(height(node.left), height(node.right));
    }

    public void displayTreeToConsole() {
        inOrderTravers(root);
    }

    public TreeNode min() {
        TreeNode current = root;
        TreeNode last = null;
        while (current != null) {
            last = current;
            current = current.left;
        }
        return last;
    }

    public boolean delete(int id) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        // searching for node
        while (current.value != id) {
            parent = current;
            if (id < current.value) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
            if (current == null)
                return false;
        }

        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
            // if only one child exists
        } else if (current.right == null) {
            if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
        } else if (current.left == null) {
            if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;
            // if both children exist
        } else {
            TreeNode successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.left = successor;
            else
                parent.right = successor;
            successor.left = current.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode sParent = node;
        TreeNode s = node;
        TreeNode current = node.right;
        while (current != null) {
            sParent = s;
            s = current;
            current = current.left;
        }
        if (s != node.right) {
            sParent.left = s.right;
            s.right = node.right;
        }
        return s;
    }
}