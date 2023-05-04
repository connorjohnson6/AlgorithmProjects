import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import graphVersions.*;

public class mainProgram {

    public static void main(String[] args) {
        try {
            File file = new File("/Users/Johnson_code/CJohnson-435-1/Lab5/textFiles/graphs2.txt");
            Scanner scanner = new Scanner(file);
            int vertexCounter = 0;
            ArrayList<graphVersions.Edge> adjacencyEdges = new ArrayList<>();
            graphVersions g = null;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.startsWith("--")) { // Found start of a new graph
                    if (g != null) {
                        printGraphInformation(g, vertexCounter);
                    }

                    g = new graphVersions(vertexCounter+1);
                    for (graphVersions.Edge edge : adjacencyEdges) {
                        g.addEdge(edge.vertex1, edge.vertex2, edge.weight); // add edge to the graph
                    }

                    vertexCounter = 0;
                    adjacencyEdges.clear(); //clear for the next iteration

                } else if (line.contains("add vertex")) {
                    vertexCounter++;
                } else if (line.contains("add edge")) {
                    int vertex1 = Integer.parseInt(line.substring(line.indexOf("edge") + 5, line.indexOf("-")).trim()); 
                    int vertex2 = Integer.parseInt(line.substring(line.indexOf("-") + 1, line.lastIndexOf(" ")).trim());
                    int weight = Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1).trim());

                    graphVersions.Edge edge = new graphVersions.Edge(vertex1-1, vertex2-1, weight);
                    adjacencyEdges.add(edge);
                }
            }

            // Process the last graph
            if (g != null) {
                printGraphInformation(g, vertexCounter);
            }

            // Check if there are any leftover edges that haven't been added to a graph
            if (!adjacencyEdges.isEmpty()) {
                g = new graphVersions(vertexCounter+1);
                for (graphVersions.Edge edge : adjacencyEdges) {
                    g.addEdge(edge.vertex1, edge.vertex2, edge.weight); // add edge to the graph
                }
                printGraphInformation(g, vertexCounter);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void printGraphInformation(graphVersions g, int vertexCounter) {
        System.out.println("\n ------------------------------------------\n");
        System.out.println("\n Adjacency List");
        System.out.println(g);

        // Run Bellman-Fords's algorithm with vertex 0 as the source
        System.out.println("Shortest distances from vertex 1:");
        g.bellmanFord(0);



    }
}