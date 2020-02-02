package com.prituladima.trees;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class BinarySearch {


    public int lowerBound(int[] array, int fromElement) {
        int low = -1;
        int high = array.length;

        while (high - low > 1) {
            int middle = low + (high - low) / 2;
            if (fromElement <= array[middle]){
                high = middle;
            } else {
                low = middle;
            }
        }

        return high;
    }


    public int upperBound(int[] array, int toElement) {
        int low = -1;
        int high = array.length;

        while (high - low > 1) {
            int middle = low + (high - low) / 2;
            if (array[middle] < toElement) {
                low = middle;
            } else {
                high = middle;
            }
        }

        return low;
    }


    public int rangeSize(int[] array, int fromElement, int toElement){
        return lowerBound(array, toElement) - lowerBound(array, fromElement);
    }


    public <T extends Comparable> int lowerBound(List<T> source, Predicate<T> predicate) {

        return -1;
    }


    public <T extends Comparable> int upperBound(List<T> source, Predicate<T> predicate) {

        return -1;
    }

    public static void main(String[] args) {


        int[] arrays = new int[]{1, 2, 7, 7, 7, 7, 7};
//      int[] arrays = new int[]{0, 1, 2, 3, 4, 5, 6};

        System.out.println(Arrays.binarySearch(arrays, 1));
        System.out.println(Arrays.binarySearch(arrays, 2));
        System.out.println(Arrays.binarySearch(arrays, 7));


        System.out.println();

        BinarySearch binarySearch = new BinarySearch();

//        System.out.println(binarySearch.lowerBound(arrays, 7));

//        System.out.println(binarySearch.upperBound(arrays, 8));

        System.out.println(binarySearch.rangeSize(arrays, 7, 8));//5
        System.out.println(binarySearch.rangeSize(arrays, 7, 7));//0
        System.out.println(binarySearch.rangeSize(arrays, 7, 200));//5
        System.out.println(binarySearch.rangeSize(arrays, 1, 7));//2


//        TreeSet<Integer> treeSet = new TreeSet<>();
//
//        treeSet.add(1);
//        treeSet.add(2);
//        treeSet.add(7);
//        treeSet.add(7);
//        treeSet.add(7);
//        treeSet.add(7);
//        treeSet.add(7);
//
//        SortedSet<Integer> integers = treeSet.subSet(7, 8);
//        System.out.println(integers);
//
//        SortedSet<Integer> integers1 = treeSet.subSet(7, 7);
//        System.out.println(integers1);

    }


}
