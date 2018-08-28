package com.mazhen.concurrent.example.singleton;

import com.mazhen.concurrent.annotations.ThreadSafe;

/**
 * Author:     Ma Zhen
 * Date:       2018/08/28 19/01
 * <p>
 * Content:    Eager: 单例模式 饿汉模式：static块
 **/

@ThreadSafe
public class EagerSafe {
    private EagerSafe() {
        // do something
    }

    private static EagerSafe instance;

    static {
        instance = new EagerSafe();
    }

    /**
     * 如果Eager(){}构造方法的内容较复杂，性能较低；如果调用次数少，容易浪费资源
     *
     * @return
     */
    public static EagerSafe getInstance() {
        return instance;
    }
}
