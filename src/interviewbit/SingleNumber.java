package interviewbit;

import java.util.List;

public class SingleNumber {
    public int singleNumber(final List<Integer> A) {
        int single = 0;
        for (Integer a : A) {
            single = single^a;
        }
        return single;
    }
}
