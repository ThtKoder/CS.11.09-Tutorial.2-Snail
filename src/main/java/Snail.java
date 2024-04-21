import java.util.Arrays;

public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */

    public static int[] flattenSnail(int[][] array2d) {
        if(!isPerfectSquare(array2d)){
            return new int[0];
        }

        int element = array2d.length;
        int[] result = new int[element*element]; //total element number
        int index = 0;
        int x = 0;

        while (element > 0) {
            // top row
            for (int i = x; i < x + element; i++) {
                result[index++] = array2d[x][i];
            }
            // right col
            for (int i = x + 1; i < x + element; i++) {
                result[index++] = array2d[i][x + element - 1];
            }
            // bottom row
            for (int i = x + element - 2; i >= x; i--) {
                result[index++] = array2d[x + element - 1][i];
            }
            // left column
            for (int i = x + element - 2; i > x; i--) {
                result[index++] = array2d[i][x];
            }

            x++;  // move to the next layer
            element -= 2;  // the next layer is 2 rows/cols smaller
        }

        return result;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if(!isPerfectSquare(array1d)){
            return new int[0][0];
        }

        int[][] snailReturn = new int[(int) Math.sqrt(array1d.length)][(int) Math.sqrt(array1d.length)];
        int size = (int) Math.sqrt(array1d.length);
        int a1index = 0; //used as a continuous counter for array1's index
        int start = 0;  //to denote how many 'shells' have been completed
        int end = size - 1; //to denote the index of stopping for each col/row

        while (start <= end) {
            for (int i = start; i <= end; i++) {
                snailReturn[start][i] = array1d[a1index++];
            }
            for (int i = start + 1; i <= end; i++) {
                snailReturn[i][end] = array1d[a1index++];
            }
            for (int i = end - 1; i >= start; i--) {
                snailReturn[end][i] = array1d[a1index++];
            }
            for (int i = end - 1; i > start; i--) {
                snailReturn[i][start] = array1d[a1index++];
            }
            start++;
            end--;
        }

        return snailReturn;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        System.out.println(Arrays.toString(array1d));
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        System.out.println(Arrays.toString(array2d));
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        if(array1d == null){
            return false;
        }

        int length = array1d.length;
        double sqrt = Math.sqrt(length);
        return sqrt == Math.floor(sqrt);
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        if(array2d == null){
            return false;
        }

        int row = 0;
        while (row < array2d[0].length) {
            if (array2d[row].length != array2d.length) {
                return false;
            }
            row++;
        }

        return true;
    }

}

/*public static int[] flattenSnail(int[][] array2d) {
        //increment a value down by one first
        //

        int[] snailReturn = new int[array2d.length* array2d.length];
        int i = 0;

        for(int iterateTop: array2d[0]){
            snailReturn[i] += iterateTop;
            i++;
        }

        for(int j = 1; j < array2d.length; j++){
            snailReturn[i] += array2d[j][array2d.length-1];
            i++;
        }

        for(int k = array2d.length-2; k >= 0; k--){
            snailReturn[i] += array2d[array2d.length-1][k];
            i++;
        }

        for(int l = array2d.length-2; l > 0; l--){
            snailReturn[i] += array2d[l][0];
            i++;
        }

        for(int m = 1; m < array2d.length-1; m++){
            snailReturn[i] += array2d[1][m];
            i++;
        }

        System.out.println(Arrays.toString(snailReturn));

        return snailReturn;
    }*/