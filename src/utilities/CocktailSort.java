package utilities;
import java.util.Comparator;

public class CocktailSort {
   // Generic method to perform cocktail sort
   public static <T> void cocktailSort(T[] arr, Comparator<? super T> comparator) {
       boolean swapped = true;
       int start = 0;
       int end = arr.length;
       while (swapped) {
           swapped = false;

           for (int i = start; i < end - 1; i++) {
               if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                   T temp = arr[i];
                   arr[i] = arr[i + 1];
                   arr[i + 1] = temp;
                   swapped = true;
               }
           }

           if (!swapped) break;

           swapped = false;
           end--;

           for (int i = end - 1; i >= start; i--) {
               if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                   T temp = arr[i];
                   arr[i] = arr[i + 1];
                   arr[i + 1] = temp;
                   swapped = true;
               }
           }

           start++;
       }
   }
}
