import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    
    static class Edge{
        int src, nbr, wt;
        Edge(int s, int n, int w){
            src = s;
            nbr = n;
            wt = w;
        }
    }
    
    public static void hasAllPath(int src, int dest, ArrayList<Edge> [] graph, boolean [] vis, String ans)
    {
        if (src == dest)
        {
            System.out.println(ans);
            return;
        }
        vis[src] = true;
        for(Edge e : graph[src])
        {
            if(vis[e.nbr] == false){
                hasAllPath(e.nbr,dest,graph,vis,ans+e.nbr+" ");
            }
                
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int vert = sc.nextInt();
        ArrayList<Edge> [] graph = new ArrayList[vert];
        for(int i=0;i<vert;i++)
        {
            graph[i] = new ArrayList<Edge>();
        }
        
        int edges = sc.nextInt();
        for(int i=0;i<edges;i++)
        {
            // String [] path = (sc.next()).split(" ");
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int wt = sc.nextInt();
            // System.out.println(wt);
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }
        
        boolean [] vis = new boolean[vert];
        int src = sc.nextInt();
        int dest = sc.nextInt();
        hasAllPath(src,dest,graph,vis,src+" ");
    
     }
}
