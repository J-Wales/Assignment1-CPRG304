/**
 * 
 */
package utilities;
import java.util.Comparator;




public final class SelectionSort {

    /**
     * Generic Selection Sort for arrays of Comparable elements in descending order.
     * This method sorts the array based on the natural ordering of its elements.
     *
     * @param array the array to be sorted
     * @param <T>   the type of elements in the array, which must implement Comparable
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] array) {
        selectionSort(array, null);  // Calls the overloaded method with no Comparator, using natural order
    }

    /**
     * Generic Selection Sort using a custom Comparator in descending order.
     * This method sorts the array based on the ordering defined by the Comparator.
     *
     * @param array      the array to be sorted
     * @param comparator the comparator to determine the order of elements
     * @param <T>        the type of elements in the array
     */
    public static <T> void selectionSort(T[] array, Comparator<? super T> comparator) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;  // Assume the first element is the maximum

            // Inner loop to find the maximum element in the unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (compare(array[j], array[maxIndex], comparator) < 0) {
                    maxIndex = j;  // Update maxIndex if a larger element is found
                }
            }

            // Swap the found maximum element with the first element of the unsorted portion
            swapElements(array, i, maxIndex);
        }
    }

    /**
     * Helper method to compare two elements. Uses Comparator if provided, otherwise defaults to natural order.
     */
    private static <T> int compare(T element1, T element2, Comparator<? super T> comparator) {
        if (comparator == null) {
            return ((Comparable<T>) element1).compareTo(element2);  // Natural order
        } else {
            return comparator.compare(element1, element2);  // Custom comparator order
        }
    }

    /**
     * Helper method to swap two elements in the array.
     */
    private static <T> void swapElements(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
