package BinaryTree;

public class Main {
    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree();

        bt.root = new BinaryTree.Node(3);
        bt.root.right = new BinaryTree.Node(5);
        bt.root.right.left = new BinaryTree.Node(6);
        bt.root.right.right = new BinaryTree.Node(7);
        String result = bt.inorder(bt.root);
        System.out.println(result);
    }
}
