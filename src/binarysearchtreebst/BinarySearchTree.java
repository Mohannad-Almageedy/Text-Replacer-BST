
package binarysearchtreebst;

/**
 * Implements a Binary Search Tree (BST) for storing words and allowing efficient lookup.
 */
class BinarySearchTree {
    private TreeNode root;

    /**
     * Inserts a word into the BST.
     * @param word The word to insert.
     */
    public void insert(String word) {
        root = insertRec(root, word);
    }

    private TreeNode insertRec(TreeNode root, String word) {
        if (root == null) {
            return new TreeNode(word);
        }
        if (word.compareTo(root.word) < 0) {
            root.left = insertRec(root.left, word);
        } else if (word.compareTo(root.word) > 0) {
            root.right = insertRec(root.right, word);
        }
        return root;
    }

    /**
     * Searches for a word in the BST.
     * @param word The word to search for.
     * @return True if found, otherwise false.
     */
    public boolean search(String word) {
        return searchRec(root, word);
    }

    private boolean searchRec(TreeNode root, String word) {
        if (root == null) {
            return false;
        }
        if (word.equals(root.word)) {
            return true;
        }
        return word.compareTo(root.word) < 0
                ? searchRec(root.left, word)
                : searchRec(root.right, word);
    }
}

