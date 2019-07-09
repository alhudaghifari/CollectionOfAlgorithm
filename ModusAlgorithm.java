
import java.util.HashMap;

/**
 *
 * @author Alhudaghifari
 */
public class ModusAlgorithm {
    
    public static int getMode(int [] arr) {
        HashMap<Integer,Integer> hashValue = new HashMap<Integer,Integer>();
        int tot;
        int max = 1;
        int temp = 0;
        
        for (int i=0;i<arr.length;i++) {
            if (hashValue.get(arr[i]) == null) {
                hashValue.put(arr[i], 1);
            } else {
                tot = hashValue.get(arr[i]);
                tot++;
                hashValue.put(arr[i], tot);
                if (tot > max) {
                    max = tot;
                    temp = arr[i];
                }
            }
        }
        return temp;
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
        
        printArray(arr, 0, nElements);
        System.out.println("Modus : " + getMode(arr));
    }
}
