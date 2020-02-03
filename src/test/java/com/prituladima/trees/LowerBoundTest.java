package com.prituladima.trees;

import com.prituladima.trees.util.VariableSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import static com.prituladima.trees.util.ParametrizedArgumentSupplier.LOWER_BOUND;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.util.stream.Stream;

import static com.prituladima.trees.util.ParametrizedArgumentSupplier.*;

public class LowerBoundTest {

    public static Stream<Arguments> ARGUMENTS = supplier(LOWER_BOUND).get();

    @ParameterizedTest
    @VariableSource("ARGUMENTS")
    void test_lower_bound(int testNumber, int size, int[] array, int amountOfRequests, int[] requests, int[] expectedIndexes) {
        System.out.printf("Test %d. Array size %d\n", testNumber, size);

        try {
            assertTimeout(ofSeconds(1), () -> {
                BinarySearch binarySearch = new BinarySearch();
                for (int i = 0; i < amountOfRequests; i++) {
                    System.out.println("Assertion");
                    assertEquals(expectedIndexes[i], binarySearch.lowerBound(array, requests[i]));
                }
            });
        }catch (Throwable t){
            System.out.println(t);
        }
//        if(size == 200_000){
//            throw new IllegalStateException();
//        }
    }

}