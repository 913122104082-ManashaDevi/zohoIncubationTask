package basic;
import java.util.*;

    public class Stack {

        private int maxSize;
        private int[] stackArray;
        private int top;

        // Constructor to initialize stack
        public Stack(int size) {
            maxSize = size;
            stackArray = new int[maxSize];
            top = -1;
        }

        // 1. Push operation
        public void push(int value) {
            if (top == maxSize - 1) {
                System.out.println("Stack Overflow! Cannot push " + value);
                return;
            }
            stackArray[++top] = value;
            System.out.println(value + " pushed to stack.");
        }

        // 2. Pop operation
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow! Cannot pop.");
                return -1;
            }
            int popped = stackArray[top--];
            System.out.println(popped + " popped from stack.");
            return popped;
        }

        // 3. Peek operation
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return -1;
            }
            return stackArray[top];
        }

        // 4. Check if stack is empty
        public boolean isEmpty() {
            return top == -1;
        }

        // 5. Size of the stack
        public int size() {
            return top + 1;
        }

        // 6. Search operation (1-based index from top)
        public int search(int value) {
            for (int i = top; i >= 0; i--) {
                if (stackArray[i] == value) {
                    return top - i + 1; // 1-based position from top
                }
            }
            return -1; // Not found
        }

        // 7. Display the entire stack
        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return;
            }
            System.out.println("Stack elements (top to bottom):");
            for (int i = top; i >= 0; i--) {
                System.out.println(stackArray[i]);
            }
        }

        public static void main(String[] args) {
            Stack stack = new Stack(5);

            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.display();

            System.out.println("Peek: " + stack.peek());
            System.out.println("Size: " + stack.size());
            System.out.println("Search 20: Position = " + stack.search(20));

            stack.pop();
            stack.display();

            System.out.println("Is Empty? " + stack.isEmpty());
        }
    }


