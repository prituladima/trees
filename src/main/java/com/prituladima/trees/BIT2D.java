package com.prituladima.trees;

public class BIT2D {

    private final long[][] value;
    private final int arraySizeX;
    private final int arraySizeY;

    public BIT2D(int arraySizeX, int arraySizeY) {
        value = new long[arraySizeX][arraySizeY];
        this.arraySizeX = arraySizeX;
        this.arraySizeY = arraySizeY;
    }

    public void add(int xx, int yy, int val) {
        for (int x = xx; x < arraySizeX; x = x | (x + 1)) {
            for (int y = yy; y < arraySizeY; y = y | (y + 1)) {
                value[x][y] += val;
            }
        }
    }

    public long get(int xx, int yy) {
        long sum = 0;
        for (int x = xx; x >= 0; x = (x & (x + 1)) - 1) {
            for (int y = yy; y >= 0; y = (y & (y + 1)) - 1) {
                sum += value[x][y];
            }
        }
        return sum;
    }

    // A function to answer the queries
    public long get(int x1, int x2, int y1, int y2) {
        if(x2 < x1){
            return get(x2, x1, y1, y2);
        }
        if(y2 < y1){
            return get(x1, x2, y2, y1);
        }
        return get(x2, y2) - get(x2, y1 - 1) - get(x1 - 1, y2) + get(x1 - 1, y1 - 1);
    }
}
