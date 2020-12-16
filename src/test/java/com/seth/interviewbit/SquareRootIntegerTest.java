package com.seth.interviewbit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareRootIntegerTest {
    SquareRootInteger squareRootInteger = new SquareRootInteger();
    @Test
    void sqrt() {
        squareRootInteger.sqrt(2147483647);
    }
}