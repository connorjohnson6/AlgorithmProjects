package graphVersions;

import linkedList.linkedList;
import java.util.*;

public class graphVersions {
    private linkedList<Edge>[] adj;
    private int Vertices;
    private int Edges;
    private int[] dist;
    private int[] prev;

    public graphVersions(int nodes) {
        this.Vertices = nodes;
        this.Edges = 0;
        this.adj = new linkedList[nodes];
        for (int vertex = 0; vertex < Vertices; vertex++) {
            adj[vertex] = new linkedList<>();
        }
        this.dist = new int[Vertices];
        this.prev = new int[Vertices]; 

    }

    public int[] getDist(int i) {
        return dist;
    }

    public void addEdge(int source, int destination, int weight) {
        adj[source].add(new Edge(source, destination, weight));
        adj[destination].add(new Edge(destination, source, weight));
        Edges++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Vertices-1 + " vertices " + Edges + " edges " + "\n");
        for (int vertex = 1; vertex <= Vertices-1; vertex++) {
            sb.append((vertex) + ": ");
            for (Edge e : adj[vertex-1]) {
                sb.append("(" + (e.vertex1+1) + ", " + (e.vertex2+1) + ", " + e.weight + ") ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }



    public void bellmanFord(int source) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[source] = 0;
    
        for (int i = 0; i < Vertices - 1; i++) {
            for (int u = 0; u < Vertices; u++) {
                for (Edge e : adj[u]) {
                    int v = e.vertex2;
                    int weight = e.weight;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        prev[v] = u;
                    }
                }
            }
        }
        
        // check for negative weight cycles
        for (int u = 0; u < Vertices; u++) {
            for (Edge e : adj[u]) {
                int v = e.vertex2;
                int weight = e.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    // use negative weight to subtract from the total weight of the path
                    dist[v] = dist[u] + weight;
                    prev[v] = u;
                }
            }
        }
        
        // print shortest distances and paths
        for (int i = 0; i < Vertices-1; i++) {
            if (i != source) {
                if (dist[i] == Integer.MAX_VALUE) {
                    System.out.println(source + " ⇾ " + (i+1) + " is not reachable");
                } else {
                    System.out.print(source + " ⇾ " + (i+1) + " cost is " + dist[i] + "; path is " + getPath(prev, i, source));
                    System.out.println();
                }
            }
        }
    }
    
    private String getPath(int[] prev, int vertex, int source) {
        StringBuilder path = new StringBuilder();
        path.append(vertex + 1);
        while (vertex != source && vertex != -1) {
            vertex = prev[vertex];
            path.insert(0, (vertex + 1) + " ⇾ ");
        }
        return path.toString();
    }
    


    
    public static class Edge {
        public int vertex1;
        public int vertex2;
        public int weight;
    
        public Edge(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }
    }
    

    private class Node implements Comparator<Node> {
        private int vertex;
        private int cost;

        public Node() {}

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2) {
            if (node1.cost < node2.cost) {
                return -1;
            }
            if (node1.cost > node2.cost) {
                return 1;
            }
            return 0;
        }
    }
}