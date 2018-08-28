package com.mazhen.concurrent.example.singleton;

import com.mazhen.concurrent.annotations.NotThreadSafe;

/**
 * Author:     Ma Zhen
 * Date:       2018/08/28 18/58
 * <p>
 * Content:    Lazy: 单例模式 懒汉模式:调用时候在加载
 **/

@NotThreadSafe
public class Lazy {

    private Lazy() {
        // do something
    }

    private static Lazy instance = null;

    /**
     * 两个线程同时访问到 instance为null  同时赋值两次
     * @return
     */
    public static Lazy getInstance() {
        if (instance == null) {         // 两个线程同时访问到 instance为null  同时赋值两次
            instance = new Lazy();
        }
        return instance;
    }

}
