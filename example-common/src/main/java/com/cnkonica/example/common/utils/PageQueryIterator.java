package com.cnkonica.example.common.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class PageQueryIterator<T,K> implements Iterable<List<T>> {
    private static final Logger logger = LoggerFactory.getLogger(PageQueryIterator.class);
    private BiFunction<K, Integer, List<T>> queryFunc;
    private Function<T,K> lastKeyGetFunc;
    private Integer pageSize;
    private K lastKeyInitValue;

    public PageQueryIterator(BiFunction<K, Integer, List<T>> queryFunc, Function<T, K> lastKeyGetFunc, Integer pageSize) {
        this(queryFunc, lastKeyGetFunc, pageSize, null);
    }

    public PageQueryIterator(BiFunction<K, Integer, List<T>> queryFunc, Function<T, K> lastKeyGetFunc, Integer pageSize, K lastKeyInitValue) {
        this.queryFunc = queryFunc;
        this.lastKeyInitValue = lastKeyInitValue;
        this.pageSize = pageSize;
        this.lastKeyGetFunc = lastKeyGetFunc;
    }
    public Iterator<List<T>> iterator(){return new Itr();}
    public void forEach(Consumer<? super List<T>> action) {
        Objects.requireNonNull(action);
        K lastKey =lastKeyInitValue;
        logger.info("分页查询开始，pageSize = {}", pageSize);
        while (true) {
            List<T> result = queryFunc.apply(lastKey, pageSize);
            if (CollectionUtils.isEmpty(result)) {
                break;

            }
            lastKey = lastKeyGetFunc.apply(result.get(result.size() - 1));
            action.accept(result);
            logger.info("继续分页查询，lastKey = {},pageSize = {}", lastKey, pageSize);
        }

    }
    @Override
    public Spliterator<List<T>> spliterator(){throw new UnsupportedOperationException("spliterator");}
    private class Itr implements Iterator<List<T>> {
        private K lastKey = lastKeyInitValue;
        private List<T> nextCache = null;
        private boolean isFinished = false;
        @Override
        public boolean hasNext() {
            if (isFinished) {
                return false;
            }
            if (nextCache != null) {
                return true;
            }
            nextCache = queryFunc.apply(lastKey, pageSize);
            if (CollectionUtils.isEmpty(nextCache)) {
                isFinished = true;
                return false;
            }
            this.updateLastKey();
            return true;
        }

        private void updateLastKey() {
            this.lastKey = lastKeyGetFunc.apply(nextCache.get(nextCache.size() - 1));
        }

        @Override
        public List<T> next() {
            if (isFinished) {
                throw  new NoSuchElementException();
            }
            if (nextCache != null) {
                List<T> result = nextCache;
                nextCache = null;
                return result;
            }
            List<T> result = queryFunc.apply(lastKey, pageSize);
            if (CollectionUtils.isEmpty(result)) {
                isFinished = true;
                throw new NoSuchElementException();
            }
            this.updateLastKey();
            return result;
        }
    }
}
