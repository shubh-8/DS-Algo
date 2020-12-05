import java.util.*;
public class MinMaxPath
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
    
    static int s_wsf = Integer.MAX_VALUE;
    static String s_psf;
    static int l_wsf = Integer.MIN_VALUE;
    static String l_psf;
    public static void smallestPath(int src, int dest, ArrayList<Edge>[] graph,boolean [] vis, String psf, int wsf){
        if(src == dest)
        {
            System.out.println(psf+" -> "+wsf);
            if(wsf < s_wsf)
            {
                s_psf = psf;
                s_wsf = wsf;
            }
            if(wsf > l_wsf)
            {
                l_psf = psf;
                l_wsf = wsf;
            }
            return;
        }
        
        vis[src] = true;
        for(Edge e: graph[src]){
            if(vis[e.nbr] == false)
            {
                smallestPath(e.nbr,dest,graph,vis,psf+e.nbr+" ",wsf+e.wt);
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
        boolean vis[] = new boolean[vertx];
        smallestPath(src, dest, graph, vis, src+" ", 0);
        System.out.println("Smallest Path"+"\n"+s_psf+" -> "+s_wsf);
        System.out.println("Largest Path"+"\n"+l_psf+" -> "+l_wsf);
    }
}
