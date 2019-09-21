package com.seth.leetCode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZeroEvenOddTest {
    @Test
    public void testZeroEvenOdd() throws InterruptedException {
        List<Integer> expectedValues = Arrays.asList(0, 1, 0, 2);
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        IntConsumerImpl intConsumer = new IntConsumerImpl();
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        thread.start();
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        thread2.start();
        Thread thread3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        thread3.start();
        assertEquals(expectedValues, intConsumer.realValues);
    }

}
class IntConsumerImpl implements IntConsumer {
    List<Integer> realValues = new ArrayList<>();
    @Override
    public void accept(int value) {
        System.out.println(value);
        realValues.add(value);
    }
}