package random;

import java.util.Comparator;

public class Person implements Comparable<Person>{
    private String name;
    private int money;

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    @Override
    public int compareTo(Person other) {
        return Double.compare(this.money,other.getMoney());
    }
}

class moneyCompartor implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Double.compare(o1.getMoney(), o2.getMoney());
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
