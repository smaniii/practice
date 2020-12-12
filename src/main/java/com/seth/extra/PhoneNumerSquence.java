package com.seth.extra;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumerSquence {
    /*

1 2 3
4 5 6
7 8 9
* 0 #
11

12, 14, 21, 23, 25, 23 .... => 26

*/

    /*
    feedback
    1. go right into the code part
      do a walk through of the solution
    2. pros and cons of brute force and time complexity
      think about optimization memoization for recursive
      code structure, talk about how to abstract things
      helper methods for checking valid spaces (code readablity)
    3. must be fast helps to go through the problem and run through the logic before going through the code
      always problem solve first
    */
    private static char[][] arr = {
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {'*', 0, '#'}
    };

    public static void t(String[] args) {
        int sequenceToFind = 2;
        int total = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                total = total + findSequence(arr, sequenceToFind, i, j, new ArrayList<>());
            }
        }
        System.out.println(total);
    }

    private static int findSequence(char[][] arr, int sequenceToFind, int i, int j, List<Character> charList) {
        if (i < 0 || j < 0 || i >= 4 || j >= 3 || arr[i][j] == '*' || arr[i][j] == '#') {
            return 0;
        } else if (sequenceToFind == 1) {
            System.out.println(charList);
            return 1;
        }
        int total = 0;
        if (i - 1 > 0) {
            charList.add(arr[i][j]);
            total = total + findSequence(arr, sequenceToFind - 1, i - 1, j, charList);
            charList.remove(charList.size() - 1);
        }
        if (j - 1 > 0) {
            charList.add(arr[i][j]);
            total = total + findSequence(arr, sequenceToFind - 1, i, j - 1, charList);
            charList.remove(charList.size() - 1);
        }
        if (i + 1 < 4) {
            charList.add(arr[i][j]);
            total = total + findSequence(arr, sequenceToFind - 1, i + 1, j, charList);
            charList.remove(charList.size() - 1);
        }
        if (j + 1 < 3) {
            charList.add(arr[i][j]);
            total = total + findSequence(arr, sequenceToFind - 1, i, j + 1, charList);
            charList.remove(charList.size() - 1);
        }
        return total;
    }
}

