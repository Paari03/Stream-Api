import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Person {
    private  String name;
    private  int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name = " + name + " age = " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void main(String[] args) {
        final Set<Person> personSet = new HashSet<>();

        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Alice", 30);
        personSet.add(person1);
        personSet.add(person2);
        Iterator<Person> iterator = personSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        testP(person1);
        System.out.print(person1);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private static void testP(Person person1) {
//        person1 = new Person("skdgnnr", 23);
        person1.setAge(23);
        person1.setName("egt");
//        System.out.println(person1);
    }



}
