package LangTest;

public class BooleanTest {
    public static void main(String[] args){
        /**
         * 参数是true 或者 false
         */
        Boolean b = new Boolean(true);

        /**
         * 如果 String 参数不为 null 且在忽略大小写时等于 "true"，则分配一个表示 true 值的 Boolean 对象。否则返回false
         */
        Boolean b2 = new Boolean("True");
        System.out.println(b2);
        Boolean b3 = new Boolean("TrUe");
        System.out.println(b3);
        Boolean b4 = new Boolean("others");
        System.out.println(b4);

        //将此 Boolean 对象的值作为基本布尔值返回。
        System.out.println(b2.booleanValue());

        //返回指定对象的boolean,我觉得就像在C语言里面的true/false判断那样，对非true的字符串返回false、
        System.out.println(Boolean.valueOf(true));
        System.out.println(Boolean.valueOf("others"));

        //toString 方法包括实例和静态两种方法
        System.out.println(b2.toString());
        System.out.println(Boolean.toString(true));

        //将字符串参数解析为 boolean 值。
        System.out.println(Boolean.parseBoolean("1"));
    }
}
