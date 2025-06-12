package HeapPackage;

public class Main {
    public static void main(String args[]) {
        int arr[] = {11, 12, 13, 35, 21, 18, 25, 17};
        Node root = construct(arr);// max
        System.out.println(root.inorder(root));

    }

    public static Node construct(int arr[]) {
        Node root = null;
        for (int num : arr)
            root = addElementInHeap(num, root);
        return root;
    }

    private static Node addElementInHeap(int num, Node root) {
        Node current = new Node(num);
        if (root == null)
            return current;

        if (num > root.value) {
            current.left = root;
            root = current;
        } else {
            if (root.left == null)
                root.left = current;
            else if (root.right == null)
                root.right = current;


        }
        return root;
    }

        private static void heapify(Node root) {
            if (root == null) return;

            Node largest = root;

            if (root.left != null && root.left.value > largest.value) {
                largest = root.left;
            }

            if (root.right != null && root.right.value > largest.value) {
                largest = root.right;
            }

            if (largest != root) {
                int temp = root.value;
                root.value = largest.value;
                largest.value = temp;

                heapify(largest);
            }
        }
    }



