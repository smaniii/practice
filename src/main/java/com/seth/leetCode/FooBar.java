package com.seth.leetCode;

class FooBar {
    private int n;
    private boolean shouldPrintBar = false;

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if(shouldPrintBar) wait();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            shouldPrintBar = true;
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if(!shouldPrintBar) wait();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            shouldPrintBar = false;
            notifyAll();
        }
    }
}
