package com.seth.leetCode;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private int counter = 0;
    private boolean printZero = true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        while (counter <= n) {
            if(printZero) {
                printNumber.accept(0);
                printZero = false;
                if(counter == 0) {
                    counter++;
                }
                notifyAll();
            }
            else {
                wait();
            }
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while (counter <= n) {
            if(!printZero && counter % 2 == 0) {
                printNumber.accept(counter);
                printZero = true;
                counter++;
                notifyAll();
            }
            else {
                wait();
            }
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while (counter <= n) {
            if(!printZero && counter % 2 == 1) {
                printNumber.accept(counter);
                printZero = true;
                counter++;
                notifyAll();
            }
            else {
                wait();
            }
        }
    }
}
