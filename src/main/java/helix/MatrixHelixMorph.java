package helix;

public class MatrixHelixMorph {

    /**
     * @param inMatrix
     * @return a matrix that is morphed into a helix version of inMatrix
     */
    public static int[][] helix(int[][] inMatrix) {
        if (inMatrix == null) { return null; }
        int[][] outMatrix = new int[inMatrix.length][inMatrix[0].length];
        int[] flattenedArray = flatten(inMatrix);
        int[][] moves = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int flatIx = 0;
        int i = 0, j = 0;
        int index = 0;
        int right = inMatrix[0].length-1;
        int down = inMatrix.length-1;
        int left = 0;
        int up = 1;

        while (flatIx < flattenedArray.length) {
            outMatrix[i][j] = flattenedArray[flatIx++];

            if (index == 0 && j == right) {
                index = 1;
                right --;
            }

            if (index == 1 && i == down) {
                index = 2;
                down --;
            }

            if (index == 2 && j == left) {
                index = 3;
                left ++;
            }

            if (index == 3 && i == up) {
                index = 0;
                up ++;
            }

            i += moves[index][0];
            j += moves[index][1];
        }

        return outMatrix; //MODIFY THIS METHOD
    }

    public static int[] flatten(int[][] inMatrix) {
        int[] flattenedArray = new int[inMatrix.length * inMatrix[0].length];
        int index = 0;
        for (int row = 0; row < inMatrix.length; row++) {
            for (int col = 0; col < inMatrix[row].length; col++) {
                flattenedArray[index++] = inMatrix[row][col];
            }
        }
        return flattenedArray;
    }
}