package com.seth.MikeQuestions;

import org.jetbrains.annotations.NotNull;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        List<Point> pointList = new ArrayList<>();
        for (int[] ints : points) {
            Point point = new Point(ints[0], ints[1]);
            pointList.add(point);
        }
        pointList.sort(Comparator.reverseOrder());
        List<Point> solutions = new ArrayList<>();
        for (int i = 0; i < pointList.size(); i++) {
            if(i < K) {
                solutions.add(pointList.get(i));
            }
        }
        int[][] solution = new int[solutions.size()][2];
        for (int i = 0; i < solutions.size(); i++) {
            solution[i][0] = solutions.get(i).x;
            solution[i][1] = solutions.get(i).y;
        }
        return solution;
    }

    private class Point implements Comparable<Object>, Comparator {
        private int x;
        private int y;
        private double distance;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = Point2D.distance(0, 0, x, y);
        }

        @Override
        public int compareTo(@NotNull Object o) {
            return Double.compare(((Point) o).distance, this.distance);
        }

        @Override
        public int compare(Object o1, Object o2) {
            return Double.compare(((Point) o1).distance, ((Point) o2).distance);
        }
    }

}
