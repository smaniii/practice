package MikeQuestions;

public class MonotonicArray {
    enum PreState {
        LOWER,
        HIGHER,
        SAME
    }
    public boolean isMonotonic(int[] A) {
        PreState preState = PreState.SAME;
        if(A.length < 2) return true;
        int preNumber = A[0];
        for (int i = 1; i < A.length; i++) {
            if(preState.equals(PreState.SAME) && A[i] > preNumber) {
                preState = PreState.LOWER;
                preNumber = A[i];
            }
            else if(preState.equals(PreState.SAME) && A[i] < preNumber) {
                preState = PreState.HIGHER;
                preNumber = A[i];
            }
            else if(preState.equals(PreState.HIGHER) && A[i] > preNumber) {
                return false;
            }
            else if(preState.equals(PreState.HIGHER) && A[i] < preNumber) {
                preNumber = A[i];
            }
            else if(preState.equals(PreState.LOWER) && A[i] > preNumber) {
                preNumber = A[i];
            }
            else if(preState.equals(PreState.LOWER) && A[i] < preNumber) {
                return false;
            }
        }
        return true;
    }
}
