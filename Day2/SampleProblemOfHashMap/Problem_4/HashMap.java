package Day2.SampleProblemOfHashMap.Problem_4;

import java.util.LinkedList;

class HashMap<K, V> {
    // Define the size of the hash table (prime number for better distribution)
    private static final int INITIAL_CAPACITY = 16;

    // Define the array to store the buckets (linked lists)
    private LinkedList<Node<K, V>>[] table;

    // Constructor to initialize the hash map
    public HashMap() {
        table = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>(); // Initialize each linked list
        }
    }

    // Inner class to represent a key-value pair (node)
    private static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Hash function to calculate index based on the key
    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // Insert or update a key-value pair in the hash map
    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = table[index];

        // Check if the key already exists in the bucket
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                // If key exists, update the value
                node.value = value;
                return;
            }
        }

        // If key does not exist, add a new node
        bucket.add(new Node<>(key, value));
    }

    // Retrieve the value associated with a key
    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = table[index];

        // Search for the key in the linked list
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        // Return null if key is not found
        return null;
    }

    // Delete a key-value pair by key
    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = table[index];

        // Iterate through the linked list to find the key
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node); // Remove the node
                return;
            }
        }
    }

    // Check if the hash map contains a key
    public boolean containsKey(K key) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = table[index];

        // Check if key is in the linked list
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    // Check if the hash map contains a value
    public boolean containsValue(V value) {
        for (LinkedList<Node<K, V>> bucket : table) {
            for (Node<K, V> node : bucket) {
                if (node.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Print all key-value pairs in the hash map (for debugging purposes)
    public void print() {
        for (int i = 0; i < table.length; i++) {
            LinkedList<Node<K, V>> bucket = table[i];
            if (!bucket.isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Node<K, V> node : bucket) {
                    System.out.print("[" + node.key + "=" + node.value + "] ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        // Test the HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Insert key-value pairs
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);

        // Retrieve values
        System.out.println("Value for 'Two': " + map.get("Two"));
        System.out.println("Value for 'Three': " + map.get("Three"));

        // Remove a key-value pair
        map.remove("Two");
        System.out.println("After removal, value for 'Two': " + map.get("Two"));

        // Check existence of a key
        System.out.println("Contains key 'One': " + map.containsKey("One"));
        System.out.println("Contains key 'Two': " + map.containsKey("Two"));

        // Print all key-value pairs
        map.print();
    }
}

