package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class permute {

    public static void runThePermute(){
        Integer[] a = new Integer[]{1, 2, 3};
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(a));
        System.out.println(permute(A));
    }

    private static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        Integer[] intArr = new Integer[A.size()];
        for (int i = 0; i< A.size(); i++){
            intArr[i] = A.get(i);
        }
        ArrayList<ArrayList<Integer>> perms = new ArrayList<>();
        permute(intArr, 0, perms);
        return perms;
    }
    private static void permute(Integer[] intArr, int current, ArrayList<ArrayList<Integer>> perms){
        if(intArr.length == current){
            perms.add(new ArrayList<>(Arrays.asList(intArr)));
        }
        else {
            for(int i = current; i < intArr.length; i++){
                swap(intArr, current, i);
                permute(intArr, current + 1, perms);
                swap(intArr, current, i);
            }
        }
    }

    private static void swap(Integer[] intArr, int i, int j)
    {
        Integer temp;
        temp = intArr[i];
        intArr[i] = intArr[j];
        intArr[j] = temp;
    }
}
