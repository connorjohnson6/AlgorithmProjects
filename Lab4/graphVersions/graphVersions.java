package graphVersions;
import java.util.LinkedList;
import linkedList.linkedList;
import java.util.Queue;
import java.util.Stack;


// code was copied and then editied from https://www.youtube.com/watch?v=6rDKLqFLfh0 

public class graphVersions {

    private linkedList<Integer>[] adj;
    private int Vertices;
    private int Edges;    

    public graphVersions(int nodes) {
        this.Vertices = nodes;
        this.Edges = 0;
        this.adj = new linkedList[nodes]; //doubly linked list
        // Loop over all vertices in the graph
        for(int vertex = 0; vertex < Vertices; vertex++){  
            // Add an empty ArrayList to the adjacency list for each vertex
            adj[vertex] = new linkedList<>();
        }
    }

    //creates adjecency between the beginning and the target vertices
    public void addEdge(int source, int destination) {
        //add the -1 so that we don't include vertex 0 (also included in toString() method)
        adj[source].add(destination);
        adj[destination].add(source);
        Edges++;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(Vertices +  " vertices " + Edges  + " edges " + "\n");
        for(int vertex = 0; vertex < Vertices; vertex++){
            sb.append((vertex) + ": ");
            for(int w : adj[vertex]){
                sb.append((w) + " ");
            }
            sb.append("\n");
        }
        return sb.toString();

    }

    // code was copied and then editied from https://www.youtube.com/watch?v=grewOnmAd0k
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[Vertices];
        Queue<Integer> queued = new LinkedList<>();
        visited[startVertex] = true;
        queued.offer(startVertex);
    
        while(!queued.isEmpty()) {
            int u = queued.poll();
            System.out.print((u) + " ");
    
            for(int vertex : adj[u]) {
                if(!visited[vertex]) { 
                    visited[vertex] = true;
                    queued.offer(vertex);
                }
            }
        }
    }


    // code was copied and then editied from https://www.youtube.com/watch?v=Wzk6BBEBlYE&t=1s 
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[Vertices];
        Stack<Integer> stack = new Stack<>();
    
        stack.push(startVertex);
    
        while(!stack.isEmpty()) {
            int u = stack.pop();
    
            if(!visited[u]) {
                visited[u] = true;
                System.out.print((u) + " ");
    
                // Push the adjacent vertices onto the stack in the order in which they appear in the linked list
                linkedList<Integer> adjList = adj[u];
                for(int i = adjList.size() - 1; i >= 0; i--) {
                    int v = adjList.get(i);
                    if(!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }
    }
    
    
    


    public class matrix {

        private int [][] adjMatrix;
        private int Vertices;
        private int Edges;
    
        public matrix(int nodes) {
            this.Vertices = nodes;
            this.Edges = 0;
            this.adjMatrix = new int[nodes][nodes];
        }
        
    
        //creates adjecency between the beginning and the target vertices
        public void addEdge(int source, int destination) {
            adjMatrix[source][destination] = 1;
            adjMatrix[destination][source] = 1;
            Edges++;
        }
        
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Vertices + " verticies, " + Edges + " edges " + "\n");
            
            // Iterate over each vertex in the graph
            for(int vertex = 0; vertex < Vertices; vertex++) {
                // Append the vertex number to the string
                sb.append(vertex).append(": ");
    
                // Iterate over each adjacent vertex of the current vertex
                for(int w : adjMatrix[vertex]){
                    sb.append(w + " ");
                }
                
                sb.append("\n");
            }
            return sb.toString();
        }
    
    }
    
    

    
}