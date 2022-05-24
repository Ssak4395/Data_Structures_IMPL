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
            T[] newArray = (T[]) new Object[capacity * 2]; //Create new array of double size
            capacity = capacity*2; //Set the capacity to the new capacity

            for(int i = 0;  i< len; ++i)
            {
                newArray[i] = arr[i];  //Copy everything to the new array
            }

            arr = newArray;  //Set the array to the new array
        }
        arr[len++] = object; //add the item to the end of the array.
    }

    public void removeAt(int index)
    {
        T data = arr[index];  // Locate the item you want to remove

        T[] newArr = (T[]) new Object[len - 1];  //Create a new temp array that is smaller than one of the original

        for(int i = 0, k = 0; i<len; ++i)
        {
            if(arr[i] == data)
            {
                continue;  //If the array index is at the data we want to remove keep going (skip it)
            }
            newArr[k++] = arr[i]; //if it isnt add all items EXCEPT the object we want to remove into the new array
        }

        arr = newArr;  //set array to new array
        capacity = --len;  //decrement the length by 1
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
