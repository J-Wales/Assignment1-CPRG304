package utilities;
import java.util.Comparator;

public class QuickSort {

    
    // QuickSort for Comparable elements.

    public static <T extends Comparable<T>> void sort(T[] array) {
     
        // Call the recursive QuickSort method with initial low and high bounds.
        sort(array, 0, array.length - 1);
    }
    
    
    // Recursive QuickSort method for Comparable elements by partitioning it into two subarrays.

    private static <T extends Comparable<T>> void sort(T[] array, int low, int high) {
        if (low < high) {
         
            // Partition the array and get the pivot index.
            int pi = partition(array, low, high);
            
            
            // Recursively sort the subarrays before and after the pivot.
            sort(array, low, pi - 1);
            sort(array, pi + 1, high);
            
        }
    }
    
    
                  // Rearranges and move the array with the smaller element than the pivot to the left,
    // and elements greater than the pivot are on the right.

    private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
     
        // Choose the last element as the pivot.
        T pivot = array[high];
        
        // Index of the smaller element.
        int i = low - 1;  
        
        
        // Pass through the array and compare each element to the pivot.
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
             
             // Increment index of the smaller element.
                i++;  
                
                // Swap elements to place smaller elements before the pivot.
                swap(array, i, j);  
            }
        }

        // Place the pivot in the correct position.
        swap(array, i + 1, high);
        
        // Return the pivot index.
        return i + 1;  
    }
    
   
    // QuickSort for Comparator elements.
    
    public static <T> void sort(T[] array, Comparator<T> comparator) {
     
        // Call the recursive QuickSort method with the comparator and initial bounds.
        sort(array, 0, array.length - 1, comparator);
    }


    // Recursive QuickSort method for custom Comparator elements.

    private static <T> void sort(T[] arr, int low, int high, Comparator<T> comparator) {
        if (low < high) {
         
            // Partition the array and get the pivot index.
            int pi = partition(arr, low, high, comparator);
            
            
            // Recursively sort the subarrays before and after the pivot.
            sort(arr, low, pi - 1, comparator);
            sort(arr, pi + 1, high, comparator);
        }
    }



    // Rearranges the array based on the Comparator where elements that smaller than the pivot
    // are on the left and the elements greater than the pivot are on the right.
  
    private static <T> int partition(T[] array, int low, int high, Comparator<T> comparator) {
     
        // Choose the last element as the pivot.
        T pivot = array[high];
        
        // Index of the smaller element.
        int i = low - 1;  

        // Pass through the array and compare each element to the pivot using the comparator.
        for (int j = low; j < high; j++) {
            if (comparator.compare(array[j], pivot) <= 0) {
             
             // Increment index of the smaller element.
                i++;  
                
                // Swap elements to place smaller elements before the pivot.
                swap(array, i, j);  
            }
        }

        // Place the pivot in the correct position.
        swap(array, i + 1, high);
        return i + 1;  // Return the pivot index.
    }


    
    // Utility method to swap two elements in an array.

    private static <T> void swap(T[] array, int i, int j) {
     
        // Swap elements at index i and j.
        T tempVar = array[i];
        array[i] = array[j];
        array[j] = tempVar;
    }



}
