public Node {
    int hashCode;
    K key;
    V value;
    Node<K, V> next;
}

String, V : {"abc", v1}, {"bcd", v2}
hashcode: 7, 24
index: 7 % 16 = 7, 24 % 16 = 8

Map.put(K, V)
Map.get(K)
Map.remove(K)


{
    int hashcode;
    K key;
    V value;
    Node<K, V> next;
    Node<K, V> before;
    Node<K, V> after;
}

LinkedHashMap
head
tail

User class as key of HashMap
