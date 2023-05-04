package hashing;
import java.util.Arrays;

public class hashing {

    private static final int LINES_IN_FILE = 666;
    private static final int HASH_TABLE_SIZE = 250;

    public static int makeHashCode(String str) {
        str = str.toUpperCase();
        int length = str.length();
        int letterTotal = 0;

        // Iterate over all letters in the string, totalling their ASCII values.
        for (int i = 0; i < length; i++) {
        char thisLetter = str.charAt(i);
        int thisValue = (int)thisLetter;
        letterTotal = letterTotal + thisValue;

        }

        // Scale letterTotal to fit in HASH_TABLE_SIZE.
        int hashCode = (letterTotal * 1) % HASH_TABLE_SIZE;  

        return hashCode;
    }

    public static void analyzeHashValues(int[] hashValues) {
    
        // Sort the hash values.
        Arrays.sort(hashValues);
    
        int asteriskCount = 0;
        int[] bucketCount = new int[HASH_TABLE_SIZE];
        int totalCount = 0;
        int arrayIndex = 0;
        for (int i = 0; i < HASH_TABLE_SIZE; i++) {
            System.out.format("%03d ", i);
            asteriskCount = 0;
            while ((arrayIndex < LINES_IN_FILE) && (hashValues[arrayIndex] == i)) {
                System.out.print("*");
                asteriskCount = asteriskCount + 1;
                arrayIndex = arrayIndex + 1;
            }
            System.out.print(" ");
            System.out.println(asteriskCount);
            bucketCount[i] = asteriskCount;
            totalCount = totalCount + asteriskCount;
        }
    
    }
       
}


