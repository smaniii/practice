package interviewbit;

import java.util.HashSet;
import java.util.List;

public class RepeatedNumber {
    public int repeatedNumber(final List<Integer> a) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer integer : a) {
            if(set.contains(integer)) return integer;
            set.add(integer);
        }
        return -1;
    }
}
