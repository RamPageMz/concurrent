package com.mazhen.concurrent.example.count;

import com.mazhen.concurrent.annotations.NotThreadSafe;
import com.mazhen.concurrent.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:     Ma Zhen
 * Date:       2018/08/27 20/01
 * <p>
 * Content:     CountExample2: 使用AtomicInteger封装count，使用incrementAndGet来代替++操作
 **/

@Slf4j
@ThreadSafe
public class CountExample2 {

    // 请求总数
    public static int clientTotal = 5000;

    // 并发线程总数
    public static int threadTotal = 200;

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await(); // 需要跑出异常
        executorService.shutdown();
        log.info("count:{}", count);

    }

    @ThreadSafe
    private static void add() {
        count.incrementAndGet(); // 相当于 ++count
        //count.getAndIncrement(); // 相当于 count++;
    }

}
