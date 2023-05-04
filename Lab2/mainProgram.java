import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import sortingAlgorithms.sortingAlgorithms;
public class mainProgram {
	

	public static void main(String[] args) {
		try {
			File file = new File("Lab2/textFiles/magicitems.txt");
			Scanner scanner = new Scanner(file);
	
			ArrayList<String> arrayList = new ArrayList<String>();
	
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				arrayList.add(line);
	
			} //end of while loop
	
			int length = arrayList.size();
	
			//Create four separate shuffled lists using the shuffle method (debugged with chatgpt)
			ArrayList<String> shuffledSelectionList = sortingAlgorithms.shuffle(new ArrayList<>(arrayList), length);
			ArrayList<String> shuffledInsertionList = sortingAlgorithms.shuffle(new ArrayList<>(arrayList), length);
			ArrayList<String> shuffledMergeList = sortingAlgorithms.shuffle(new ArrayList<>(arrayList),length);
			ArrayList<String> shuffledQuickList = sortingAlgorithms.shuffle(new ArrayList<>(arrayList), length);
	
		
			printResults(shuffledSelectionList, "Selection Sort");
			printResults(shuffledInsertionList, "Insertion Sort");
			printResults(shuffledMergeList, "Merge Sort");
			printResults(shuffledQuickList, "Quick Sort");
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void printResults(ArrayList<String> list, String sortAlgorithm) {
		long startTime = System.nanoTime();
		int comparisons = 0;
		if (sortAlgorithm.equals("Selection Sort")) {
			comparisons = sortingAlgorithms.selectionSort(list);
		} else if (sortAlgorithm.equals("Insertion Sort")) {
			comparisons = sortingAlgorithms.insertionSort(list);
		} else if (sortAlgorithm.equals("Merge Sort")) {
			comparisons = sortingAlgorithms.mergeSort(list);
		} else if (sortAlgorithm.equals("Quick Sort")) {
			int low = 0;
			int high = list.size() - 1;
			comparisons = sortingAlgorithms.quickSort(list, low, high);
		}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000;

		System.out.println("\n" + sortAlgorithm + ":");
		System.out.println("\tNumber of comparisons: " + comparisons);
		System.out.println("\tThis took: " + duration + " μs");
	}
	
}//end of mainProgram