package interviewbit;

import java.util.*;

public class puzzles
{
    //Heads = true tails = false
    private static double puzzle()
    {
        Set<List<Boolean>> getRekSet = new HashSet<>();
        getRekSet.add(new ArrayList<>(Arrays.asList(false,true,true)));
        getRekSet.add(new ArrayList<>(Arrays.asList(false,true,false)));
        getRekSet.add(new ArrayList<>(Arrays.asList(true,false,true)));
        Set<List<Boolean>> redoSet = new HashSet<>();
        redoSet.add(new ArrayList<>(Arrays.asList(true,false,false)));
        redoSet.add(new ArrayList<>(Arrays.asList(false,false,true)));
        redoSet.add(new ArrayList<>(Arrays.asList(false,false,false)));
        Double winTimes = Double.valueOf(0);
        Double getRekTimes = Double.valueOf(0);
        for (int i = 0; i < 1000000; i++)
        {
            List<Boolean> genList = generateList(redoSet);
            if(getRekSet.contains(genList))
            {
                getRekTimes++;
            }
            else
            {
                winTimes++;
            }
        }

        return winTimes/(winTimes+getRekTimes);
    }

    private static List<Boolean> generateList(Set<List<Boolean>> redoSet)
    {
        List<Boolean> listGen = new ArrayList<>();
        for (int i = 0; i < 3; i++)
        {
            listGen.add(Math.random() > 0.5);
        }
        if(redoSet.contains(listGen))
        {
            return generateList(redoSet);
        }
        return listGen;
    }

    //Day start at 0
    private static int buyAndSellStock(int[] daysPrice)
    {
        if(daysPrice.length == 0 || daysPrice.length == 1)
        {
            throw new RuntimeException("Fail");
        }
        int profit = 0;
        int boughtPrice = 0;
        int sellPrice = 0;
        boolean isBought = false;
        for(int currentDay = 0; currentDay<daysPrice.length; currentDay++)
        {
            if(currentDay == daysPrice.length -1 && !isBought)
            {
                continue;
            }
            else if(currentDay == daysPrice.length -1 && isBought)
            {
                sellPrice = daysPrice[currentDay];
                profit = profit + (sellPrice - boughtPrice);
                boughtPrice=0;
                sellPrice=0;
            }
            else if (!isBought && daysPrice[currentDay] < daysPrice[currentDay + 1])
            {
                isBought = true;
                boughtPrice = daysPrice[currentDay];
            }
            else if (!isBought && daysPrice[currentDay] > daysPrice[currentDay + 1])
            {
                continue;
            }
            else if (isBought && daysPrice[currentDay] > daysPrice[currentDay + 1])
            {
                isBought = false;
                sellPrice = daysPrice[currentDay];
                profit = profit + (sellPrice - boughtPrice);
                boughtPrice=0;
                sellPrice=0;
            }
            else
            {
                continue;
            }

        }
        return profit;
    }


    public static int maxSubArray(final int[] A) {
        Map<Integer,Integer> maxSums = new HashMap<>();
        Integer subArrayMaxIntegerIndex = 0;
        maxSums.put(subArrayMaxIntegerIndex, 0);
        for(int i=0; i< A.length; i++){
            //def take
            if(A[i] >= 0){
                maxSums.put(subArrayMaxIntegerIndex, maxSums.get(subArrayMaxIntegerIndex) + A[i]);
            }
            //maybe take
            else if(maxSums.get(subArrayMaxIntegerIndex) >= A[i] && i< A.length-1 && A[i + 1] >= 0){
                maxSums.put(subArrayMaxIntegerIndex, maxSums.get(subArrayMaxIntegerIndex) + A[i]);
            }
            //don't take
            else {
                if(maxSums.get(subArrayMaxIntegerIndex) != null){
                    subArrayMaxIntegerIndex++;
                }
            }
        }
        final Integer[] maxSum = {0};
        maxSums.forEach((k, v)-> {
            if(maxSum[0] <= v){
                maxSum[0] = v;
            }
        });
        return maxSum[0];
    }

}
