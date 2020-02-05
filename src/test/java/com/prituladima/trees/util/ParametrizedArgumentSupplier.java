package com.prituladima.trees.util;

import org.junit.jupiter.params.provider.Arguments;

import java.io.File;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ParametrizedArgumentSupplier implements Supplier<Stream<Arguments>> {

    public static final String LOWER_BOUND = "binary_search/lower_bound/";
    public static final String UPPER_BOUND = "binary_search/upper_bound/";
    public static final String SUB_RANGE = "binary_search/sub_range/";

    public static final String DIJKSTRA = "heap/dijkstra/";
    public static final String KRUSKAL = "djus/kruskal/";

    private static final String BASE = System.getProperty("user.dir") + "/src/test/";

    private static Map<String, ParametrizedArgumentSupplier> suppliers;

    public static ParametrizedArgumentSupplier supplier(String type) {
        suppliers = new HashMap<>();

        suppliers.computeIfAbsent(LOWER_BOUND, key -> new ParametrizedArgumentSupplier(LOWER_BOUND));
        suppliers.computeIfAbsent(UPPER_BOUND, key -> new ParametrizedArgumentSupplier(UPPER_BOUND));
        suppliers.computeIfAbsent(SUB_RANGE, key -> new ParametrizedArgumentSupplier(SUB_RANGE));

        suppliers.computeIfAbsent(DIJKSTRA, key -> new ParametrizedArgumentSupplier(DIJKSTRA));
        suppliers.computeIfAbsent(KRUSKAL, key -> new ParametrizedArgumentSupplier(KRUSKAL));

        return suppliers.get(type);
    }

    private final String folderName;

    private ParametrizedArgumentSupplier(String type) {
        this.folderName = BASE + type;
    }

    @Override
    public Stream<Arguments> get() {
        File folder = new File(folderName);
        return Arrays.stream(folder.listFiles())
                .filter(file -> !file.isDirectory())
                .map(Arguments::of);
    }
}