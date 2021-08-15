package com.cnkonica.example.common.utils;

import com.cnkonica.example.common.exception.ExceptionUtils;
import com.google.common.collect.Lists;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonUtils {
    public static final int DEFUALT_SPLIT_SIZE = 900;
    private CommonUtils(){}

    public static <T> List<List<T>> split(List<T> list) {
        return split(list, DEFUALT_SPLIT_SIZE);
    }

    /**
     * 拆分list
     *
     * @param list
     * @param size
     * @param <T>
     * @return
     */
    private static <T> List<List<T>> split(List<T> list, int size) {
        List<List<T>> splitList = Lists.newArrayList();
        if (null == list || list.isEmpty()) {
            return splitList;
        }
        int count = 0;
        List<T> eachList = Lists.newArrayList();
        for (T data : list) {
            eachList.add(data);
            ++ count;
            if (eachList.size() >= size || count == list.size()) {
                splitList.add(eachList);
                eachList = Lists.newArrayList();
            }
        }
        return splitList;
    }


    /**
     * 将列表分割为多个列表操作，并将结果合并为一个列表，分割查询
     */
    public static <T, R> List<R> splitFlatMap(List<T> list, Function<List<T>, List<R>> mapFunc) {
        return CommonUtils.split(list).stream()
                .map(mapFunc)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    /**
     * 将列表分割为多个列表操作，并将结果合并为一个值（用于分割插入）
     */
    public static <T, R> R splitMapReduce(List<T> list, Function<List<T>, R> mapFunc, BinaryOperator<R> binaryOperator) {
        return CommonUtils.split(list).stream()
                .map(mapFunc)
                .reduce(binaryOperator)
                .orElse(null);
    }
    /**
     * 将列表分割为多个列表操作，并将结果合并为一个值（用于分割插入）,返回默认值
     */
    public static <T, R> R splitMapReduce(List<T> list, Function<List<T>, R> mapFunc, BinaryOperator<R> binaryOperator,R defualtValue) {
        return CommonUtils.split(list).stream()
                .map(mapFunc)
                .reduce(defualtValue, binaryOperator);
    }

    /**
     * 将列表转换为map的方法，value为对象自己
     * @param collection
     * @param keyFunc
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> toMap(Collection<V> collection, Function<V, K> keyFunc) {
        return collection.stream().collect(Collectors.toMap(keyFunc, Function.identity()));
    }

    /**
     * 将列表转换为map的方法，value自定义
     *
     * @param collection
     * @param keyFunc
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V,T> Map<K, V> toMap(Collection<T> collection, Function<T, K> keyFunc, Function<T, V> valueFunc) {
        return collection.stream().collect(Collectors.toMap(keyFunc, valueFunc));
    }

    /**
     * 将集合映射成列表
     */
    public static <T, R> List<R> map(Collection<T> collection, Function<T, R> mapFunc) {
        return collection.stream().map(mapFunc).collect(Collectors.toList());
    }

    /**
     * 将集合映射成列表
     */
    public static <T, R> List<R> mapDistinct(Collection<T> collection, Function<T, R> mapFunc) {
        return collection.stream().map(mapFunc).distinct().collect(Collectors.toList());
    }

    /**
     * 将集合映射成列表，扁平处理
     */
    public static <T, R> List<R> flatMap(Collection<T> collection, Function<T, Stream<R>> mapFunc) {
        return collection.stream().flatMap(mapFunc).collect(Collectors.toList());
    }

    /**
     * 过滤列表
     */
    public static <T> List<T> filter(Collection<T> collection, Predicate<T> predicate) {
        return collection.stream().filter(predicate).collect(Collectors.toList());
    }

    /**
     * 深kaob
     */
//    public static <T> List<T> deepCopy(List<T> source) {
//        return ExceptionUtils.tryCatch(()->{
//            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
//            ObjectOutputStream out = new ObjectOutputStream(byteOut);
//            out.writeObject(source);
//            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
//            ObjectInputStream in = new ObjectInputStream(byteIn);
//            List<T> dest = (List<T>) in.readObject();
//            return dest;
//        });
//    }





}
