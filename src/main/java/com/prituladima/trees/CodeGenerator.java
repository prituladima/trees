package com.prituladima.trees;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class CodeGenerator {
    public static void main(String[] args) throws IOException {

        PrintWriter  writer = new PrintWriter(new FileWriter("Arrays.txt"));

        Random rand = new Random();
        int n = 200_000;
//        int n = 10;
        writer.print(n);
        writer.print('\n');
        writer.print('\n');


        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(rand.nextInt(10000));
        }
        res.sort(Comparator.naturalOrder());
        for (Integer re : res) {
            writer.print(re);
            writer.print(' ');
        }

        writer.print('\n');
        writer.print('\n');
        writer.print('\n');

        int q = 200_000;
        writer.print(q);
        writer.print('\n');
        writer.print('\n');
        for (int i = 0; i < q; i++) {
            writer.print(rand.nextInt(10000));
            writer.print('\n');
        }

        writer.close();

    }
}
