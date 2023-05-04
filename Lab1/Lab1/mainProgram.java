import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import sortingAlgorithms.sortingAlgorithms;
import sortingAlgorithms.sortingAlgorithms.Stack;
import sortingAlgorithms.sortingAlgorithms.Queue;

public class mainProgram {

    public static void main(String[] args) {
        try {
            File file = new File("/Users/Johnson_code/CJohnson-435-1/Lab2/textFiles/magicitems.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String originalLine = line;  // store the original line with spaces to later print

                line = line.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // remove all non-alphanumeric characters and convert to lowercase(chatgpt suggested code)
                sortingAlgorithms sa = new sortingAlgorithms();

                Stack sStack = sa.new Stack();
                Queue sQueue = sa.new Queue();

                // Push each character on the stack and enqueue each character in a queue
                for (char c : line.toCharArray()) {
                    sStack.push(c);
                    sQueue.enqueue(c);
                }


                boolean truePal = true;
                while (!sStack.isEmpty() && !sQueue.isEmpty()) { //make sure neither are empty

                    // (Looped)compare a character from sStack(String) and sQueue(reversed String) and remove them from their data structures

                    char stackChar = (char) sStack.pop();        // remove the character from the stack  
                    char queueChar = (char) sQueue.dequeue();    // remove the character from the queue
                    if (stackChar != queueChar) { // if the characters are not equal, the line is not a palindrome
                        truePal = false;
                        break;
                    }
                }

                if (truePal) {
                    System.out.println(originalLine);  // print the original line with spaces
                }
            }



            scanner.close(); 
        } catch (FileNotFoundException e) { //throw a FileNotFoundException if the file is not found
            e.printStackTrace();
        }
    } //end of mainProgram

}//end of mainProgram
