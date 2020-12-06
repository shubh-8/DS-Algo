/*
Input
7
5
0 1 
2 3
4 5
5 6
4 6
*/
import java.util.*;
public class PerfectFriends
{
    static class Edge
    {
        int v, u;
        Edge(int u, int v)
        {
            this.u = u;
            this.v = v;
        }
    }
    
    public static void generateComp(int src, ArrayList<Edge>[] graph,boolean[] vis,ArrayList<Integer> comp)
    {
        vis[src]=true;
        comp.add(src);
        
        for(Edge e: graph[src])
        {
            if(vis[e.v]==false)
            {
                generateComp(e.v, graph, vis, comp);
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
        int edge = sc.nextInt();
        for(int i=0; i<edge; i++)
        {
            int v = sc.nextInt();
            int u = sc.nextInt();
            graph[u].add(new Edge(u,v));
            graph[v].add(new Edge(v,u));
        }
        boolean vis[] = new boolean[vertx];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for(int i=0;i<vertx;i++)
        {
            if(vis[i]==false)
            {
                ArrayList<Integer>comp = new ArrayList<>();
                generateComp(i, graph, vis, comp);
                comps.add(comp);
            }
        }
        int combinations=0;
        for(int i=0;i<comps.size();i++)
        {
            for(int j=i+1;j<comps.size();j++)
            {
                combinations += comps.get(i).size() * comps.get(j).size();
            }
        }
        System.out.println(combinations);
    }
}
