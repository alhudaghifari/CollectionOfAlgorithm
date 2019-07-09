
import java.util.ArrayList;
import java.util.List;

/**
 * created in July 9, 2019
 * @author Alhudaghifari
 */
public class MedianAlgorithm {
    /**
     * Call this to get median using Median Algorithm
     * @param arr your array
     * @param low minimum index of the array, for first calling please use 0
     * @param high size of the array
     * @param k this is the index of pivot using the middle of the array,-> nElement/2
     * @return the median
     */
    private static int getMedian(int [] arr, int low, int high, int k) {
        BundleValue bun = getKthSmallestAndArrayArranged(arr, arr[k]);
        if (bun.getkTh() == k) {
            return arr[k];
        } else if (bun.getkTh() < k) {
            k = k - bun.getkTh() - 1;
            arr = trimArray(bun.getArr(), bun.getkTh() + 1, high);
            return getMedian(arr, 0, (high - (bun.getkTh() + 1)), k);
        } else { // bun.kTh > k
            arr = trimArray(bun.getArr(), 0, bun.getkTh());
            return getMedian(arr, 0, bun.getkTh(), k);
        }
    }
    
    /**
     * this method produced trimmed array from index low till high
     * low must be >= 0 and high must be < arr.length
     * @param arr the array
     * @param low minimum index to trim, low >= 0
     * @param high maximum index to trim, high < arr.length
     * @return trimmed array from low to high
     */
    private static int [] trimArray(int [] arr, int low, int high) {
        int temp[] = new int[high-low];
        int count = low;
        for(int i=0;i<high-low;i++) {
            temp[i] = arr[count];
            count++;
        }
        return temp;
    }
    
    /**
     * this method used for produced Kth pivot smallest and array that has been arranged
     * the resulting array is a value that is less than the same as the pivot in the left
     * and a value greater than the pivot is on the right
     * @param arr the array
     * @param pivot pivot value
     * @return BundleValue
     */
    private static BundleValue getKthSmallestAndArrayArranged(int [] arr, int pivot) {
        BundleValue bun = new BundleValue();
        int tempLeft[] = new int[arr.length];
        List<Integer> tempRight = new ArrayList<>();
        int totalPivot = 0;
        int left = 0;
        int index = 0;
        for (int i=0;i<arr.length;i++) {
            if (arr[i] <= pivot) {
                if (arr[i] == pivot) {
                    totalPivot++;
                } else {
                    tempLeft[left] = arr[i];
                    left++;
                }
            } else {
                tempRight.add(arr[i]);
            }
        }
        int count = 0;
        for(int i=0;i<totalPivot;i++) {
            if (i == 0)
                index = left;
            tempLeft[left] = pivot;
            left++;
        }
        for (int i=left;i<arr.length;i++) {
            tempLeft[i] = tempRight.get(count);
            count++;
        }
        bun.setArr(tempLeft);
        bun.setkTh(index);
        return bun;
    }
    
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
        int nElements = 1000;
        int arr[] = new int[nElements];
        int arr2[] = new int [nElements];
        int mid = nElements/2;
        
        for(int i=0;i<nElements;i++) {
            arr[i] = (int)(nElements * Math.random());
            arr2[i] = arr[i];
        }
        
        bubbleSortAsc(arr2, 0, nElements);
        int median2 = arr2[mid];
        System.out.println("1. This median is produced by conventional sorting : " + median2);
        int median = getMedian(arr, 0, nElements, mid);
        System.out.println("2. This Median is generated by using the Median Algorithm : " + median);
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
    
    private static class BundleValue {
        private int [] arr;
        private int kTh;
        
        public int[] getArr() {
            return arr;
        }

        public void setArr(int[] arr) {
            this.arr = arr;
        }

        public int getkTh() {
            return kTh;
        }

        public void setkTh(int kTh) {
            this.kTh = kTh;
        }
    }
}