package com.seth.jamesQuestions;

public class FloodFill {

    static boolean[][] visited;

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        visited = new boolean[image.length][image[0].length];
        return fill(image, sr, sc, newColor);
    }

    public static int[][] fill(int[][] image, int sr, int sc, int newColor) {
        visited[sr][sc] = true;
        int currentColor = image[sr][sc];
        image[sr][sc] = newColor;
        if(image.length > (sr + 1) && image[(sr + 1)][sc] == currentColor && !visited[(sr + 1)][sc]) {
            fill(image, (sr + 1), sc, newColor);
        }
        if(sr > 0 && image[(sr - 1)][sc] == currentColor && !visited[(sr - 1)][sc]) {
            fill(image, (sr - 1), sc, newColor);
        }
        if(image[0].length > (sc + 1) && image[sr][(sc + 1)] == currentColor && !visited[sr][sc + 1]) {
            fill(image, sr, (sc + 1), newColor);
        }
        if(sc > 0 && image[sr][(sc -1)] == currentColor && !visited[sr][sc - 1]) {
            fill(image, sr, (sc - 1), newColor);
        }
        return image;
    }

}
