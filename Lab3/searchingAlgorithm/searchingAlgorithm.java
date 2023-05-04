package searchingAlgorithm;
import java.util.ArrayList;
import java.util.Arrays;

public class searchingAlgorithm {
    
    public static void linearSearching(ArrayList<String> sortedList, ArrayList<String> randomSelect) {

		//refrenced by https://www.geeksforgeeks.org/linear-search/
		
		int randomSize = randomSelect.size();
		int sortedSize = sortedList.size();
		int count = 0;
		double totalComparisons = 0.0; //allows for a new comparison per iteration

		for(int i = 0; i < randomSize; i++){ //iterate through the list of 42 Strings
			for(int j = 0; j < sortedSize; j++){ //iterate through th entire magic items
				count++;
				if(randomSelect.get(i).equals(sortedList.get(j))){	
					printResult(randomSelect.get(i), j, count);					
					totalComparisons += count;
					break;
				}
			}
			//reset the counter so that comparisons don't overlap
			count = 0;
		}
		double averageComparisons = totalComparisons / randomSize;
		printAverage(averageComparisons);
	}
	

	public static void binarySearching(ArrayList<String> sortedList, ArrayList<String> randomSelect) {

		//Referenced by https://www.geeksforgeeks.org/java-program-to-search-arraylist-element-using-binary-search/ 
		
		int randomSize = randomSelect.size();
		int count = 0;
		for(int i = 0; i < randomSize; i++) {
			
			int low = 0;
			int high = sortedList.size() - 1;
	
			while (low <= high) {
				int mid = low + (high - low) / 2;
				count++;
				int compare = randomSelect.get(i).compareTo(sortedList.get(mid));
				//ignore left half
				if (compare < 0) {
					high = mid - 1;
				//ignore right half
				} else if (compare > 0) {
					low = mid + 1;
				//if neither then it is in the middle
				} else {
					printResult(randomSelect.get(i), mid, count);
					break;
				}
			}
		}
		double averageComparisons = (double)count / randomSize;
		printAverage(averageComparisons);
	}
	

	public static void hashSearching(int[] randomHashValues) {
    
		final int LINES_IN_FILE = 666;
		final int HASH_TABLE_SIZE = 250;
		
		// Sort the hash values.
		Arrays.sort(randomHashValues);
		
		int randomSize = randomHashValues.length;
		int arrayIndex = 0;
		int numComparisons = 0; // initialize the counter variable
		double totalComparisons = 0.0; //allows for a new comparison per iteration
		
		for (int i = 0; i < HASH_TABLE_SIZE; i++) {
			numComparisons++;
			while ((arrayIndex < LINES_IN_FILE) && (randomHashValues[arrayIndex] < i)) { 
				arrayIndex++;
				numComparisons++;
			}
			while ((arrayIndex < LINES_IN_FILE) && (randomHashValues[arrayIndex] == i)) {
				arrayIndex++;
				totalComparisons += numComparisons; // increment the counter for each comparison made in the while loop
				numComparisons = 0;
			}
		}
		
		double averageComparisons = totalComparisons / randomSize;
		printAverage(averageComparisons);
	}
	
	
	public static void printResult(String value, int index, int count) {
		System.out.println(value + " found at index " + index + " (took " + count + " comparisons)");
	}
	
	public static void printAverage(double averageComparisons) {
		System.out.println("Average number of comparisons: " + String.format("%.2f", averageComparisons));
	}



}
