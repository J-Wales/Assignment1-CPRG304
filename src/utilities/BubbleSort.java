
package utilities;

import java.util.Comparator;

/**
 * 
 */

public final class BubbleSort {

    /**
     * Generic Bubble Sort for arrays of Comparable elements in descending order.
     * This method sorts the array based on the natural ordering of its elements.
     *
     * @param array the array to be sorted
     * @param <T>   the type of elements in the array, which must implement Comparable
     */
    public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
        bubbleSort(array, null);  // Calls the overloaded method with no Comparator, using natural order
    }

    /**
     * Generic Bubble Sort using a custom Comparator in descending order.
     * This method sorts the array based on the ordering defined by the Comparator.
     *
     * @param array      the array to be sorted
     * @param comparator the comparator to determine the order of elements
     * @param <T>        the type of elements in the array
     */
    public static <T> void bubbleSort(T[] array, Comparator<? super T> comparator) {
        int n = array.length;

        // Bubble sort process
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;  

      
            for (int j = 0; j < n - i - 1; j++) {
                if (compare(array[j], array[j + 1], comparator) < 0) {  /
                    swapElements(array, j, j + 1);
                    swapped = true;  
                }
            }

           
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Helper method to compare two elements. Uses Comparator if provided, otherwise defaults to natural order.
     */
    private static <T> int compare(T element1, T element2, Comparator<? super T> comparator) {
        if (comparator == null) {
            return ((Comparable<T>) element1).compareTo(element2);  
        } else {
            return comparator.compare(element1, element2);  
        }
    }

 
    private static <T> void swapElements(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
