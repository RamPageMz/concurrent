package com.mazhen.concurrent.example.atomic;

import com.mazhen.concurrent.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Author:     Ma Zhen
 * Date:       2018/08/28 13/59
 * <p>
 * Content:    AtomicIntegerFieldEx: 使用AtomicIntegerField来绑定count  volatile
 *
 * AtomicIntegerFieldUpdater原子性更改某个对象的某个属性，因此该属性需要用volatile来定义
 **/

@Slf4j
@ThreadSafe
public class AtomicIntegerFieldEx {

    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldEx> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldEx.class, "count");

    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {
        AtomicIntegerFieldEx atomicIntegerFieldEx = new AtomicIntegerFieldEx();

        if (updater.compareAndSet(atomicIntegerFieldEx, 100, 120)) {
            log.info("success 1,{}", atomicIntegerFieldEx.getCount());   // 执行
        } else {
            log.info("fail 1,{}", atomicIntegerFieldEx.getCount());
        }

        if (updater.compareAndSet(atomicIntegerFieldEx, 100, 120)) {
            log.info("success 2,{}", atomicIntegerFieldEx.getCount());
        } else {
            log.info("fail 2,{}", atomicIntegerFieldEx.getCount());      // 执行
        }
    }

}
