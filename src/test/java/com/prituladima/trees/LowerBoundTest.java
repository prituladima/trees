package com.prituladima.trees;

import com.prituladima.trees.util.VariableSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import static com.prituladima.trees.util.ParametrizedArgumentSupplier.LOWER_BOUND;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;

import static com.prituladima.trees.util.ParametrizedArgumentSupplier.*;

public class LowerBoundTest {

    public static Stream<Arguments> ARGUMENTS = supplier(LOWER_BOUND).get();

    @ParameterizedTest
    @VariableSource("ARGUMENTS")
    void test_lower_bound(File testCaseFile) throws FileNotFoundException {
        try (Scanner inScanner = new Scanner(testCaseFile)) {

            int size = inScanner.nextInt();

            int[] array = new int[size];

            for (int j = 0; j < size; j++) {
                array[j] = inScanner.nextInt();
            }

            int amountOfRequests = inScanner.nextInt();

            int[] requests = new int[amountOfRequests];
            int[] expectedIndexes = new int[amountOfRequests];

            for (int j = 0; j < amountOfRequests; j++) {
                requests[j] = inScanner.nextInt();
                expectedIndexes[j] = inScanner.nextInt();
            }

            test_lower_bound(size, array, amountOfRequests, requests, expectedIndexes);

        }
    }


    void test_lower_bound(int size, int[] array, int amountOfRequests, int[] requests, int[] expectedIndexes) {
        assertTimeout(ofSeconds(1), () -> {
            BinarySearch binarySearch = new BinarySearch();
            for (int i = 0; i < amountOfRequests; i++) {
                assertEquals(expectedIndexes[i], binarySearch.lowerBound(array, requests[i]));
            }
        });
    }

}