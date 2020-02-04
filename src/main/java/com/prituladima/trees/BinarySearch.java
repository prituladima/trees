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
            if (fromElement <= array[middle]) {
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
            if (array[middle] <= toElement) {
                low = middle;
            } else {
                high = middle;
            }
        }

        return low;
    }


    public int rangeSize(int[] array, int fromElement, int toElement) {
        return lowerBound(array, toElement) - lowerBound(array, fromElement);
    }


    public <T extends Comparable> int lowerBound(List<T> source, Predicate<T> predicate) {

        return -1;
    }


    public <T extends Comparable> int upperBound(List<T> source, Predicate<T> predicate) {

        return -1;
    }

}