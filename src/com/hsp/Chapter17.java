/*
 * Copyright (c) 2024. All rights reserved.
 */

package com.hsp;

/**
 * @Author： zangaiyao
 * @Date： 2024/5/1 15:41
 * @Describe：
 */
public class Chapter17 {
    void testP780(){
        Cat_ cat = new Cat_();
        cat.start();
        Tiger tiger = new Tiger();
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }





}

// 1. 继承 Thread 类创建线程
class Cat_ extends Thread{

    int times = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("miaomiaojiao" + ++times + " " + Thread.currentThread().getName());

            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 100){break;}
        }
    }
}

// 2. 实现 Runnable 接口创建线程
class Animal{

}

class Tiger extends Animal implements Runnable{

    @Override
    public void run() {
        System.out.println("Tiger is preying..."+ " " + Thread.currentThread().getName());
    }
}


//线程代理，模仿极简的Thread类
class ThreadProxy implements Runnable{
    private Runnable target = null;

    @Override
    public void run() {
        if (target!=null){
            target.run();
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start(){
        start0();//真正实现多线程方法
    }

    public void start0(){
        run();
    }
}