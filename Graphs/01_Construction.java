import java.io.*;
import java.util.*;

public class Graph {
    
    static class Edge{
        int v1, v2, wt;
        Edge(int v1, int v2, int wt){
            this.v1 = v1;
            this.v2 = v2;
            this.wt = wt;
        }
    }
    
    public static void addEdge(ArrayList<Edge>[] graph, int v1, int v2, int wt){
        graph[v1].add(new Edge(v1,v2,wt));
        graph[v2].add(new Edge(v2,v1,wt));
    }
    
    public static void display(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            System.out.print("["+i+"] ->");
            for(Edge e: graph[i]){
                System.out.print(" ("+e.v1+"-"+e.v2+" @ "+e.wt+")");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) throws Exception {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        
        for(int i = 0; i < vtces; i++){
         graph[i] = new ArrayList<>();
        }
        
        int edges = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < edges; i++){
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         addEdge(graph,v1,v2,wt);
        }
        
        display(graph);
    }

}
