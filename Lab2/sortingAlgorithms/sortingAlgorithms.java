package sortingAlgorithms;
import java.util.Random;
import java.util.ArrayList;
public class sortingAlgorithms {


    // A Function to generate a random permutation of arrayList[]
    //https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/
	public static ArrayList<String> shuffle(ArrayList<String> arrayList, int length) {
		// Creating a object for Random class
		Random random = new Random();
		
		// Start from the last element and swap one by one. We don't
		// need to run for the first element that's why i > 0
		for (int i = length-1; i > 0; i--) {
			
			// Pick a random index from 0 to i
			int j = random.nextInt(i+1);
			
			// Swap arrayList[i] with the element at random index
			String temp = arrayList.get(i);
			arrayList.set(i, arrayList.get(j));
			arrayList.set(j, temp);
		}
		
		// Return the shuffled list
		return arrayList;
	}


	// A function to implement selection sort
	public static int selectionSort(ArrayList<String> shuffledSelectionList){
		
		int length = shuffledSelectionList.size();
		int i = 0;
        int comparisons = 0; // initialize comparison counter

		while (i < length){
			int jMin = i; //index of smallest element
			int j = i + 1; //index of next element
			while (j < length){
				
				comparisons++; // increment comparison counter

				if(shuffledSelectionList.get(j).compareTo(shuffledSelectionList.get(jMin)) < 0){ //if the next element is smaller than the smallest element
					jMin = j; //set the index of the smallest element to the index of the next element
					comparisons++; // increment comparison counter
				}
				j++; //increment the index of the next element
			}
			if( jMin != i){ //if the index of the smallest element is not the same as the index of the first element
				String temp = shuffledSelectionList.get(i); //swap the first element with the smallest element
				shuffledSelectionList.set(i, shuffledSelectionList.get(jMin)); //set the first element to the smallest element
				shuffledSelectionList.set(jMin, temp); //set the smallest element to the first element

			}
			i++; //increment the index of the first element
		}

		return comparisons;
	}

	public static int insertionSort(ArrayList<String> shuffledInsertionList){
		
        int length = shuffledInsertionList.size();
        int comparisons = 0; // initialize comparison counter

		int i = 1;
			while (i < length){ //while the index of the first element is less than the size of the list
				int j = i;
				//while the index of the first element is greater than 0 and the first element is less than the second element
				while (j > 0 && shuffledInsertionList.get(j).compareTo(shuffledInsertionList.get(j-1)) < 0){ 
                    comparisons++; // increment comparison counter

					String temp = shuffledInsertionList.get(j);
					shuffledInsertionList.set(j, shuffledInsertionList.get(j-1)); 
					shuffledInsertionList.set(j-1, temp);
					j--;//decrement the index of the first element
				}
				i++;

			}

		return comparisons;
	}

	public static int mergeSort(ArrayList<String> shuffledMergeList){
		int comparisons = 0;
	
		int length = shuffledMergeList.size();
	
		if (length < 2) {
			//if length is less than 2, means that we no longer need to split the list
			return comparisons;
		}
	
		int mid = length / 2;
	
		//create a new ArrayList to continuously split shuffledMergeList 
		ArrayList<String> left = new ArrayList<>(shuffledMergeList.subList(0, mid)); 
		ArrayList<String> right = new ArrayList<>(shuffledMergeList.subList(mid, length));
	
		//recurcion the left and right ArrayList
		comparisons += mergeSort(left); // update left with the sorted left sub-list
		comparisons += mergeSort(right); // update right with the sorted right sub-list
	
		comparisons += merge(shuffledMergeList, left, right);
	
		return comparisons;
	}
	
	
	public static int merge(ArrayList<String>shuffledMergeList, ArrayList<String>left, ArrayList<String>right) {
		int comparisons = 0;
	
		int lengthL = left.size(); //gets the length of the left array
		int lengthR = right.size(); //gets the length of the right array
	
		int i = 0; // index of current element in left array
    	int j = 0; // index of current element in right array
    	int k = 0; // index of current element in merged array
	
		while (i < lengthL && j < lengthR) { 
			if (left.get(i).compareTo(right.get(j)) < 0) {
				shuffledMergeList.set(k, left.get(i)); //set current element of shuffledMergeList to the smaller element from left array 
				i++; //move to the next element in left array
				comparisons++;
			} else {
				shuffledMergeList.set(k, right.get(j)); //set current element of shuffledMergeList to the smaller element from right array
				j++; //move to the next element in right array
				comparisons++;
			}
			k++;
		}
		//remaining elements from the left array
		while (i < lengthL) {
			shuffledMergeList.set(k, left.get(i));
			i++;
			k++;
		}
		//remaining elements from the right array
		while (j < lengthR) {
			shuffledMergeList.set(k, right.get(j));
			j++;
			k++;
		}
		return comparisons;
	}
	
		public static int quickSort(ArrayList<String> shuffledQuickList, int lowI, int highI){
			int comparisons = 0;
		
			//the array is sorted and the function returns
			if (lowI >= highI){
				return comparisons;
			}
		
			int pivotIndex = highI;
			String pivot = shuffledQuickList.get(pivotIndex);
		
			int leftP = lowI;
			int rightP = highI-1;
		
			while (leftP <= rightP) {
				// Increment the left pointer while the element at that index is less than the pivot element
				while (leftP <= rightP && shuffledQuickList.get(leftP).compareTo(pivot) < 0) {
					leftP++;
					comparisons++;
				}
				// Decrement the right pointer while the element at that index is greater than the pivot element
				while (leftP <= rightP && shuffledQuickList.get(rightP).compareTo(pivot) > 0) {
					rightP--;
					comparisons++;
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
		
			comparisons += quickSort(shuffledQuickList, lowI, leftP - 1);
			comparisons += quickSort(shuffledQuickList, leftP + 1, highI);
		
	
			return comparisons;
		}		
    

} // end of SinglyLinkedList class