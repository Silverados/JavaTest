package random;

import java.util.*;

public class Random {
    public static void main(String[] args){
        Map<String, String> map = new LinkedHashMap<>();
        map.put("a","A");
        map.put("b","B");
        map.put("c","C");
        map.put("d","D");

        map.get("d");
        map.get("d");
        map.get("d");
        map.get("b");

//        map.forEach((K,V)-> System.out.println("key="+K+"  value="+V));
        map.keySet().iterator().forEachRemaining((key)-> System.out.println(key));


        List<String> strings = new ArrayList<>();
        List newList = strings;
        newList.add(4);


        ArrayList<String>[] arrayLists = (ArrayList<String>[]) new ArrayList<?>[10];
    }
}
