package com.gradle.tutorial.Project.Project1;

import jdk.swing.interop.SwingInterOpUtils;

public class ExpandableArray {
    private String[] arr;
    private int count;

    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    /**
     * Creates a new ExpandableArray with the default initial capacity of 10.
     */
    public ExpandableArray() {
        arr = new String[DEFAULT_INITIAL_CAPACITY];
        count = 0;
    }

    /**
     * Creates a new ExpandableArray with settable initial size.
     * @param initialSize The initial size of the wrapped array.
     */
    public ExpandableArray(int initialSize){
        arr = new String[initialSize];
        count = 0;
    }

    /**
     *
     * @return The number of elements in the wrapped array.
     */
    public int size() {
        return count;
    }

    /**
     * Adds s to the array, automatically expanding the array if necessary.
     * @param s The string to be added.
     */
    public void add(String s) {
        if (count >= arr.length){
            expandArray();
        }
        // Add s and increment the count.
        arr[count] = s;
        count++;
    }

    /**
     * Adds a string at a particular index, preserving order of existing elements.
     * @param s The string to add to the ExpandableArray
     * @param idx The index of the new element
     */
    public void add(String s, int idx){
        // If arr is full, expand it.
        if (count >= arr.length){
            expandArray();
        }
        // Start at count-1, shifting elements to the right one place,
        // counting down to idx.
        for (int i = count - 1; i >= idx; i--){
            arr[i+1] = arr[i];
        }
        // Once idx is free, add s to it.
        arr[idx] = s;
        // Update count.
        count++;
    }

    private void expandArray() {
        String[] arr2 = new String[arr.length * 2];
        for (int i = 0; i < arr.length; i++){
            arr2[i] = arr[i];
        }
        arr = arr2;
    }

    /**
     * Return the value at the index.
     * @param idx The index of the value of interest
     * @return The value at idx.
     */
    public String get(int idx){
        // Right now, if idx >= count but idx < arr.length, we return null.
        //       and, if idx >= arr.length, an exception is thrown.

        // Check for the error condition
        if (idx < 0 || idx >= count ){
            // Throw the exception
            throw new IndexOutOfBoundsException(idx
                    + " is out of bounds for ExpandableArray with "
                    + count + " elements.");
        }

        return arr[idx];
    }

    public String toString() {
        // TODO: Fix this grossness.
        return String.join(", ", arr);
    }

    // Testing
    public static void main(String[] args) {
        ExpandableArray ea = new ExpandableArray(2);
        ea.add("abc");
        System.out.println(ea);
        ea.add("def");
        System.out.println(ea);
        ea.add("ghi");
        System.out.println(ea);
        ea.add("jkl");
        ea.add("mno");
        System.out.println(ea);
        ea.add("123", 2);
        System.out.println(ea);
        ea.get(6);
    }
}