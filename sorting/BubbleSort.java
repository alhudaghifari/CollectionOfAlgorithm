
/**
 * created in July 9, 2019
 * @author Alhudaghifari
 */
public class BubbleSort {
    /**
     * this method used to sorting array using bubble sort method
     * @param arr array
     * @param low min index
     * @param high max index
     */
    private static void bubbleSortAsc(int [] arr, int low, int high) {
        int temp;
        for (int i=low;i<high;i++) {
            for (int j=low;j<high;j++) {
                if (arr[j] > arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
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
        bubbleSortAsc(arr, 0, nElements);
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
