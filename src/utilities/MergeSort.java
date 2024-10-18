package utilities;
import java.util.Comparator;


public final class MergeSort {

    /**
     * Generic Merge Sort for arrays of Comparable elements in descending order.
     * This method sorts the array based on the natural ordering of its elements.
     *
     * @param array the array to be sorted
     * @param <T>   the type of elements in the array, which must implement Comparable
     */
    public static <T extends Comparable<? super T>> void mergeSort(Comparable<T>[] array) {
        mergeSort(array, null);  // Calls the overloaded method with no Comparator, using natural order
    }

    /**
     * Generic Merge Sort using a custom Comparator in descending order.
     * This method sorts the array based on the ordering defined by the Comparator.
     *
     * @param array      the array to be sorted
     * @param comparator the comparator to determine the order of elements
     * @param <T>        the type of elements in the array
     */
    public static <T> void mergeSort(T[] array, Comparator<? super T> comparator) {
        int length = array.length;
        if (length <= 1) return;  // Base case for recursion

        int middle = length / 2;

        // Split the array into two halves
        T[] leftArray = (T[]) new Object[middle];
        T[] rightArray = (T[]) new Object[length - middle];

        // Copy the elements into the left and right subarrays
        System.arraycopy(array, 0, leftArray, 0, middle);
        System.arraycopy(array, middle, rightArray, 0, length - middle);

        // Recursively sort both halves
        mergeSort(leftArray, comparator);
        mergeSort(rightArray, comparator);

        // Merge the sorted halves
        merge(leftArray, rightArray, array, comparator);
    }

    /**
     * Merges two sorted arrays into one in descending order.
     *
     * @param leftArray  the left half of the array
     * @param rightArray the right half of the array
     * @param array      the original array to be filled with sorted elements
     * @param comparator the comparator to determine the order of elements
     * @param <T>        the type of elements in the array
     */
    private static <T> void merge(T[] leftArray, T[] rightArray, T[] array, Comparator<? super T> comparator) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0, l = 0, r = 0;

        // Merge the two arrays in descending order
        while (l < leftSize && r < rightSize) {
            if (compare(leftArray[l], rightArray[r], comparator) > 0) {
                array[i++] = leftArray[l++];
            } else {
                array[i++] = rightArray[r++];
            }
        }

        // Copy any remaining elements from the left array
        while (l < leftSize) {
            array[i++] = leftArray[l++];
        }

        // Copy any remaining elements from the right array
        while (r < rightSize) {
            array[i++] = rightArray[r++];
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
}
