package sortingAlgorithms;
import java.util.ArrayList;
public class sortingAlgorithms {
	
	public static ArrayList<String> quickSort(ArrayList<String> shuffledQuickList, int lowI, int highI) {
		//the array is sorted and the function returns
		if (lowI >= highI) {
			return shuffledQuickList;
		}
	
		int pivotIndex = highI;
		String pivot = shuffledQuickList.get(pivotIndex);
	
		int leftP = lowI;
		int rightP = highI-1;
	
		while (leftP <= rightP) {
			// Increment the left pointer while the element at that index is less than the pivot element
			while (leftP <= rightP && shuffledQuickList.get(leftP).compareTo(pivot) < 0) {
				leftP++;
			}
			// Decrement the right pointer while the element at that index is greater than the pivot element
			while (leftP <= rightP && shuffledQuickList.get(rightP).compareTo(pivot) > 0) {
				rightP--;
			}
			// Swap the elements at the left and right pointer if they are in the wrong order
			if (leftP < rightP) {
				String temp = shuffledQuickList.get(leftP);
				shuffledQuickList.set(leftP, shuffledQuickList.get(rightP));
				shuffledQuickList.set(rightP, temp);
			}
		}
		// Move the pivot element to its final sorted position
		String temp = shuffledQuickList.get(leftP);
		shuffledQuickList.set(leftP, shuffledQuickList.get(highI));
		shuffledQuickList.set(highI, temp);
	
		quickSort(shuffledQuickList, lowI, leftP - 1);
		quickSort(shuffledQuickList, leftP + 1, highI);
	
		return shuffledQuickList;
	}
    

} // end of SinglyLinkedList class