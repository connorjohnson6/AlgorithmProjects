import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import sortingAlgorithms.sortingAlgorithms;
import searchingAlgorithm.searchingAlgorithm;
import hashing.hashing;

public class mainProgram {
	

	public static void main(String[] args) {
		
		final int LINES_IN_FILE = 666;
		final String FILE_NAME = "/Users/Johnson_code/CJohnson-435-1/Lab3/textFiles/magicitems.txt";


		String[] magicItems = new String[LINES_IN_FILE];
		int[] hashValues = new int[LINES_IN_FILE];
		int[] randomhashValues = new int[LINES_IN_FILE];
		try {
			Scanner scanner = new Scanner(new File(FILE_NAME));
			ArrayList<String> arrayList = new ArrayList<String>();
			ArrayList<String> randomSelect = new ArrayList<String>();

			int index = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				magicItems[index] = line;
				index++;
				arrayList.add(line.toUpperCase());
			}
			scanner.close();
	
	
			//Sort the arrayList using the quick sort algorithm
			int low = 0;
			int high = arrayList.size() - 1;
			ArrayList<String> sortedList = sortingAlgorithms.quickSort(arrayList, low, high);

			//must make a copy of the sortedList as we delete indexs in the randomied picked list
			ArrayList<String> sortedArrayList = new ArrayList<>(sortedList);


			// Select 42 items from arrayList at random
			Random rand = new Random();
			int count = 0;
			while (count < 42 && arrayList.size() > 0) {
				int randomIndex = rand.nextInt(arrayList.size());
				String randomString = arrayList.remove(randomIndex);
				randomSelect.add(randomString);
				count++;
			}

			// Print the array and hash values.
			int hashCode = 0;
			for (int i = 0; i < LINES_IN_FILE; i++) {
				hashCode = hashing.makeHashCode(magicItems[i]);
				hashValues[i] = hashCode;
			} 

			int randomhashCode = 0;
			for (int i = 0; i <  randomSelect.size(); i++) {
				randomhashCode = hashing.makeHashCode(randomSelect.get(i));
				randomhashValues[i] = randomhashCode;
			} 

			printStatements(sortedArrayList, randomSelect, hashValues, randomhashValues);

		
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	
	}

	public static void printStatements(ArrayList<String>sortedArrayList, ArrayList<String> randomSelect, int[] hashValues, int[] randomhashValues) {
		System.out.println("Linear Search.");
		System.out.println("-----------------------------");
		searchingAlgorithm.linearSearching(sortedArrayList, randomSelect);
				
		System.out.println("\nBinary Search.");
		System.out.println("-----------------------------");
		searchingAlgorithm.binarySearching(sortedArrayList, randomSelect);
	
		System.out.println("\nHash code tests and analysis.");
		System.out.println("-----------------------------");
		hashing.analyzeHashValues(hashValues);
	
		System.out.println("\nHash code comparisons.");
		System.out.println("-----------------------------");
		searchingAlgorithm.hashSearching(randomhashValues);
	}
	
}//end of mainProgram