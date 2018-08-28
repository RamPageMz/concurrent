package com.mazhen.concurrent.example.atomic;

import com.mazhen.concurrent.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Author:     Ma Zhen
 * Date:       2018/08/28 13/49
 * <p>
 * Content:    AtomicReferenceEx: 使用AtomicReference
 **/

@Slf4j
@ThreadSafe
public class AtomicReferenceEx {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0, 2);  // 0->2
        count.compareAndSet(0, 1);
        count.compareAndSet(1, 3);
        count.compareAndSet(2, 4);  // 2->4
        count.compareAndSet(3, 5);
        log.info("count:{}", count.get());
    }

}
