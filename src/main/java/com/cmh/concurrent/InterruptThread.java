package com.cmh.concurrent;

import org.junit.Test;

/**
 * Author: 起舞的日子
 * Date:2021/4/24 11:39 上午
 */
public class InterruptThread {

    @Test
    public void test(){
        Thread thread1 = new Thread("未中断");
        Thread thread2 = new Thread("sleep中断");
        thread1.start();
        thread2.start();
        boolean interrupted = Thread.currentThread().isInterrupted();
        System.out.println(interrupted);
    }
}
