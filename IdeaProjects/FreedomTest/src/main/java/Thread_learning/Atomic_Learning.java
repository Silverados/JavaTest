package Thread_learning;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

public class Atomic_Learning {
    public static void main(String[] args){
        AtomicInteger a = new AtomicInteger(5);
        System.out.println(a.getAndIncrement()); //输出5  值为6
        System.out.println(a.getAndIncrement()); //输出6  值为7
        System.out.println(a.compareAndSet(4, 9)); //此时值为7，所以值会变更为9并返回true。否则返回false，值不变。
        System.out.println(a.get());

        int[] b = new int[]{1, 2};
        AtomicIntegerArray array = new AtomicIntegerArray(b);
        System.out.println(array.addAndGet(0, 5));//array索引为0的值更新为6


        User user = new User("www",20);
        User user1 = new User("ww", 5);
        AtomicReference<User> reference = new AtomicReference<>();
        reference.set(user);
        reference.compareAndSet(user, user1);
        System.out.println(reference.get().getName()); //[5, 6]


        int[] www = new int[]{2,3};
        int[] ww = new int[]{5,6};
        AtomicReference<int[]> atomicReference = new AtomicReference<>();
        atomicReference.set(www);
        atomicReference.compareAndSet(www, ww);
        System.out.println(Arrays.toString(atomicReference.get()));

        AtomicIntegerFieldUpdater<User> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");
    }

    static class User{
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
