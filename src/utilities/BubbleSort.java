package utilities;

import java.util.Comparator;

public final class BubbleSort {

    /**
     * Bubble Sort for arrays of Comparable elements in descending order.
     * This method sorts the array based on the natural ordering of its elements.
     *
     * @param array the array to be sorted
     * @param <T>   the type of elements in the array, which must implement Comparable
     */
    public static <T> void bubbleSort(Comparable<T>[] array) {
        bubbleSort(array, null);  // Calls the overloaded method with no Comparator, using natural order
    }

    /**
     * Bubble Sort using a custom Comparator in descending order.
     * This method sorts the array based on the ordering defined by the Comparator.
     *
     * @param array      the array to be sorted
     * @param comparator the comparator to determine the order of elements
     * @param <T>        the type of elements in the array
     */
    public static <T> void bubbleSort(Comparable<T>[] array, Comparator<? super T> comparator) {
        int n = array.length;

        // Bubble sort process
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;  // Track if a swap was made during the iteration

            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
            	// DEBUG 
//            	if (j == n - 3) {
//                    System.out.println("Comparing Second Last Element: " + array[j] + " and " + array[j + 1]);
//                }

                if (compare(array[j], array[j + 1], comparator)< 0) {  // Compare for descending order
//                	//DEBUG
//                	System.out.println("Swapping: " + array[j] + " with " + array[j + 1]);  // Debug swap
                	swapElements(array, j, j + 1);  // Swap if the current element is less than the next element
                    swapped = true;  // A swap was made
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
    private static <T> int compare(Comparable<T> element1, Comparable<T> element2, Comparator<? super T> comparator) {
        if (comparator == null) {
            return element1.compareTo((T) element2);  // Natural order
        } else {
            return comparator.compare((T) element1, (T) element2);  // Custom comparator order
        }
    }

    /**
     * Helper method to swap two elements in the array
     */
    private static <T> void swapElements(Comparable<T>[] array, int i, int j) {
        Comparable<T> temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}


