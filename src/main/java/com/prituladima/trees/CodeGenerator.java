package com.prituladima.trees;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class CodeGenerator {
    public static void main(String[] args) throws IOException {

        PrintWriter  writer = new PrintWriter(new FileWriter("Arrays.txt"));

        Random rand = new Random();
        int n = 300_000;
//        int n = 10;
        writer.print(n);
        writer.print('\n');
        writer.print('\n');


        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = rand.nextInt(10000);
        }
        Arrays.sort(res);
        for (Integer re : res) {
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
        BinarySearch binarySearch  = new BinarySearch();
        for (int i = 0; i < q; i++) {
            int newVal = rand.nextInt(10000);
            writer.print(newVal);
            writer.print(' ');
            writer.print(binarySearch.lowerBound(res, newVal));
            writer.print('\n');
        }

        writer.close();

    }
}
