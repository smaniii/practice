package interviewbit;

public class PrettyPrint {

    public static int[][] prettyPrint(int A) {

        int numRowsAndCol = (A*2-1);

        int[][] prettyPrint = new int[numRowsAndCol][numRowsAndCol];

        for (int i=0; i<numRowsAndCol;i++) {
            if(i<=numRowsAndCol/2){
                for(int j=0; j<=numRowsAndCol/2; j++) {
                    if(i==0 || j==0){
                        prettyPrint[i][j] = A;
                        System.out.print(prettyPrint[i][j]);
                        continue;
                    }
                    prettyPrint[i][j] = Math.max(A-j, A-i);
                    System.out.print(prettyPrint[i][j]);
                }
                for(int j=(numRowsAndCol/2 + 1); j< numRowsAndCol; j++) {
                    if(i==0 || j==numRowsAndCol-1){
                        prettyPrint[i][j] = A;
                        System.out.print(prettyPrint[i][j]);
                        continue;
                    }
                    prettyPrint[i][j] = Math.max(A-(numRowsAndCol - j) + 1, A-i);
                    System.out.print(prettyPrint[i][j]);
                }
            }
            else if(i > numRowsAndCol/2){
                for(int j=0; j<=numRowsAndCol/2; j++) {
                    if(i == numRowsAndCol-1 || j==0){
                        prettyPrint[i][j] = A;
                        System.out.print(prettyPrint[i][j]);
                        continue;
                    }
                    prettyPrint[i][j] = Math.max(A-j, i -A + 2);
                    System.out.print(prettyPrint[i][j]);
                }
                for(int j=(numRowsAndCol/2 + 1); j< numRowsAndCol; j++) {
                    if(i == numRowsAndCol-1 || j==numRowsAndCol-1){
                        prettyPrint[i][j] = A;
                        System.out.print(prettyPrint[i][j]);
                        continue;
                    }
                    prettyPrint[i][j] = Math.max(A-(numRowsAndCol - j) + 1, i -A + 2);
                    System.out.print(prettyPrint[i][j]);
                }
            }
            System.out.println();
        }

        return prettyPrint;
    }

}
