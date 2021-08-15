package com.cnkonica.example.common.utils;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class TryCathes<T> {
    private static final TryCathes<?> EMPTY = new TryCathes<>();
    private final T value;
    private final Exception exception;
    private TryCathes(){
        this.value=null;
        this.exception = null;
    }
    private TryCathes(T value){
        this.value=value;
        this.exception = null;
    }
    private TryCathes(Exception exception){
        this.value=null;
        this.exception = exception;
    }

    public static <T> TryCathes<T> of(ThrowableSupplier<T> supplier) {
        try {
            return new TryCathes<>(supplier.get());
        } catch (Exception e) {
            return new TryCathes<>(e);
        }
    }
    public static <T> TryCathes<T> run(ThrowableRunnable runnable) {
        try {
            runnable.run();
            return empty();
        } catch (Exception e) {
            return new TryCathes<>(e);
        }
    }

    private static <T> TryCathes<T> empty() {
        @SuppressWarnings("unchecked")
        TryCathes<T> t = (TryCathes<T>) EMPTY;
        return t;
    }
    public boolean isSuccess(){
        return exception == null;}
    public boolean isFailure(){
        return exception != null;
    }

    public T get(){
        if (isSuccess()) {
            return value;
        }
        doThrow(exception);
        return null;
    }

    private <X extends Exception> void doThrow(Exception exception) throws X{
        throw (X) exception;
    }

    public T orElse(T other) {
        return isSuccess() ? value : other;
    }

    public T orElseGet(Function<? super Exception, ? extends T> function) {
        return isSuccess() ? value : function.apply(exception);
    }
    public <X extends Throwable> T orElseThrow(Function<? super Exception,?extends X> function) throws X {
        if (isSuccess()) {
            return value;
        } else {
            throw  function.apply(exception);
        }
    }

    public <R> TryCathes<R> map(ThrowableFunction<? super T, ? extends R> function) {
        if (isFailure()) {
            return new TryCathes<>(exception);
        }
        try {

            return new TryCathes<>(function.apply(value));
        } catch (Exception e) {
            return new TryCathes<>(e);
        }


    }


    public <R> TryCathes<R> flatMap(ThrowableFunction<? super T, TryCathes<R>> function) {
        if (isFailure()) {
            return new TryCathes<>(exception);
        }
        try {

            return function.apply(value);
        } catch (Exception e) {
            return new TryCathes<>(e);
        }
    }

    public TryCathes<T> filter(ThrowableFunction<? super T, Boolean> predicate) {
        if (isFailure()) {
            return this;
        }
        try {
            if (predicate.apply(value)) {
                return this;
            } else {
                return empty();
            }
        } catch (Exception e) {
            return new TryCathes<>(e);
        }





    }

    public void ifSuccess(Consumer<? super T> consumer) {
        if (isSuccess()) {
            consumer.accept(value);

        }
    }

    public void ifFailure(Consumer<? super Exception> consumer) {
        if (isSuccess()) {
            consumer.accept(exception);

        }
    }

    public void ifSuccessElse(Consumer<? super T> successConsumer, Consumer<? super Exception> exceptionConsumer) {
        if (isSuccess()) {
            successConsumer.accept(value);
        } else {
            exceptionConsumer.accept(exception);

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryCathes<?> tryCathes = (TryCathes<?>) o;
        return Objects.equals(value, tryCathes.value) &&
                Objects.equals(exception, tryCathes.exception);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, exception);
    }

    @Override
    public String toString() {
        return isSuccess() ? String.format("TryCatches %s", value) : String.format("TryCatches %s", exception);
    }

    @FunctionalInterface
    public interface ThrowableSupplier<T> {
        T get() throws Exception;
    }
    @FunctionalInterface
    public interface ThrowableFunction<T,R>{
        R apply(T t) throws Exception;
    }
    @FunctionalInterface
    public interface ThrowableRunnable{
        void run() throws Exception;
    }



}
