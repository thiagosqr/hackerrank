package datastrucute;

import datastructures.HashTable;

/**
 * Created by thiago on 10/07/17.
 */
public class HashTableTest {

    public static void main(String[] args){

        final HashTable<Person> table = new HashTable<>();
        table.put("thiago", new Person(33,"Thiago"));
        table.put("ana", new Person(26,"Ana"));

        System.out.println(table.get("thiago").getName());

        System.out.println(table.get("test").getName());

    }


}
