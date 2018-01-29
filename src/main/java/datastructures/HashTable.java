package datastructures;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by thiago on 10/07/17.
 */
public class HashTable<V> {

    private LinkedList<Object>[] data = new LinkedList[100000];

    public HashTable(){
    }

    public void put( String key, V value){
        final int hash = hash(key);
        final int index = index(hash);
        final LinkedList<Object> bucket = data[index] == null? new LinkedList<>() : data[index];

        for(Iterator<Object> it = bucket.iterator(); it.hasNext();){
          Object o = it.next();

          if(key.equalsIgnoreCase(o.toString())){
            it.remove();
            it.next();
            it.remove();
          }
        }

        bucket.add(key);
        bucket.add(value);
        data[index] = bucket;

    }

    private int index(int i){
        return i % data.length;
    }

    private int hash(String key){

        int hash = 5;
        for(int i = 0; i < key.length(); i++){
            hash = hash * 13 + key.charAt(i);
        }

        return hash;
    }


    public V get(String key) {

        final int hash = hash(key);
        final int index = index(hash);
        final LinkedList<Object> bucket = data[index] == null? new LinkedList<>() : data[index];

        if(bucket.isEmpty()) {
            return null;
        }else{

            for(Iterator<Object> it = bucket.iterator(); it.hasNext();){
                Object o = it.next();

                if(key.equalsIgnoreCase(o.toString())){
                    return (V) it.next();
                }
            }

            return null;
        }
    }


    public static void main(String[] args){

      HashTable<String> h = new HashTable<>();
      h.put("Hello", "World");
      h.put("World", "Hello");
      h.put("Hello", "World");

      System.out.println(h.get("Hello"));

    }
}
