package com.prituladima.trees;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class TestGeneratorGenerator {
    public static void main(String[] args) throws IOException {

        PrintWriter writer = new PrintWriter(new FileWriter("Arrays.txt"));

        Random rand = new Random();
        int n = 1_000;
        int m = 1_000;
//        int n = 10;
        writer.print(n);
        writer.print('\n');
        writer.print('\n');


        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; i < m; i++) {
                res[i][j] = rand.nextInt(10000);
            }
        }
//        Arrays.sort(res);
        for (int[] re : res) {
            writer.print(re);
            writer.print(' ');
        }

        writer.print('\n');
        writer.print('\n');
        writer.print('\n');

        int q = 300_000;
        writer.print(q);
        writer.print('\n');
        writer.print('\n');
        BinarySearch binarySearch = new BinarySearch();
        for (int i = 0; i < q; i++) {
            int newVal1 = rand.nextInt(10000);
            int newVal2 = rand.nextInt(10000);

            if (newVal2 < newVal1) {
                int buf = newVal1;
                newVal1 = newVal2;
                newVal2 = buf;
            }

            writer.print(newVal1);

            writer.print(' ');
            writer.print(newVal2);
            writer.print(' ');

//            writer.print(binarySearch.upperBound(res, newVal));
//            writer.print(binarySearch.lowerBound(res, newVal));
            writer.print(binarySearch.rangeSize(res[0], newVal1, newVal2));
            writer.print('\n');
        }

        writer.close();

    }
}
