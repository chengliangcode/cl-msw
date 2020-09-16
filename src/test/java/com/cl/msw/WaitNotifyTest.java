package com.cl.msw;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitNotifyTest {

    private static List<String> waitList = new LinkedList<>();
    private static List<String> notifyList = new LinkedList<>();

    private static Object lock = new Object();

    public static void main(String[] args) throws Exception {

        for (int i = 1; i < 50; i++) {
            String threadName = i + "";
            new Thread(() -> {
                synchronized (lock) {
                    String name = Thread.currentThread().getName();
                    try {
                        System.out.println(name + "在等待");
                        waitList.add(name);
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name + "被唤醒");
                    notifyList.add(name);
                }
            }, threadName).start();
//            TimeUnit.MILLISECONDS.sleep(50);
        }

        // 等待以上线程启动
        TimeUnit.SECONDS.sleep(1);


        for (int i = 0; i < 50; i++) {
            synchronized (lock) {
                lock.notify();
            }
        }

        // 等待以上线程唤醒
        TimeUnit.SECONDS.sleep(1);
        System.out.println("等待：" + waitList);
        System.out.println("----------------------");
        System.out.println("唤醒：" + notifyList);
    }

}