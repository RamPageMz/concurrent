package com.mazhen.concurrent.example.singleton;

import com.mazhen.concurrent.annotations.NotRecommend;
import com.mazhen.concurrent.annotations.NotThreadSafe;
import com.mazhen.concurrent.annotations.ThreadSafe;

/**
 * Author:     Ma Zhen
 * Date:       2018/08/28 18/58
 * <p>
 * Content:    Lazy: 单例模式 懒汉模式  sync方法使得线程安全
 **/

@ThreadSafe
@NotRecommend
public class LazySafe {

    private LazySafe() {
        // do something
    }

    private static LazySafe instance = null;

    /**
     * sync 性能低下
     * @return
     */
    public synchronized static LazySafe getInstance() {
        if (instance == null) {         // 两个线程同时访问到 instance为null  同时赋值两次
            instance = new LazySafe();
        }
        return instance;
    }

}
