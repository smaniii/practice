package interviewbit;

public class NumSetBits {
    public int numSetBits(long a) {
        int numberOfOnes = 0;
        for (int i = 0; i < 32; i++) {
            if( (((long) Math.pow(2, i)) & a) == ((long) Math.pow(2, i))) {
                numberOfOnes++;
            }
        }
        return numberOfOnes;
    }
}
