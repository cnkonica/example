package com.cnkonica.example.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorUtils {
    private CollectorUtils(){}

    public static <T, K, K2, V> Collector<T, ?, Map<K, Map<K2, V>>> groupingToNestedMap(Function<T, K> keyFunc,
                                                                                        Function<T, K2> key2Func,
                                                                                        Function<T, V> valueFunc) {
        return Collectors.groupingBy(keyFunc, Collectors.toMap(key2Func, valueFunc));
    }
    public static <T, K, K2> Collector<T, ?, Map<K, Map<K2, T>>> groupingToNestedMap(Function<T, K> keyFunc,
                                                                                        Function<T, K2> key2Func) {
        return Collectors.groupingBy(keyFunc, Collectors.toMap(key2Func, Function.identity()));
    }

    public static <T, K, K2> Collector<T, ?, Map<K, Map<K2, List<T>>>> groupingTwice(Function<T, K> keyFunc,
                                                                                  Function<T, K2> key2Func) {
        return Collectors.groupingBy(keyFunc, Collectors.groupingBy(key2Func));
    }

    public static <T, K, K2,V> Collector<T, ?, Map<K, Map<K2, List<V>>>> groupingTwice(Function<T, K> keyFunc,
                                                                                     Function<T, K2> key2Func,
                                                                                       Function<T,V> valueFunc) {
        return Collectors.groupingBy(keyFunc,
                Collectors.groupingBy(key2Func,Collectors.mapping(valueFunc,Collectors.toList())));
    }

    public static <T, K> Collector<T, ?, ArrayList<T>> groupingThenMerge(Function<T, K> keyFunc,
                                                                              BinaryOperator<T> mergeFunc) {
        return groupingThenMerge(keyFunc, a -> a, mergeFunc);
    }

    public static <T, K,V> Collector<T, ?, ArrayList<V>> groupingThenMerge(Function<T, K> keyFunc,
                                                                                Function<T,V> valueFunc ,
                                                                                BinaryOperator<V> mergeFunc) {
        return Collectors.collectingAndThen(
                Collectors.toMap(keyFunc,valueFunc,mergeFunc),
                map -> new ArrayList<>(map.values())
        );
    }


}
