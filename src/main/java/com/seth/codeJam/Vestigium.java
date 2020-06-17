package com.seth.codeJam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium
{

    public static void vestigium()
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = sc.nextInt();
        for (int i = 0; i < numberOfTests; i++) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int j = 0; j < n; j++)
            {
                for (int k = 0; k < n; k++) {
                    grid[j][k] = sc.nextInt();
                }
            }
            vestigium(grid ,n, i);
        }
        sc.close();
    }

    private static void vestigium(int[][] grid, int n, int caseNumber)
    {
        int traces = traces(grid, n);
        int repeatRow = repeatRow(grid);
        int repeatCol = repeatCol(grid);
        System.out.println("Case #" + (caseNumber + 1) + ": " + traces + " " + repeatRow + " " + repeatCol);
    }

    private static int traces(int[][] grid, int n)
    {
        int traces = 0;
        for (int i = 0; i < n; i++)
        {
            traces = traces + grid[i][i];
        }
        return traces;
    }

    private static int repeatRow(int[][] grid)
    {
        int repeatRow = 0;
        for (int[] row : grid)
        {
            repeatRow = repeatRow + repeatArray(row);
        }
        return repeatRow;
    }

    private static int repeatCol(int[][] grid)
    {
        int repeatCol = 0;
        for (int i = 0; i < grid.length; i++)
        {
            int[] array = new int[grid.length];
            for (int j = 0; j < grid.length; j++)
            {
                array[j] = grid[j][i];
            }
            repeatCol = repeatCol + repeatArray(array);
        }
        return repeatCol;
    }

    private static int repeatArray(int[] array)
    {
        Set<Integer> integerSet = new HashSet<>();
        for (int i : array)
        {
            if (integerSet.contains(i))
            {
                return 1;
            }
            integerSet.add(i);
        }
        return 0;
    }

}
