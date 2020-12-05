import java.util.*;
public class CeilFloorWtPath
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
    
    static int floor_wsf = Integer.MAX_VALUE;
    static String floor_psf;
    static int ceil_wsf = Integer.MIN_VALUE; // greatest weight but smaller than criteria
    static String ceil_psf;
    public static void smallestPath(int src, int dest, ArrayList<Edge>[] graph,boolean [] vis, String psf, int wsf, int criteria){
        if(src == dest)
        {
            System.out.println(psf+" -> "+wsf);
            if(wsf < criteria && wsf > ceil_wsf)
            {
                ceil_psf = psf;
                ceil_wsf = wsf;
            }
            if(wsf > criteria && wsf < floor_wsf)
            {
                floor_psf = psf;
                floor_wsf = wsf;
            }
            return;
        }
        
        vis[src] = true;
        for(Edge e: graph[src]){
            if(vis[e.nbr] == false)
            {
                smallestPath(e.nbr,dest,graph,vis,psf+e.nbr+" ",wsf+e.wt,criteria);
            }
        }
        vis[src] = false;
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
        
        int src = sc.nextInt();
        int dest = sc.nextInt();
        int criteria = sc.nextInt();
        boolean vis[] = new boolean[vertx];
        smallestPath(src, dest, graph, vis, src+" ", 0,criteria);
        System.out.println("Ceil before criteria: "+"\n"+ceil_psf+" -> "+ceil_wsf);
        System.out.println("Floor after criteria: "+"\n"+floor_psf+" -> "+floor_wsf);
    }
}
