package com.liemartt.pr_1;

import java.lang.reflect.Array;

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
