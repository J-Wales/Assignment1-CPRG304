package utilities;
import java.util.Comparator;


public final class CocktailSort {

    /**
     * Generic Cocktail Sort for arrays of Comparable elements in descending order.
     * This method sorts the array based on the natural ordering of its elements.
     *
     * @param array the array to be sorted
     * @param <T>   the type of elements in the array, which must implement Comparable
     */
    public static <T extends Comparable<? super T>> void cocktailSort(T[] array) {
        cocktailSort(array, null);  // Calls the overloaded method with no Comparator, using natural order
    }

    /**
     * Generic Cocktail Sort using a custom Comparator in descending order.
     * This method sorts the array based on the ordering defined by the Comparator.
     *
     * @param array      the array to be sorted
     * @param comparator the comparator to determine the order of elements
     * @param <T>        the type of elements in the array
     */
    public static <T> void cocktailSort(T[] array, Comparator<? super T> comparator) {
        boolean swapped = true;
        int start = 0;
        int end = array.length;

        while (swapped) {
            swapped = false;

            // Traverses the array from left to right
            for (int i = start; i < end - 1; i++) {
                if (compare(array[i], array[i + 1], comparator) < 0) {  
                    swapElements(array, i, i + 1);
                    swapped = true;
                }
            }

            // If no swaps were made, the array is sorted
            if (!swapped) {
                break;
            }

            swapped = false;
            end--;  

            // Traverses the array from right to left 
            for (int i = end - 1; i >= start; i--) {
                if (compare(array[i], array[i + 1], comparator) < 0) {  // Change condition for descending order
                    swapElements(array, i, i + 1);
                    swapped = true;
                }
            }

            start++;  // Increases the start boundary as the smallest element is now in place
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

