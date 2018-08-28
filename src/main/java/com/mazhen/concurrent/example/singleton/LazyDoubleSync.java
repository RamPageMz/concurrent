package com.mazhen.concurrent.example.singleton;

import com.mazhen.concurrent.annotations.NotThreadSafe;

/**
 * Author:     Ma Zhen
 * Date:       2018/08/28 18/58
 * <p>
 * Content:    Lazy: 单例模式 懒汉模式: sync  两次判断instance==nul
 **/

@NotThreadSafe
public class LazyDoubleSync {

    private LazyDoubleSync() {
        // do something
    }

    private static LazyDoubleSync instance = null;

    /**
     * 双重同步锁  但是 非线程安全！ 解决方法： 单例对象 instance申明为volatile，禁止指令重排
     *
     * @return
     */
    public static LazyDoubleSync getInstance() {
        if (instance == null) {
            synchronized (LazyDoubleSync.class) {
                instance = new LazyDoubleSync();
            }
        }
        return instance;
    }

}
