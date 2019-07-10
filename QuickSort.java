

/**
 *
 * @author Alhudaghifari with help from GeeksForGeeks
 */
public class QuickSort {
    
    private static void QuickSortAsc(int [] arr, int low, int high) {
        if (low < high) {
            int pi = partitionArray(arr, low, high);
            QuickSortAsc(arr, low, (pi - 1));
            QuickSortAsc(arr, (pi + 1), high);
        }
    }
    
    private static int partitionArray(int [] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1;
        int temp;
        for (int j=low;j<high;j++) {
            if (arr[j] <= pivot) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return (i+1);
    }
    
     /**
     * main program
     * @param args 
     */
    public static void main(String[] args) {
        int nElements = 20;
        int arr[] = new int[nElements];
        
        for(int i=0;i<nElements;i++) {
            arr[i] = (int)(nElements * Math.random());
        }
        arr = new int[]{ 10, 80, 30, 90, 40, 50, 70 };
        nElements = arr.length;
        System.out.println("Array before sorted");
        printArray(arr, 0, nElements);
        System.out.println("===========");
        QuickSortAsc(arr, 0, nElements - 1);
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
