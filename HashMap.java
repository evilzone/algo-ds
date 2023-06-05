package com.hashmap;

public class HashMap<K, V> {
    private static final int INIT_CAPACITY = 1 << 4; // inital size is 16
    private static final int MAX_CAPACITY = 1 << 30; // maximum capacity
    Entry[] entry;

    public HashMap() {
        entry = new Entry[INIT_CAPACITY];
    }

    public HashMap(int capacity) {
        int n = getSize(capacity);
        entry = new Entry[n];
    }

    public int getSize(int capacity) {
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAX_CAPACITY ? MAX_CAPACITY : n + 1);
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode() % entry.length;
        Entry walker = entry[hashCode];
        Entry prev = null;

        Entry node = new Entry(key, value);

        if(walker == null) {
            entry[hashCode] = node;
        } else {
            while(walker != null) {
                if(walker.key.equals(key)) {
                    walker.value = value;
                    return;
                }
                prev = walker;
                walker = walker.next;
            }
            prev.next = node;
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode() % entry.length;
        Entry walker = entry[hashCode];

        while(walker != null) {
            if(walker.key.equals(key)) {
                return (V) walker.value;
            }
            walker = walker.next;
        }
        return null;
    }

    class Entry<K, V> {
        K key;
        V value;
        Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        HashMap hashMap = new HashMap();
        hashMap.put(1, "hi");
        hashMap.put(2, "hello");
        hashMap.put(2, "jazzz");
        hashMap.put(4, "yellow");
        hashMap.put(3, "june");

        System.out.println(hashMap.get(2));
        System.out.println(hashMap.get(4));
        System.out.println(hashMap.get(6));
    }
}
