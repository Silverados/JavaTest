package random;

import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void compareTo() {
        Person p = new Person("li", 5000);
        Person p2 = new Person("wang", 2000);
        Comparator<Person> c = (Person first, Person second)-> Double.compare(first.getMoney(), second.getMoney());

        System.out.println(p.compareTo(p2));
    }
}