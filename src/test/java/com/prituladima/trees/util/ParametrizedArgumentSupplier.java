package com.prituladima.trees.util;

import org.junit.jupiter.params.provider.Arguments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ParametrizedArgumentSupplier implements Supplier<Stream<Arguments>> {

    public static final String BFS = "bfs";
    public static final String DFS = "dfs";
    public static final String TOP_SORT = "top";
    public static final String BACKTRACKING = "backtrack";

    public static final String LOWER_BOUND = "lower_bound";

    private static final String BASE = System.getProperty("user.dir");
    //    private static final int AMOUNT_OF_TESTS = 9;
    private static Map<String, ParametrizedArgumentSupplier> suppliers;

    public static ParametrizedArgumentSupplier supplier(String type) {
        suppliers = new HashMap<>();
//        suppliers.computeIfAbsent(BFS, key -> new ParametrizedArgumentSupplier(type));
        suppliers.computeIfAbsent(LOWER_BOUND, key -> new ParametrizedArgumentSupplier(type));
//        suppliers.computeIfAbsent(DFS, key -> new ParametrizedArgumentSupplier(type));
//        suppliers.computeIfAbsent(TOP_SORT, key -> new ParametrizedArgumentSupplier(type));
//        suppliers.computeIfAbsent(BACKTRACKING, key -> new ParametrizedArgumentSupplier(type));

        return suppliers.get(type);
    }

    private final String type;

    private ParametrizedArgumentSupplier(String type) {
        this.type = type;
    }

    @Override
    public Stream<Arguments> get() {
        List<Arguments> ans = new ArrayList<>();
        try (Scanner inScanner = new Scanner(new File(BASE + "/src/test/binary_search/" + type + "/input.txt"));
             Scanner outScanner = new Scanner(new File(BASE + "/src/test/binary_search/" + type + "/output.txt"))) {

            int amountOfTests = inScanner.nextInt();
            for (int testNumber = 1; testNumber <= amountOfTests; testNumber++) {

                int size = inScanner.nextInt();
                int[] array = new int[size];
                for (int j = 0; j < size; j++) {
                    array[j] = inScanner.nextInt();
                }
                int amountOfRequests = inScanner.nextInt();
                int[] requests = new int[amountOfRequests];
                for (int j = 0; j < amountOfRequests; j++) {
                    requests[j] = inScanner.nextInt();
                }

                int[] expectedIndexes = new int[amountOfRequests];
//                for (int j = 0; j < amountOfRequests; j++) {
//                    requests[j] = outScanner.nextInt();
//                }

                ans.add(Arguments.of(testNumber, size, array, amountOfRequests, requests, expectedIndexes));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return ans.stream();
    }
}
