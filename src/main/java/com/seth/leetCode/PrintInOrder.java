package com.seth.leetCode;

public class PrintInOrder {
    public PrintInOrder() {

    }

    private boolean isFirstCalled = false;
    private boolean isSecondCalled = false;

    public synchronized void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        isFirstCalled = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {

        if(!isFirstCalled) wait();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        isSecondCalled = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {

        while (!isSecondCalled) {
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
