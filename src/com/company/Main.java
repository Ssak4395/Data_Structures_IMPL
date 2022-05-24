package com.company;

import java.sql.Array;

public class Main {

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(1);
       System.out.println( dynamicArray.contains(2));

    }

}
