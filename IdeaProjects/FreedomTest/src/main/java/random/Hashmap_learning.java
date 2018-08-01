package random;

import java.util.HashMap;

public class Hashmap_learning {
    public static void main(String[] args){
        HashMap<String, String> hashMap = new HashMap<>();
        System.out.println(hashMap.put("a", "A"));
        System.out.println(hashMap.put("a", "B"));
        hashMap.put("b","B");
        System.out.println(hashMap.get("a"));
    }
}
