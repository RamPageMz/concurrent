package com.mazhen.concurrent.example.sync;

import lombok.extern.slf4j.Slf4j;

/**
 * Author:     Ma Zhen
 * Date:       2018/08/28 16/10
 * <p>
 * Content:    SyncEx1:Synchronize
 **/
@Slf4j
public class SyncEx1 {

    public void test1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1-{}", i);
            }
        }
    }

    public synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2-{}", i);
        }
    }

    public static void main(String[] args) {

    }
}
