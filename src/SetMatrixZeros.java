import java.util.*;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        System.out.println(Arrays.deepToString(setMatrixZerosBruteForce(matrix)));
    }

    public static int[][] setMatrixZerosBruteForce(int[][] matrix) {
        int numRows = matrix.length;
        int numColumns = matrix[0].length;
        Set<Integer> markedRows = new HashSet<>();
        Set<Integer> markedColumns = new HashSet<>();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (matrix[i][j] == 0) {
                    markedRows.add(i);
                    markedColumns.add(j);
                }
            }
        }

        for (int element : markedRows) {
            for (int i = 0; i < numColumns; i++) {
                matrix[element][i] = 0;
            }
        }
        for (int element : markedColumns) {
            for (int i = 0; i < numRows; i++) {
                matrix[i][element] = 0;
            }
        }
        return matrix;
    }
    public void setZeroesOptimal(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        int rows[]=new int[r];
        int cols[]=new int[c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    rows[i]=1;
                    cols[j]=1;
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(rows[i]==1 || cols[j]==1){
                    matrix[i][j]=0;
                }
            }
        }

    }
}
