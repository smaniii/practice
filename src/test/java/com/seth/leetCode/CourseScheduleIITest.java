package com.seth.leetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleIITest {
    CourseScheduleII courseScheduleII = new CourseScheduleII();
    @Test
    void findOrder() {
        int courses = 3;
        int[][] pre = new int[][] {{0, 1}, {0, 2}, {1, 2}};
        courseScheduleII.findOrder(3, pre);
    }
}