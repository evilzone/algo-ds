import java.util.HashMap;

public class MyHashMap<K, V> {

  public static final int INITIAL_SIZE = 1 << 4;
  public static final int MAXIMUM_CAPACITY = 1 << 30;

  public  Entry[] hashTable;

  public MyHashMap() {
    hashTable = new Entry[INITIAL_SIZE];
  }

  public MyHashMap(int capacity) {
    capacity = tableSize(capacity);
    hashTable = new Entry[capacity];
  }

  public int tableSize(int capacity) {
    int n = capacity - 1;

    n |= n >>> 1;
    n |= n >>> 2;
    n |= n >>> 4;
    n |= n >>> 8;
    n |= n >>> 16;
    return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : n + 1);
  }

  class Entry<K, V> {
    K key;
    V value;
    Entry next;

    public Entry(K key, V value) {
      this.key = key;
      this.value = value;
      next = null;
    }
  }

  public void put(K key, V value) {
    int hashCode = key.hashCode() % hashTable.length;
    Entry node = hashTable[hashCode];

    if(node == null) {
      node = new Entry(key, value);
      hashTable[hashCode] = node;
      return;
    } else {
      Entry prevNodeEntry = null;

      while(node != null) {
        if (key.equals(node.key)) {
            node.value = value;
            return;
        }

        prevNodeEntry = node;
        node = node.next;
      }
      Entry newNode = new Entry(key, value);
      prevNodeEntry.next = newNode;
    }
  }

  public V get(K key) {
    int hashCode = key.hashCode() % hashTable.length;
    Entry node = hashTable[hashCode];

    while(node != null) {
      if(key.equals(node.key)) {
        return (V) node.value;
      }
      node = node.next;
    }
    return null;
  }

  public static void main(String[] args) {
    MyHashMap<Integer, String> map = new MyHashMap<>(7);

    map.put(1, "hello1");
    map.put(2, "hello2");
    map.put(3, "hello3");
    map.put(1, "hello4");

    System.out.println(map.get(1));
    System.out.println(map.get(2));
    System.out.println(map.get(3));
    System.out.println(map.get(4));
  }
}
