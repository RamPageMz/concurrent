package com.mazhen.concurrent.example.singleton;

import com.mazhen.concurrent.annotations.Recommend;
import com.mazhen.concurrent.annotations.ThreadSafe;

/**
 * Author:     Ma Zhen
 * Date:       2018/08/28 18/58
 * <p>
 * Content:    Lazy: 使用内部Enum 绝对保证只初始化一次
 **/

@ThreadSafe
@Recommend
public class Singleton {

    private Singleton() {

    }

    public static Singleton getInstance() {
        return Single.INSTANCE.getInstance();
    }

    private enum Single {
        INSTANCE;

        private Singleton singleton;

        // JVM 绝对保证这个方法只执行一次
        Single() {
            singleton = new Singleton();
        }

        public Singleton getInstance() {
            return singleton;
        }
    }

}
