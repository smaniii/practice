package interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class RemoveElement {

    public static int removeElement(ArrayList<Integer> a, int b) {
        a.removeAll(Collections.singleton(b));
        return a.size();
    }

}
