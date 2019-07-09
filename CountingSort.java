
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alhudaghifari
 */
public class CountingSort {
    /**
     * Call this method to sort array using counting sort algorithm
     * @param arr array
     */
    private static void CountingSortAsc(int [] arr) {
        HashMap<Integer,Integer> hashValue = new HashMap<Integer,Integer>();
        int tot;
        for (int i=0;i<arr.length;i++) {
            if (hashValue.get(arr[i]) == null) {
                hashValue.put(arr[i], 1);
            } else {
                tot = hashValue.get(arr[i]);
                tot++;
                hashValue.put(arr[i], tot);
            }
        }
        int i = 0;
        for (Map.Entry me : hashValue.entrySet()) {
            if ((int) me.getValue() == 1) {
                arr[i] = (int) me.getKey();
                i++;
            } else {
                int iterate = 0;
                int key = (int) me.getKey();
                tot = (int) me.getValue();
                while (iterate < tot) {
                    arr[i] = key;
                    i++;
                    iterate++;
                }
            }
        }
    }
    
     /**
     * main program
     * @param args 
     */
    public static void main(String[] args) {
        int nElements = 10;
        int arr[] = new int[nElements];
        
        for(int i=0;i<nElements;i++) {
            arr[i] = (int)(nElements * Math.random());
        }
        
        System.out.println("Array before sorted");
        printArray(arr, 0, nElements);
        CountingSortAsc(arr);
        System.out.println("Array after sorting");
        printArray(arr, 0, nElements);
    }
    
    /**
     * print your array from index low to high
     * @param arr array
     * @param low index low
     * @param high index high
     */
    private static void printArray(int[] arr, int low, int high) {
        System.out.print("[");
        for (int i=low;i<high;i++) {
            System.out.print(arr[i]);
            if (i != high-1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}
