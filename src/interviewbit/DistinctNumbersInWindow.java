package interviewbit;

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctNumbersInWindow {
    public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        if(B > A.size()) return new ArrayList<>();
        HashMap<Integer, Integer> valueByFrequency = new HashMap<>();
        ArrayList<Integer> distinct = new ArrayList<>();
        int i = 0;
        int j = 0;
        for (Integer integer : A) {
            if(i < B - 1){
                if(valueByFrequency.containsKey(integer)){
                    valueByFrequency.put(integer, valueByFrequency.get(integer) + 1);
                }
                else {
                    valueByFrequency.put(integer, 1);
                }
            }
            else {
                if(valueByFrequency.containsKey(integer)){
                    valueByFrequency.put(integer, valueByFrequency.get(integer) + 1);
                }
                else {
                    valueByFrequency.put(integer, 1);
                }
                distinct.add(valueByFrequency.size());
                int key = A.get(j);
                if(valueByFrequency.get(key) == 1){
                    valueByFrequency.remove(key);
                }
                else {
                    valueByFrequency.put(key, valueByFrequency.get(key) - 1);
                }
                j++;
            }
            i++;
        }
        return distinct;
    }
}
