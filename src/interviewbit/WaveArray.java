package interviewbit;

import java.util.ArrayList;
import java.util.Comparator;

public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        A.sort(Comparator.naturalOrder());
        for (int i = 0; i < A.size(); i = i + 2) {
            if(i + 1 < A.size()) {
                Integer temp = A.get(i);
                A.set(i, A.get(i + 1));
                A.set(i + 1, temp);
            }
        }
        return A;
    }
}
