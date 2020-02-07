package com.prituladima.trees;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class TestGeneratorGenerator {
    public static void main(String[] args) throws IOException {


        int arraySize = 400_000;
        int queryAmount = 400_000;
        int bound = 100000;
        int delta = 100000;


        PrintWriter writer = new PrintWriter(new FileWriter("Arrays.txt"));

        Random rand = new Random();

        writer.print(arraySize);
        writer.print('\n');

        BIT bit = new BIT(arraySize);

        for (int i = 0; i < arraySize; i++) {
            int val = rand.nextInt(bound);
            writer.print(val);
            writer.print(' ');
            bit.add(i, val);
        }

        writer.print('\n');
        writer.print('\n');
        writer.print('\n');

        writer.print(queryAmount);
        writer.print('\n');
        writer.print('\n');

        for (int i = 0; i < queryAmount; i++) {
            if (rand.nextBoolean()) {

                int L = rand.nextInt(arraySize);
                int R = rand.nextInt(arraySize);

                if (R < L) {
                    int buf = L;
                    L = R;
                    R = buf;
                }

                writer.print('S');

                writer.print(' ');

                writer.print(L);

                writer.print(' ');

                writer.print(R);

                writer.print(' ');

                writer.print(bit.get(L, R));

                writer.print('\n');
            }
            else {
                int I = rand.nextInt(arraySize);
                int V = rand.nextInt(delta);

                writer.print('M');

                writer.print(' ');

                writer.print(I);

                writer.print(' ');

                writer.print(V);

//                writer.print(' ');

//                writer.print(bit.get(L, R));
                bit.add(I, V);

                writer.print('\n');

            }
        }

        writer.close();

    }
}
