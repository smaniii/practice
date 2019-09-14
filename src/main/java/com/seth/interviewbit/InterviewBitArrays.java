package com.seth.interviewbit;

import java.util.*;
import java.util.List;

public class InterviewBitArrays
{
    public int coverPoints(int[] A, int[] B) {
        int aMin=0;
        int bMin=0;
        int aMax=0;
        int bMax=0;
        int total=0;
        for(int i=0; i<A.length - 1;i++){
            aMin = A[i];
            bMin = B[i];
            aMax = A[i+1];
            bMax = B[i+1];
            total = total + Math.max(Math.abs(aMax-aMin), Math.abs(bMax-bMin));
        }
        return  total;
    }

    public ArrayList<Integer> primesum(int n) {
        ArrayList<Integer> result = new ArrayList<>();

        double sqrt = Math.sqrt(n);
        for (int i = 2; i < n; i ++) {
            if (isPrime(i) && isPrime(n - i)) {
                result.add(i);
                result.add(n-i);
                return result;
            }
        }
        return result;
    }

    private boolean isPrime(int a) {
        if (a == 1) { return false; }

        for (int i = 2; i <= Math.pow(a, 0.5); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    //gcd using ecluid
    public int gcd(int A, int B){
        int larger;
        int smaller;
        if(A > B){
            larger = A;
            smaller = B;
        }
        else {
            larger = B;
            smaller = A;
        }
        return eculid(larger, smaller);
    }

    private int eculid(int higher, int lower) {
        if (lower == 0) {
            return higher;
        }
        int lower_temp = lower;
        lower = higher % lower;
        higher = lower_temp;
        return eculid(higher, lower);
    }

    public static int reverse(int A) {
        boolean isPositive = false;
        if(A >= 0 ){
            isPositive = true;
        }
        int absA = Math.abs(A);
        char[] charArrayA = String.valueOf(absA).toCharArray();
        int maxIndex = charArrayA.length - 1;
        int minIndex = 0;
        for(int i = minIndex; i<=maxIndex/2; i++){
            char tempFront = charArrayA[i];
            char tempBack = charArrayA[maxIndex-i];
            charArrayA[i] = tempBack;
            charArrayA[maxIndex - i] = tempFront;
        }
        long reversedLong = Long.valueOf(String.valueOf(charArrayA));
        int reversed = 0;
        if (reversedLong <= Integer.MAX_VALUE){
            reversed = ((int) reversedLong);
        }
        if(!isPositive){
            reversed = reversed * -1;
        }
        return reversed;
    }

    public static int maxSubArray(int[] A) {
        Map<Integer,Integer> maxSums = new HashMap<>();
        int forwardLookingValue = 0;
        Integer subArrayMaxIntegerIndex = 0;
        maxSums.put(subArrayMaxIntegerIndex, 0);
        for(int i=0; i< A.length; i++){
            //def take
            if(A[i] >= 0){
                maxSums.put(subArrayMaxIntegerIndex, maxSums.get(subArrayMaxIntegerIndex) + A[i]);
                forwardLookingValue = forwardLookingValue + A[i];
                continue;
            }

            boolean shouldContinue = false;
            for(int j=i;j<A.length; j++){
                if(maxSums.get(subArrayMaxIntegerIndex) + A[j] >= 0 && A[j] <= 0){
                    continue;
                }
                else if (A[j] >= 0){
                    shouldContinue=true;
                }
            }

            //maybe take
            if(shouldContinue){
                maxSums.put(subArrayMaxIntegerIndex, maxSums.get(subArrayMaxIntegerIndex) + A[i]);
                forwardLookingValue = forwardLookingValue + A[i];
            }
            //don't take
            else {
                if(maxSums.get(subArrayMaxIntegerIndex) != null){
                    subArrayMaxIntegerIndex++;
                    maxSums.put(subArrayMaxIntegerIndex, 0);
                    forwardLookingValue = 0;
                }
            }
        }
        final Integer[] maxSum = {0};
        maxSums.forEach((k, v)-> {
            if(maxSum[0] <= v){
                maxSum[0] = v;
            }
        });
        int highestVal = Integer.MIN_VALUE;
        if(maxSum[0] == 0){
            for(int i=0; i<A.length;i++){
                if(A[i] >= highestVal){
                    highestVal = A[i];
                }
            }
            return highestVal;
        }
        return maxSum[0];
    }

    public static int maxSubArrayByGrouping(int[] A) {
        List<Integer> groups = new ArrayList<>();
        Integer groupVal = 0;
        boolean lastIsPositive = true;
        if(A[0] < 0){
            lastIsPositive = false;
        }
        groupVal = A[0];
        for (int i=1;i<A.length;i++){
            if((lastIsPositive && A[i]<=0) || (!lastIsPositive && A[i]>=0)){
                lastIsPositive = !lastIsPositive;
                groups.add(groupVal);
                groupVal = A[i];
            }
            else if(lastIsPositive && A[i] >= 0){
                groupVal = groupVal + A[i];
            }
            else if(!lastIsPositive && A[i] <=0){
                groupVal = groupVal + A[i];
            }
        }
        groups.add(groupVal);
        final int[] maxSum = {0};
        List<Integer> maxSums = new ArrayList<>();
        int[] groupsArray = new int[groups.size()];
        final int[] j = {0};
        groups.forEach(group -> {
            groupsArray[j[0]] = group;
            j[0]++;
        });
        for (int i =0; i< groupsArray.length;i++){
            if(groupsArray[i] >= 0){
                maxSum[0] = maxSum[0] + groupsArray[i];
            }
            else if((maxSum[0] + groupsArray[i]) >= 0 && i<groupsArray.length -1 && (groupsArray[i + 1] + groupsArray[i]) >= 0){
                maxSum[0] = maxSum[0] + groupsArray[i];
            }
            else {
                maxSums.add(maxSum[0]);
                maxSum[0] = 0;
            }
        }
        maxSums.forEach(sum -> {
            if(sum > maxSum[0]){
                maxSum[0] = sum;
            }
        });
        if(maxSum[0] <= 0){
            Integer largestInList = Integer.MIN_VALUE;
            for(int i=0; i<A.length;i++){
                if(A[i] > largestInList){
                    largestInList = A[i];
                }
            }
            return largestInList;
        }
        return maxSum[0];
    }

    public int isPalindrome(int A) {
        int isPalindrome = 1;
        if(A < 0){
            return 0;
        }
        String stringA = String.valueOf(A);
        for(int i=0;i<stringA.length()/2; i++){
            if(stringA.charAt(i) != stringA.charAt(stringA.length() -1 - i)){
                isPalindrome = 0;
            }
        }
        return isPalindrome;
    }

}
