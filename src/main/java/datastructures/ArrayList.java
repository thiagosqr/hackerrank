package datastructures;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by thiago on 11/07/17.
 */
public class ArrayList<T> {

    private T[] data = null;

    private int index = 0;

    public ArrayList(Class<T> clazz) {
        data = (T[]) Array.newInstance(clazz, 0);
    }

    public ArrayList(Class<T> clazz, int size) {
        data = (T[]) Array.newInstance(clazz, size);
    }

    public synchronized void add(T value){

        if(index + 1 > data.length){
            final int newSize = data.length == 0? 16 :data.length * 2;
            data = Arrays.copyOf(data, newSize);
        }

        data[index] = value;
        index++;

    }

    public T get(int index) throws ArrayIndexOutOfBoundsException{
        return data[index];
    }

}
