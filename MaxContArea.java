import java.util.HashMap;

public class MaxContArea {

    private static int getLineLength(int[][] arr, int i, int j, int value, HashMap<String,Integer> hv, HashMap<String,Integer> hvChecker) {
        if (i >= 0 && j >= 0 && i < arr.length && j < arr[i].length) {
            String key = i + "" + j;
            if (hv.get(key) != null || arr[i][j] != value) {
                return 0;
            }
            hv.put(key, 1);
            hvChecker.put(key, 1);
            return 1 + getLineLength(arr, i+1, j, value, hv, hvChecker)
                    + getLineLength(arr, i-1, j, value, hv, hvChecker)
                    + getLineLength(arr, i, j+1, value, hv, hvChecker)
                    + getLineLength(arr, i, j-1, value, hv, hvChecker)
                    + getLineLength(arr, i+1, j+1, value, hv, hvChecker)
                    + getLineLength(arr, i-1, j-1, value, hv, hvChecker);
        } else return 0;
    }

    public static int maxContinuousArea(int[][] matrix) {
        HashMap<String,Integer> hv = new HashMap<String,Integer>();
        HashMap<String,Integer> hvChecker = new HashMap<String,Integer>();
        int max = 0;
        int maxTemp = 0;
        int i = 0;
        int j = 0;

        while (i < matrix.length) {
            while (j < matrix[i].length) {
                String key = i + "" + j;
                if (hvChecker.get(key) == null) {
                    maxTemp = getLineLength(matrix, i, j, matrix[i][j], hv, hvChecker);
                    if (maxTemp > max) {
                        max = maxTemp;
                    }
                    hv = new HashMap<String,Integer>();
                }
                j++;
            }
            j = 0;
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int [][] arr = {{1, 0, 0, 1, 0},
                        {0, 0, 1, 1, 1},
                        {1, 0, 0, 0, 1},
                        {0, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1}};
        System.out.println("largest continuous area : " + maxContinuousArea(arr));
        arr = new int[][] {{1,0,1,0,0},
                            {1,0,1,1,1},
                            {1,1,0,1,1},
                            {1,0,0,1,0}};
        System.out.println("largest continuous area : " + maxContinuousArea(arr));
        arr = new int[][] {{2,2,5,0,9},
                            {1,3,5,2,3},
                            {1,5,5,2,4},
                            {2,2,2,0,4}};
        System.out.println("largest continuous area : " + maxContinuousArea(arr));
    }
}