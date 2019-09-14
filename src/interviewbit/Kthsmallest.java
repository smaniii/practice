package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kthsmallest {

    public static int kthsmallest(final List<Integer> A, int B) {

        List<Integer> sortedList = new ArrayList<>(A);
        Collections.sort(sortedList);
        return sortedList.get(B - 1);
    }

}
