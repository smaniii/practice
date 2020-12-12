package com.seth.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class maxmin
{
    /*
    STDIN     Function
-----     -----
4      →  operations[] size n = 4
push   →  operations = [push, push, push, pop]
push
push
pop
4      →  x[] size n = 4
1      →  x = [1, 2, 3, 1]
2
3
1
     */
    private static long min;
    private static long max;
    private static List<Long> products;
    private static List<Integer> elements;


    public static List<Long> maxMin(List<String> operations, List<Integer> x) {
        // Write your code here
        if (x == null || x.isEmpty()) {
            return new ArrayList<>();
        }
        min = x.get(0);
        max = x.get(0);
        products = new ArrayList<>();
        products.add(max * min);
        elements = new ArrayList<>();
        elements.add(x.get(0));
        for (int i = 1; i < operations.size(); i++) {
            int current = x.get(i);
            if ("push".equals(operations.get(i))) {
                elements.add(current);
                if (current > max) {
                    max = current;
                } else if (current < min) {
                    min = current;
                }
            } else {
                elements.remove(Integer.valueOf(current));
                if (current == max || current == min) {
                    findNewMaxOrMin();
                }
            }
            products.add(max * min);
        }
        return products;
    }

    private static void findNewMaxOrMin() {
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;
        for (int i = 0; i < elements.size(); i++)
        {
            int current = elements.get(i);
            if (current > max)
            {
                max = current;
            }
            if (current < min)
            {
                min = current;
            }
        }
    }


}
