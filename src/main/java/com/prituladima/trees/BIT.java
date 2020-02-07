package com.prituladima.trees;

public class BIT {

    private final long[] value;

    public BIT(int size) {
        value = new long[size];
    }

    public long get(int from, int to) {
        if (from > to) {
            return 0;
        }
        return get(to) - get(from - 1);

//        long result = 0L;
//        for(int i = from; i <= to; i++){
//            result += value[i];
//        }
//        return result;
    }

    private long get(int to) {
        long result = 0;
        while (to >= 0) {
            result += value[to];
            to = (to & (to + 1)) - 1;
        }
        return result;
    }

    public void add(int at, long value) {
//        this.value[at] += value;
        while (at < this.value.length) {
            this.value[at] += value;
            at = at | (at + 1);
        }
    }

    public static void main(String[] args) {



    }

}
