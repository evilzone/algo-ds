import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Application {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("hello", "value1");
        hashMap.put("world", "value2");
        hashMap.put("zello", "value3");
        hashMap.put("kettle", "value4");

        for(String key : hashMap.keySet()) {
            System.out.println("key " + key);
        }

        System.out.println("=============================================");

        for(Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println("key " + entry.getKey() + " value " + entry.getValue());
        }

        System.out.println("=============================================");

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("hello", "value1");
        linkedHashMap.put("world", "value2");
        linkedHashMap.put("zello", "value3");
        linkedHashMap.put("kettle", "value4");

        for(String key : linkedHashMap.keySet()) {
            System.out.println("key " + key);
        }

        System.out.println("=============================================");

        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("hello", "value1");
        treeMap.put("world", "value2");
        treeMap.put("zello", "value3");
        treeMap.put("kettle", "value4");

        for(String key : treeMap.keySet()) {
            System.out.println("key " + key);
        }
    }
}

