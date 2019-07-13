
import java.util.Stack;

public class MaxRectangleArea {

    /**
     * This method is to get maximum area in a histogram
     * @param histogram histogram
     * @param n length of the histogram
     * @return max area
     */
    private static int getMaxAreaInHistogram(int histogram[], int n) {
        int maximumArea = 0;
        int topvalue;
        int areatop;
        Stack<Integer> myStack = new Stack<>();
        int index = 0;
        while (index < n) {
            if (myStack.empty() || histogram[myStack.peek()] <= histogram[index])
                myStack.push(index++);
            else {
                topvalue = myStack.peek();
                myStack.pop();
                int val;
                if (myStack.empty())
                    val = index;
                else
                    val = index - myStack.peek() - 1;
                areatop = histogram[topvalue] * val;
                if (maximumArea < areatop)
                    maximumArea = areatop;
            }
        }

        while (!myStack.empty()) {
            topvalue = myStack.peek();
            myStack.pop();
            int val;
            if (myStack.empty())
                val = index;
            else
                val = index - myStack.peek() - 1;
            areatop = histogram[topvalue] * val;
            if (maximumArea < areatop)
                maximumArea = areatop;
        }

        return maximumArea;
    }

    /**
     * call this to get max Rectangle in a Matrix
     */
    public static int maxRect(int[][] arr) {
        int valueTemp[] = new int[arr[0].length];
        int maxArea = -1;
        int valueArea;

        for (int index=0;index<arr.length;index++) {
            for (int j=0;j<arr[0].length;j++) {
                if (arr[index][j] != 0) {
                    valueTemp[j] += arr[index][j];
                } else {
                    valueTemp[j] = 0;
                }
            }
            valueArea = getMaxAreaInHistogram(valueTemp, valueTemp.length);
            if (valueArea >= maxArea) {
                maxArea = valueArea;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 0, 1, 0, 1},
                        {0, 0, 1, 1, 1},
                        {1, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1},
                        {1, 0, 0, 0, 1}};
        int maxRect = maxRect(arr);
        System.out.println("Maximum rectangle : " + maxRect);
    }
}