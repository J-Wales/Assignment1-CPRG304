package utilities;
import java.util.Comparator;



public final class QuickSort {

    /**
     * Generic QuickSort for arrays of Comparable elements in descending order.
     * This method sorts the array based on the natural ordering of its elements.
     *
     * @param array the array to be sorted
     * @param <T>   the type of elements in the array, which must implement Comparable
     */
    public static <T extends Comparable<? super T>> void sort(T[] array) {
        sort(array, 0, array.length - 1);  // Calls the recursive QuickSort method with initial low and high bounds
    }

    /**
     * Recursive QuickSort method for Comparable elements in descending order.
     *
     * @param array the array to be sorted
     * @param low   the starting index
     * @param high  the ending index
     * @param <T>   the type of elements in the array
     */
    private static <T extends Comparable<? super T>> void sort(T[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);  // Partition the array
            sort(array, low, pivotIndex - 1);  // Recursively sort the left subarray
            sort(array, pivotIndex + 1, high);  // Recursively sort the right subarray
        }
    }

    /**
     * Partitions the array based on the pivot element for descending order.
     *
     * @param array the array to be partitioned
     * @param low   the starting index
     * @param high  the ending index
     * @param <T>   the type of elements in the array
     * @return the index of the pivot element
     */
    private static <T extends Comparable<? super T>> int partition(T[] array, int low, int high) {
        T pivot = array[high];  // Choose the last element as the pivot
        int i = low - 1;  // Index of the smaller element

        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) > 0) {  // Compare for descending order
                i++;
                swap(array, i, j);  // Swap elements
            }
        }

        swap(array, i + 1, high);  // Place the pivot element in its correct position
        return i + 1;  // Return the pivot index
    }

    /**
     * Generic QuickSort using a custom Comparator in descending order.
     * This method sorts the array based on the ordering defined by the Comparator.
     *
     * @param array      the array to be sorted
     * @param comparator the comparator to determine the order of elements
     * @param <T>        the type of elements in the array
     */
    public static <T> void sort(T[] array, Comparator<? super T> comparator) {
        sort(array, 0, array.length - 1, comparator);  // Calls the recursive QuickSort method with a Comparator
    }

    /**
     * Recursive QuickSort method for custom Comparator elements in descending order.
     *
     * @param array      the array to be sorted
     * @param low        the starting index
     * @param high       the ending index
     * @param comparator the comparator to determine the order of elements
     * @param <T>        the type of elements in the array
     */
    private static <T> void sort(T[] array, int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, comparator);  // Partition the array
            sort(array, low, pivotIndex - 1, comparator);  // Recursively sort the left subarray
            sort(array, pivotIndex + 1, high, comparator);  // Recursively sort the right subarray
        }
    }

    /**
     * Partitions the array based on the pivot element and Comparator for descending order.
     *
     * @param array      the array to be partitioned
     * @param low        the starting index
     * @param high       the ending index
     * @param comparator the comparator to determine the order of elements
     * @param <T>        the type of elements in the array
     * @return the index of the pivot element
     */
    private static <T> int partition(T[] array, int low, int high, Comparator<? super T> comparator) {
        T pivot = array[high];  // Choose the last element as the pivot
        int i = low - 1;  // Index of the smaller element

        for (int j = low; j < high; j++) {
            if (comparator.compare(array[j], pivot) > 0) {  // Compare for descending order
                i++;
                swap(array, i, j);  // Swap elements
            }
        }

        swap(array, i + 1, high);  // Place the pivot element in its correct position
        return i + 1;  // Return the pivot index
    }

    /**
     * Helper method to swap two elements in an array.
     *
     * @param array the array in which elements are swapped
     * @param i     the index of the first element
     * @param j     the index of the second element
     * @param <T>   the type of elements in the array
     */
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
