package datastructures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by thiago on 10/07/17.
 */
public class HashTable<K,V> {

  private LinkedList[] data = new LinkedList[1000];

  public HashTable(){
  }

  public V get(K key){
    final Integer hash = hashKey(key);
    final Integer i = index(hash);
    final java.util.LinkedList<Object> bucket = data[i] != null?
        data[i] : new LinkedList<>();
    if(bucket.contains(key)){
      int keyAt = bucket.indexOf(key);
      return (V) bucket.get(keyAt+1);
    }else{
      return null;
    }

  }

  public void put(K key, V val){
    final Integer hash = hashKey(key);
    final Integer i = index(hash);
    final java.util.LinkedList<Object> bucket = data[i] != null?
        data[i] : new LinkedList<>();

    if(bucket.contains(key)){
      int keyAt = bucket.indexOf(key);
      bucket.remove(keyAt+1);
      bucket.remove(key);
    }

    bucket.add(key);
    bucket.add(val);

    data[i] = bucket;

  }

  public Integer hashKey(K key){
    return Objects.hashCode(key);
  }

  public Integer index(Integer hash){
    return hash % data.length;
  }


    public static void main(String[] args){

      HashTable<String,String> h = new HashTable<>();
      h.put("Hello", "World");
      h.put("World", "Hello");
      h.put("Hello", "World");

      System.out.println(h.get("Hello"));

    }
}
