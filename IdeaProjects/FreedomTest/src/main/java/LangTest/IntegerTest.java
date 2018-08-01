package LangTest;

public class IntegerTest {
    public static void main(String[] args){
        /**
         *Integer(int value)构造一个新分配的 Integer对象，该对象表示指定的 int值。
         *Integer(String s)构造一个新分配 Integer对象，表示 int由指示值 String参数。
         */
        Integer a = new Integer(1);
        Integer b = new Integer("2");
        Integer i = 9;

        System.out.println();
        System.out.println();

        int d = 1_000_000;


        int s1 = 20_000_000_00;
        int s2 = 20_000_000_00;
//        int s = Math.addExact(s1,s2);
        System.out.println(s1 + s2);



    }
    

}
