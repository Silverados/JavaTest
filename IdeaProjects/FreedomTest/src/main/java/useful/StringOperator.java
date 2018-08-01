package useful;

public class StringOperator {
    public static void main(String[] args){
        String s = "2018.05.05";
        System.out.println(s.replace(".", "-"));
        // 2018.05.05  ->  2018-05-05
        System.out.println(s.replaceAll("\\.", ""));
        // 2018.05.05  -> 20180505
        System.out.println(s.replaceAll("[^0-9]", ""));
    }
}
