package BinaryTree;

class BinaryTree {
    static class Node
    {
        int value;
        Node left;
        Node right;
        Node(int val) {
            value = val;
            left = right = null;
        }
    }

    Node root;
    public String inorder(Node node)
    {
        if (node == null)
            return "-";
        String left = inorder(node.left);
        String right = inorder(node.right);
        return "(" + left + "," + node.value + "," + right + ")";

    }
}

