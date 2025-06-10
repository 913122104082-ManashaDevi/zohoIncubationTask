package singlyLinkedListLRU;
import java.util.*;

class LRUCache {
    private class Node {
        char key;
        String value;
        Node next;
        Node(char key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Character, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public String get(char key) {
        if (!map.containsKey(key)) return null;
        Node node = map.get(key);
        if (node != head) moveToHead(key);
        return node.value;
    }

    public void put(char key, String value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            if (node != head) moveToHead(key);
            return;
        }

        Node newNode = new Node(key, value);
        if (map.size() == capacity) removeTail();
        insertAtHead(newNode);
        map.put(key, newNode);
    }

    private void moveToHead(char key) {
        if (head == null || head.key == key) return;
        Node prev = null, curr = head;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null || prev == null) return;
        prev.next = curr.next;
        if (curr == tail) tail = prev;
        curr.next = head;
        head = curr;
    }

    private void insertAtHead(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    private void removeTail() {
        if (tail == null) return;
        Node prev = null, curr = head;
        while (curr != null && curr != tail) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) return;
        map.remove(tail.key);
        if (prev == null) {
            head = tail = null;
        } else {
            prev.next = null;
            tail = prev;
        }
    }

    public void display() {
        Node curr = head;
        System.out.println("Cache:");
        while (curr != null) {
            System.out.println("[" + curr.key + "=" + curr.value + "]");
            curr = curr.next;
        }
        System.out.println();
    }
}
