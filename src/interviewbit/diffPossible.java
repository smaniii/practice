package interviewbit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class diffPossible {

    public static int diffPossible(final List<Integer> A, int B) {

        Map<Integer, Integer> numsByAppear = new HashMap<>();
        for (Integer num : A) {
            if(numsByAppear.containsKey(num)){
                numsByAppear.put(num, numsByAppear.get(num) + 1);
            }
            else {
                numsByAppear.put(num, 1);
            }
        }
        for (Integer num : A) {
            if(B == 0)
            {
                if(numsByAppear.get(num) > 1)
                {
                    return 1;
                }
            }
            else {
                if(numsByAppear.containsKey(num - B)) {
                    return 1;
                }
            }
        }

        return 0;
    }
}
