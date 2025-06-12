public class MaxHeapArray {

        private int[] heap;
        private int size;
        private int capacity;

        public MaxHeapArray() {
            capacity = 10;
            heap = new int[capacity];
            size = 0;
        }

        public void put(int value) {
            ensureCapacity();

            heap[size] = value;
            bubbleUp(size);
            size++;
        }

        private void bubbleUp(int index) {
            while (index > 0 && heap[index] > heap[parent(index)]) {
                swap(index, parent(index));
                index = parent(index);
            }
        }

        private void ensureCapacity() {
            if (size == capacity) {
                capacity *= 2;
                int[] newHeap = new int[capacity];
                System.arraycopy(heap, 0, newHeap, 0, size);
                heap = newHeap;
            }
        }

        private int parent(int index) {
            return (index - 1) / 2;
        }

        private int leftChild(int index) {
            return 2 * index + 1;
        }

        private int rightChild(int index) {
            return 2 * index + 2;
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        // Tree Traversals using array index
        public void inOrder() {
            inOrderTraversal(0);
            System.out.println();
        }

        private void inOrderTraversal(int index) {
            if (index >= size) return;
            inOrderTraversal(leftChild(index));
            System.out.print(heap[index] + " ");
            inOrderTraversal(rightChild(index));
        }

        public void preOrder() {
            preOrderTraversal(0);
            System.out.println();
        }

        private void preOrderTraversal(int index) {
            if (index >= size) return;
            System.out.print(heap[index] + " ");
            preOrderTraversal(leftChild(index));
            preOrderTraversal(rightChild(index));
        }

        public void postOrder() {
            postOrderTraversal(0);
            System.out.println();
        }

        private void postOrderTraversal(int index) {
            if (index >= size) return;
            postOrderTraversal(leftChild(index));
            postOrderTraversal(rightChild(index));
            System.out.print(heap[index] + " ");
        }

        public static void main(String[] args) {
            MaxHeapArray heap = new MaxHeapArray();

            heap.put(10);
            heap.put(20);
            heap.put(5);
            heap.put(30);
            heap.put(15);

            System.out.println("In-Order Traversal:");
            heap.inOrder();

            System.out.println("Pre-Order Traversal:");
            heap.preOrder();

            System.out.println("Post-Order Traversal:");
            heap.postOrder();
        }
    }


