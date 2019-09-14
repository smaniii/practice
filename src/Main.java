import MikeQuestions.KClosestPointsToOrigin;
import MikeQuestions.MonotonicArray;
import jamesQuestions.FloodFill;
import jamesQuestions.ThreeSum;

public class Main {

    public static void main(String[] args) {
        int[][] nums = {{3, 3}, {5, -1}, {-2, 4}};
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        System.out.println(kClosestPointsToOrigin.kClosest(nums, 2));
    }
}
