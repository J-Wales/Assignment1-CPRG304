/**
 * 
 */
package utilities;
import java.util.Comparator;


public final class InsertionSort {

    /**
     * Generic Insertion Sort for arrays of Comparable elements.
     * Sorts the array in descending order.
     * 
     * @param array the array to be sorted
     * @param <T>   the type of elements in the array, which must implement Comparable
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] array) {
        insertionSort(array, null);  // Calls the overloaded method with no Comparator, using natural order
    }

    /**
     * Generic Insertion Sort using a custom Comparator in descending order.
     * 
     * @param array      the array to be sorted
     * @param comparator the comparator to determine the order of elements
     * @param <T>        the type of elements in the array
     */
    public static <T> void insertionSort(T[] array, Comparator<? super T> comparator) {
        for (int i = 1; i < array.length; i++) {
            T currentValue = array[i];
            int j = i - 1;

            // If no comparator is provided, use natural ordering in descending order
            while (j >= 0 && compare(array[j], currentValue, comparator) < 0) {
                array[j + 1] = array[j];
                j--;
            }

            // Insert the current element into its correct position
            array[j + 1] = currentValue;
        }
    }

    // Helper method to compare elements, using the comparator if provided
    private static <T> int compare(T element1, T element2, Comparator<? super T> comparator) {
        if (comparator == null) {
            return ((Comparable<T>) element1).compareTo(element2);  // Natural order
        } else {
            return comparator.compare(element1, element2);  // Custom comparator order
        }
    }
}





