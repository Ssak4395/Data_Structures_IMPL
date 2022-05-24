package com.company;

import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T>{

    private T[] arr;
    private int len = 0; // length user thinks array is
    private int capacity = 0; // Actual array size

    public DynamicArray()
    {
        this(16);
    }

    public DynamicArray(int capacity)
    {
        arr = (T[]) new Object[capacity];
    }

    public int size()
    {
        return arr.length;
    }



    public boolean isEmpty()
    {
        return len == 0;
    }

    public void clear()
    {
        for(int i = 0; i<capacity; ++i)
        {
            arr[i] = null;
        }
        len = 0;
    }

    public void add(T object){
        if(len + 1  >= capacity)
        {
            if(capacity == 0) {capacity = 1;}
            System.out.println("The array is too big, resizing now");
            T[] newArray = (T[]) new Object[capacity * 2];
            capacity = capacity*2;

            for(int i = 0;  i< len; ++i)
            {
                newArray[i] = arr[i];
            }

            arr = newArray;
        }
        arr[len++] = object;
    }

    public void removeAt(int index)
    {
        T data = arr[index];

        T[] newArr = (T[]) new Object[len - 1];

        for(int i = 0, k = 0; i<len; ++i)
        {
            if(arr[i] == data)
            {
                continue;
            }
            newArr[k++] = arr[i];
        }

        arr = newArr;
        System.out.println(Arrays.toString(newArr));
System.out.println(capacity);
        capacity = --len;
    }

    public boolean  remove(T Obj)
    {
        for(int i = 0; i<len; ++i)
        {
            if(arr[i] == Obj)
            {
                removeAt(i);
                return true;
            }

        }

        return false;

    }

    public int indexOf(T Obj)
    {
        for(int i = 0; i<len; ++i)
        {
            if(arr[i] == Obj)
            {

                return i;
            }

        }
        return -1;
    }


    public boolean contains(T obj)
    {
        return indexOf(obj) != -1;
    }

    @Override
    public String toString() {

        for(int i = 0; i<len; ++i)
        {
            System.out.print(arr[i] + " ");
        }
        return arr.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
