package com.seth.leetCode;

import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;
    private int counter = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (counter <= n) {
            if(counter % 3 == 0 && counter % 5 !=0) {
                printFizz.run();
                counter++;
                notifyAll();
            }
            else {
                wait();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (counter <= n) {
            if(counter % 5 == 0 && counter % 3 !=0) {
                printBuzz.run();
                counter++;
                notifyAll();
            }
            else {
                wait();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (counter <= n) {
            if(counter % 5 == 0 && counter % 3 == 0) {
                printFizzBuzz.run();
                counter++;
                notifyAll();
            }
            else {
                wait();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (counter <= n) {
            if(counter % 5 != 0 && counter % 3 != 0) {
                printNumber.accept(counter);
                counter++;
                notifyAll();
            }
            else {
                wait();
            }
        }
    }
}
