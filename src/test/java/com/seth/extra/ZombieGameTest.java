package com.seth.extra;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZombieGameTest {

    private final ZombieGame zombieGame = new ZombieGame();

    @Test
    void zombieGameIsNull() {
        assertEquals(-1, zombieGame.minHours(null));
    }

    @Test
    void zombieGameIsEmpty() {
        assertEquals(-1, zombieGame.minHours(new ArrayList<>()));
    }

    @Test
    void zombieWinOnInput() {
        List<Integer> row0 = new ArrayList<>();
        row0.add(1);
        row0.add(1);
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(1);
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(row0);
        grid.add(row1);
        assertEquals(0, zombieGame.minHours(grid));
    }

    @Test
    void zombieWinTwoHours() {
        List<Integer> row0 = new ArrayList<>();
        row0.add(1);
        row0.add(0);
        List<Integer> row1 = new ArrayList<>();
        row1.add(0);
        row1.add(0);
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(row0);
        grid.add(row1);
        assertEquals(2, zombieGame.minHours(grid));
    }

}