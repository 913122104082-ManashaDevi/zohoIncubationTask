import HeapPackage.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MaxHeap
{
    static class Node
    {
        int value;
        Node left, right, parent;
        Node(int value)
        {
            this.value = value;
            left=right=parent=null;
        }
        public String inorder(Node node) {
            if (node == null)
                return "null";
            String left = inorder(node.left)+"<--";
            String right = "-->"+inorder(node.right);
            return "(" + left  + node.value  + right + ")";
        }
    }

    private static Node root;
    public static void putNode(int value)
    {
        Node newNode = new Node(value);
        if (root == null)
        {
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            Node current = queue.poll();
            if (current.left == null) {
                current.left = newNode;
                newNode.parent = current;
                break;
            } else {
                queue.add(current.left);
            }
            if (current.right == null) {
                current.right = newNode;
                newNode.parent = current;
                break;
            } else {
                queue.add(current.right);
            }
        }

        bubbleUp(newNode);
    }

    private static void  bubbleUp(Node node) {
        while (node.parent != null && node.value > node.parent.value) {
            int temp = node.value;
            node.value = node.parent.value;
            node.parent.value = temp;
            node = node.parent;
        }
    }

    public static void main(String args[]) {
        MaxHeap heap = new MaxHeap();
        int arr[] = {11, 12, 13, 35, 21, 18, 25, 17};
        for (int num : arr)
             putNode(num);
       System.out.println(root.inorder(root));

    }

}
