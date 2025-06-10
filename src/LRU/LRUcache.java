package LRU;

import java.util.*;

class LRUCache {
    public final int capacity;
    private final Map<Character, Node> map;
    private final Node head, tail;
    class Node{
        char key;
        String value;
        Node prev, next;
        Node(char k, String v) {
            key = k;
            value = v;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(' ',null);
        tail = new Node(' ',null);
        head.next = tail;
        tail.prev = head;
    }

    public String get(char key) {
        if (!map.containsKey(key)) return null;
        Node node = map.get(key);
        remove(node);
        insertAtFront(node);
        return node.value;
    }

    public void put(char key, String value) {
        if (map.containsKey(key)) {
            Node node=map.get(key);
            node.value=value;
            remove(node);
            insertAtFront(node);
            return;
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insertAtFront(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    private void insertAtFront(Node node) {
        map.put(node.key, node);
        Node next= head.next;
        next.prev = node;
        node.next = next;
        node.prev = head;
        head.next= node;
    }


    public void display() {
        Node curr = head.next;
        System.out.print("Cache: "+"\n");
        while (curr != tail) {
            System.out.println("[" + curr.key + "=" + curr.value + "] ");
            curr = curr.next;
        }
        System.out.println();
    }
}
