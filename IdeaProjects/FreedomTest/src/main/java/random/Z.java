package random;

/**
 *  1. 初始化父类中的静态成员变量和静态代码块 ；
 *  2. 初始化子类中的静态成员变量和静态代码块 ；
 *  3. 初始化父类的普通成员变量和代码块，再执行父类的构造方法；
 *  4. 初始化子类的普通成员变量和代码块，再执行子类的构造方法；
 */
class X{
    Y y=new Y();
    public X(){
        System.out.print("X");
    }
}
class Y{
    public Y(){
        System.out.print("Y");
    }
}
public class Z extends X{
    Y y=new Y();
    public Z(){
        System.out.print("Z");
    }
    public static void main(String[] args) {
        new Z();
    }
}