package com.seth.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class RecoverTree {
    List<Integer> integerList = new ArrayList<>();
    public int[] recoverTree(TreeNode A) {
        int[] answer = new int[2];
        inOrder(A);
        int first = 0;
        int second = 0;
        int index = 0;
        for(int i=1; i<integerList.size(); i++){
            if(integerList.get(i) < integerList.get(i-1)){
                first = integerList.get(i-1);
                second = integerList.get(i);
                index = i;
                break;
            }
        }
        for(int i=index+1; i<integerList.size(); i++){
            if(integerList.get(i) < integerList.get(i-1)){
                second = integerList.get(i);
                break;
            }
        }
        if(first > second){
            int temp = second;
            second = first;
            first = temp;
        }
        answer[0] = first;
        answer[1] = second;
        return answer;
    }

    public void inOrder(TreeNode a) {
        if (a == null) return;
        inOrder(a.left);
        integerList.add(a.val);
        inOrder(a.right);
    }
}
