
package binarysearchtreebst;

/**
 * Represents a node in the Binary Search Tree (BST).
 */
class TreeNode {
    String word;
    TreeNode left, right;

    public TreeNode(String word) {
        this.word = word;
        this.left = this.right = null;
    }
}
