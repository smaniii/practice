package com.seth.extra;

import java.util.ArrayList;
import java.util.List;

public class ZombieGame {
    public int minHours(List<List<Integer>> grid) {
        if (!canWin(grid)) return -1;
        int hours = 0;
        while (!winThisRound(grid)) {
            hours++;
            grid = buildThisRoundGrid(grid);
        }
        return hours;
    }

    private boolean canWin(List<List<Integer>> grid) {
        if (grid == null || grid.isEmpty() || grid.get(grid.size() - 1).isEmpty()) return false;
        for (List<Integer> integers : grid) {
            for (Integer integer : integers) {
                if (integer == 1) return true;
            }
        }
        return false;
    }

    private boolean winThisRound(List<List<Integer>> grid) {
        for (List<Integer> integers : grid) {
            for (Integer integer : integers) {
                if (integer == 0) return false;
            }
        }
        return true;
    }

    private List<List<Integer>> buildThisRoundGrid(List<List<Integer>> lastRoundGrid) {
        List<List<Integer>> thisRoundGrid = new ArrayList<>();
        for (int i = 0; i < lastRoundGrid.size(); i++) {
            thisRoundGrid.add(new ArrayList<>());
            for (int j = 0; j < lastRoundGrid.get(i).size(); j++) {
                thisRoundGrid.get(i).add(0);
            }
        }
        for (int i = 0; i < lastRoundGrid.size(); i++) {
            for (int j = 0; j < lastRoundGrid.get(i).size(); j++) {
                if (lastRoundGrid.get(i).get(j) == 0) {
                    continue;
                }
                thisRoundGrid.get(i).set(j, 1);
                //up
                if (canAdd(lastRoundGrid, i + 1, j)) {
                    thisRoundGrid.get(i + 1).set(j, 1);
                }
                //down
                if (canAdd(lastRoundGrid, i - 1, j)) {
                    thisRoundGrid.get(i - 1).set(j, 1);
                }
                //right
                if (canAdd(lastRoundGrid, i, j + 1)) {
                    thisRoundGrid.get(i).set(j + 1, 1);
                }
                //left
                if (canAdd(lastRoundGrid, i, j - 1)) {
                    thisRoundGrid.get(i).set(j - 1, 1);
                }
            }
        }
        return thisRoundGrid;
    }

    private boolean canAdd(List<List<Integer>> grid, int row, int col) {
        return row >= 0 && row < grid.size() && col >= 0 && col < grid.get(row).size();
    }

}
