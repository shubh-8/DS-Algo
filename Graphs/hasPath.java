/* 
INPUT
7
8
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8 
0 6
*/
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
    
    public static boolean hasPath(int src, int dest, ArrayList<Edge> [] graph, boolean [] vis)
    {
        if (src == dest)
            return true;
            
        vis[src] = true;
        boolean hp = false;
        for(Edge e : graph[src])
        {
            if(vis[e.nbr] == false){
                hp = hasPath(e.nbr,dest,graph,vis);
            }
            if(hp == true)
                return true;
                
        }
        return false;
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
        System.out.println(hasPath(src,dest,graph,vis));
    
     }
}
