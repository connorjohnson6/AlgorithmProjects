import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import graphVersions.graphVersions;
import binarySearch.binarySearch;

public class mainProgram {

    public static void main(String[] args) {

        //Binary Search Tree 
        try {
            File magicitemsFile = new File("/Users/Johnson_code/CJohnson-435-1/Lab4/textFiles/magicitems.txt");
            File compressedMagicitems = new File("/Users/Johnson_code/CJohnson-435-1/Lab4/textFiles/magicitems-find-in-bst.txt");
        
            Scanner bstScanner = new Scanner(magicitemsFile);
            Scanner compressedBstScanner = new Scanner(compressedMagicitems);
            
            ArrayList<String> arrayList = new ArrayList<String>();
            ArrayList<String> compressedArrayList = new ArrayList<String>();
        
            binarySearch binaryTree = new binarySearch();
            binarySearch compressedBinaryTree = new binarySearch();
            
            //orginal 666 search
            while (bstScanner.hasNextLine()) {
                String line = bstScanner.nextLine();
                line = line.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                arrayList.add(line);
            }
        
            //compressed magicitems list
            while (compressedBstScanner.hasNextLine()) {
                String line = compressedBstScanner.nextLine();
                line = line.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                compressedArrayList.add(line);
            }
        
            //goes through arrayList to aquire row by row
            for (int i = 0; i < arrayList.size(); i++) {
                String magicitem = arrayList.get(i);
                int asciiValue = 0;
                //goes through arraylist to get ascii value
                for (int j = 0; j < magicitem.length(); j++) {
                    asciiValue += (int) magicitem.charAt(j);
                }
                binaryTree.addNode(asciiValue, magicitem);
            }
        
            System.out.println("\n--------------------------------\n");
        
            binaryTree.inOrderTraverseTree(binaryTree.root);
        
            System.out.println("\n--------------------------------\n");
        

            double totalComparisons = 0.0;
            int totalLookups = 0;
            
            //same code for arrayList instead it iterates for the compressedArrayList
            for (int i = 0; i < compressedArrayList.size(); i++) {
                String magicitem = compressedArrayList.get(i);
                int asciiValue = 0;
                for (int j = 0; j < magicitem.length(); j++) {
                    asciiValue += (int) magicitem.charAt(j);
                }
                compressedBinaryTree.addNode(asciiValue, magicitem);
            

                String result = compressedBinaryTree.findNode(asciiValue);
                System.out.print(result);
                if (!result.equals("Not found")) {
                    String[] parts = result.split(" ");
                    totalComparisons += Integer.parseInt(parts[parts.length - 1]);
                    totalLookups++;
                }

            }
            
            double averageComparisons = totalComparisons / totalLookups;
            System.out.println("\nAverage number of comparisons: " + averageComparisons);
            
                




        
            bstScanner.close();
            compressedBstScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        
        
        
        

        //Undirected Graphs
        try {
            File file = new File("/Users/Johnson_code/CJohnson-435-1/Lab4/textFiles/graphs1.txt");
            Scanner scanner = new Scanner(file);
            int vertexCounter = 0;
            ArrayList<Integer> adjacencyEdges = new ArrayList<Integer>();
            ArrayList<Integer> matrixEdges = new ArrayList<Integer>();
    
    
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
            
                if (line.startsWith("--")) { // Found start of a new graph
                    graphVersions g = new graphVersions(vertexCounter+1);
                    for (int i = 0; i < adjacencyEdges.size(); i += 2) {
                        int adjacencyIndex1 = adjacencyEdges.get(i);
                        int adjacencyIndex2 = adjacencyEdges.get(i+1);
                        g.addEdge(adjacencyIndex1, adjacencyIndex2); // add edge to the graph
                    }
            
                    if (vertexCounter > 0) {
                        printGraphInformation(g, matrixEdges, vertexCounter+1);
                    }
            
                    vertexCounter = 0;
                    adjacencyEdges.clear(); //clear for the next iteration
                    matrixEdges.clear();
                } else if (line.contains("add vertex")) {
                    vertexCounter++;
                } else if (line.contains("add edge")) {
                    int adjacencyIndex1 = Integer.parseInt(line.substring(line.indexOf("edge") + 5, line.indexOf("-") - 1)); //chatgpt suggested code for debugging
                    int adjacencyIndex2 = Integer.parseInt(line.substring(line.indexOf("-") + 2));
                    adjacencyEdges.add(adjacencyIndex1);
                    adjacencyEdges.add(adjacencyIndex2);
            
                    int matrixIndex1 = Integer.parseInt(line.substring(line.indexOf("edge") + 5, line.indexOf("-") - 1));
                    int matrixIndex2 = Integer.parseInt(line.substring(line.indexOf("-") + 2));
                    matrixEdges.add(matrixIndex1);
                    matrixEdges.add(matrixIndex2);
                }
            }
    
            // Process the last graph
            graphVersions g = new graphVersions(vertexCounter+1); 
            for (int i = 0; i < adjacencyEdges.size(); i += 2) {
                int adjacencyIndex1 = adjacencyEdges.get(i);
                int adjacencyIndex2 = adjacencyEdges.get(i+1);
                g.addEdge(adjacencyIndex1, adjacencyIndex2); // add edge to the graph
            }
    
            printGraphInformation(g, matrixEdges, vertexCounter +1);
    
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    
        //printing graph information
        private static void printGraphInformation(graphVersions g, ArrayList<Integer> matrixEdges, int vertexCounter) {
            System.out.println("\n ------------------------------------------\n");
            System.out.println("\n Adjacency List");
            System.out.println(g);


        
            graphVersions.matrix m = g.new matrix(vertexCounter);
            for (int i = 0; i < matrixEdges.size(); i += 2) {//(+2 each edge in the graph )
                int matrixIndex1 = matrixEdges.get(i);
                int matrixIndex2 = matrixEdges.get(i+1);
                m.addEdge(matrixIndex1, matrixIndex2); // add edge to the graph
            }
        
            System.out.println("\n Matrix List");
            System.out.println(m);
        
            System.out.println("\n Breadth First Search");
            g.bfs(1);
        
            System.out.println("\n Depth First Search");
            g.dfs(1);
        }
   
   
    }

