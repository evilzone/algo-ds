import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

enum Gender {
    FEMALE,
    MALE;
}

class Person {
    String name;
    int age;
    Gender gender;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}

public class Main {

    public static void main(String[] args) {

        // imperative
        // get all females

        List<Person> people = getPeople();
        List<Person> females = new ArrayList<>();

        for(Person person : people) {
            if(person.gender.equals(Gender.FEMALE)) {
                females.add(person);
            }
        }

        females.forEach(System.out::println);
        System.out.println("=========================================");

        List<Person> females1 = new ArrayList<>();
        // declarative
        // filter
        females1 = people
                .stream()
                .filter(person -> person.gender.equals(Gender.FEMALE))
                .collect(Collectors.toList());

        //females1.forEach(System.out::println);


        // sort
        females1 = people.stream().sorted(Comparator.comparing(p -> p.age))
                .collect(Collectors.toList());

        //females1.forEach(System.out::println);

        // comparator
        females1 = people.stream().sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());

        females1.forEach(System.out::println);

        // all match
        boolean flag = people.stream().allMatch(person ->
                (person.age > 125));
        System.out.println("flag " + flag);

        // none match
        flag = people.stream().noneMatch(person ->
                (person.age > 125));
        System.out.println("flag " + flag);

        // max
        Optional<Person> person = people.stream().max(Comparator.comparing(Person::getAge));
        System.out.println("person " + person.get());

        // min
        person = people.stream().min(Comparator.comparing(Person::getAge));
        System.out.println("person " + person.get());

        System.out.println("=========================================");

        // group
        Map<Gender, List<Person>> fm = people.stream().collect(groupingBy(Person::getGender));

        fm.get(Gender.FEMALE).forEach(System.out::println);

        System.out.println("=========================================");

        // get the oldest female
        Optional<String> person1 = people.stream()
                    .filter(p -> p.gender.equals(Gender.FEMALE))
                    .max(Comparator.comparing(Person::getAge))
                    .map(Person::getName);
        System.out.println(person1.get());
    }

    private static List<Person> getPeople() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("p1", 10, Gender.FEMALE));
        list.add(new Person("p2", 60, Gender.FEMALE));
        list.add(new Person("p3", 90, Gender.MALE));
        list.add(new Person("p4", 110, Gender.FEMALE));
        list.add(new Person("p5", 70, Gender.MALE));

        return list;
    }
}
