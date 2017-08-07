package datastrucute;

import datastructures.ArrayList;

import java.util.UUID;

/**
 * Created by thiago on 11/07/17.
 */
public class ArrayListTest {

    public static void main(String[] args){

        int i = 1;

        final ArrayList<Person> list = new ArrayList<>(Person.class);
        list.add(new Person(i++, UUID.randomUUID().toString()));
        list.add(new Person(i++, UUID.randomUUID().toString()));
        list.add(new Person(i++, UUID.randomUUID().toString()));
        list.add(new Person(i++, UUID.randomUUID().toString()));
        list.add(new Person(i++, UUID.randomUUID().toString()));

        list.get(100);

    }

}
