package reflect_learning;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectClass {

    public static void main(String[] args){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            Class clazz = loader.loadClass("reflect_learning.User");
            Constructor constructor = clazz.getDeclaredConstructor((Class[])null);
            User user = (User) constructor.newInstance();
            Method setId = clazz.getMethod("setId",int.class);
            Method setName = clazz.getMethod("setName", String.class);
            setId.invoke(user, 1);
            setName.invoke(user, "wei");
            System.out.println(user.toString());

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
            }
            fields[0].setInt(user,3);
            fields[1].set(user,"li");
            System.out.println(user.toString());

            Constructor constructor1 = clazz.getDeclaredConstructor(int.class, String.class);
            User user1 = (User)constructor1.newInstance(2, "wyw");
            System.out.println(user1.toString());




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
