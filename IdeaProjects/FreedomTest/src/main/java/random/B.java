package random;

/**
 *  静态块：用static申明，JVM加载类时执行，仅执行一次
 *  构造块：类中直接用{}定义，每一次创建对象时执行
 *  执行顺序优先级：静态块>main()>构造块>构造方法
 *  静态块按照申明顺序执行
 */
public class B
{
    public static B t1 = new B();
    public static B t2 = new B();
    static
    {
        System.out.println("静态块");
    }
    {
        System.out.println("构造块");
    }
    public static void main(String[] args)
    {
        B t = new B();
    }
}