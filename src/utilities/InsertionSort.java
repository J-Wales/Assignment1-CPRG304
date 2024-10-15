/**
 * 
 */
package utilities;
import java.util.Comparator;

//public class InsertionSort {
//	
//	/**
//	 * Generic Insertion Sort implementation for arrays of Comparable elements (height).
//	 * @param array the array to be sorted
//	 * @param  <T> the type of elements in the array
//	 */
//	
//	public static <T extends Comparable<? super T>> void insertionSort(T[] array)
//	{
//		for (int i=1; i < array.length; i++) {
//			T currentValue = array[i];
//			int j = i - 1;
//			
//			// Shifts elements that are greater than currentValue to the right
//			while (j >= 0 && array[j].compareTo(currentValue) > 0) {
//				array[j + 1] = array[j];
//				j--;
//			}
//			
//			// Inserts currentValue at the correct position 
//			array[j + 1] = currentValue;
//		}
//	}
//	
//	/**
//	 * Generic Insertion Sort implementation for arrays using Comparator (base area and volume).
//	 * @param array the array to be sorted
//	 * @param comparator the comparator to determine the order of elements
//	 * @param <T> the type of elements in the array
//	 */
//	
//	public static <T> void insertionSort(T[] array, Comparator<? super T> comparator) {
//		for (int i = 1; i < array.length; i++) {
//			T currentValue = array[i];
//			int j = i - 1;
//			
//			// Shifts elements that are greater than currentValue using comparator
//			while (j >= 0 && comparator.compare(array[j], currentValue) > 0) {
//				array[j + 1] = array[j];
//				j--;
//			}
//			
//			// Inserts currentValue at the correct position
//			array[j + 1] = currentValue;
//		}
//	}
//	
//	
//	
//		
//}
//



public final class InsertionSort {
    
    /**
     * Generic Insertion Sort for arrays of Comparable elements (height) in descending order.
     * @param array the array to be sorted
     * @param <T>   the type of elements in the array
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] array) {
        insertionSort(array, null);
    }

    /**
     * Generic Insertion Sort for arrays using a Comparator (for base area, volume, etc.) in descending order.
     * @param array      the array to be sorted
     * @param comparator the comparator to determine the order of elements
     * @param <T>        the type of elements in the array
     */
    public static <T> void insertionSort(T[] array, Comparator<? super T> comparator) {
        for (int i = 1; i < array.length; i++) {
            T currentValue = array[i];
            int j = i - 1;

            
            while (j >= 0 && compare(array[j], currentValue, comparator) < 0) {
                array[j + 1] = array[j];
                j--;
            }

           
            array[j + 1] = currentValue;
        }
    }

   
    private static <T> int compare(T element1, T element2, Comparator<? super T> comparator) {
        if (comparator == null) {
            return ((Comparable<T>) element1).compareTo(element2);
        } else {
            return comparator.compare(element1, element2);
        }
    }

    // Helper method? (as shown in Kittysort)
    private static <T> void swapElements(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}


