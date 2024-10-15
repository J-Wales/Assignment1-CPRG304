package utilities;
import java.util.Comparator;
import shapes.Shape;
public class MergeSort {
	public static void mergeSort(Shape[] array, Comparator<Shape> comparator) {
		int length = array.length;
		if (length <= 1) return;
		
		int middle = length / 2;
		
		Shape[] leftArray = new Shape[middle];
		Shape[] rightArray = new Shape[length - middle];
		
		for (int i = 0; i < middle; i++) 
		{
			leftArray[i] = array[i];
		}
		for (int i = middle; i < length; i++) 
		{
			rightArray[i - middle] = array[i];
		}
		
		mergeSort(leftArray, comparator);
		mergeSort(rightArray, comparator);
		merge(leftArray, rightArray, array, comparator);
	}
	
	public static void merge(Shape[] leftArray, Shape[] rightArray,Shape[] array, Comparator<Shape> comparator) {
		int leftArraySize = array.length / 2;
		int rightArraySize = array.length - leftArraySize;
		int i = 0, l = 0, r = 0;

		while (l < leftArraySize && r < rightArraySize) {
			if (comparator.compare(leftArray[l], rightArray[r]) <= 0) {
				array[i++] = leftArray[l++];
			} else {
				array[i++] = rightArray[r++];
			}
		}

		while(l < leftArraySize) {
			array[i] = leftArray[l];
			i++;
			l++;
		}

		while(r < rightArraySize) {
			array[i] = rightArray[r];
		i++;
		r++;
		}
	}
}
