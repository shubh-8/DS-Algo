import java.util.*;
public class FindGraphComponent
{
    static class Edge
    {
        int src, nbr, wt;
        Edge(int src, int nbr, int wt)
        {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    
    public static void generateComp(int src, ArrayList<Edge>[] graph,boolean [] vis, ArrayList<Integer> comp)
    {
        vis[src] = true;
        comp.add(src);
        for(Edge e: graph[src])
        {
            if(vis[e.nbr] == false)
            {
                generateComp(e.nbr,graph,vis,comp);
            }
        }
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int vertx = sc.nextInt();
        
        ArrayList<Edge>[] graph = new ArrayList[vertx];
        for(int i=0; i<vertx; i++)
        {
            graph[i] = new ArrayList<>();
        }
        
        int edges = sc.nextInt();
        for(int i = 0; i<edges; i++)
        {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int wt = sc.nextInt();
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }
        
        boolean vis[] = new boolean[vertx];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for(int i=0; i<vertx; i++)
        {
            if(vis[i] == false)
            {
                ArrayList<Integer> comp = new ArrayList<>();
                generateComp(i,graph,vis,comp);
                comps.add(comp);
            }
        }
        
        System.out.println(comps);
        
    }
}
