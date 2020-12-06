import java.util.*;

public class HamiltonianCycle
{
    static class Edge
    {
        int src, nbr, wt;
        Edge(int s, int n, int w)
        {
            src = s;
            nbr = n;
            wt = w;
        }
    }
    public static void hamiltonianPath(int src, ArrayList<Edge>[] graph,
                                        HashSet<Integer> vis, String psf)
    {
        if(vis.size() == graph.length-1)
        {
            System.out.print(psf);
            if(ishamiltonianCycle(graph,psf))
                System.out.println("*");
            else
                System.out.println(".");
            return;
        }
        vis.add(src);
        for(Edge e : graph[src])
        {
            if(vis.contains(e.nbr) == false)
            {
                hamiltonianPath(e.nbr,graph,vis,psf+e.nbr+" ");
            }
        }
        vis.remove(src);
    }
    
    public static boolean ishamiltonianCycle(ArrayList<Edge>[] graph, String psf)
    {
        int src = Integer.parseInt(psf.charAt(0)+"");
        int dest = Integer.parseInt(psf.charAt(psf.length()-2)+"");
        for(Edge e:graph[dest])
        {
            if(src == e.nbr)
                return true;
        }
        return false;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int vtx = sc.nextInt();
        int edge = sc.nextInt();
        
        ArrayList<Edge>[] graph = new ArrayList[vtx];
        for(int i=0;i<vtx; i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<edge; i++)
        {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int wt = sc.nextInt();
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }
        HashSet<Integer> vis = new HashSet<>();
        int src = sc.nextInt();
        hamiltonianPath(src,graph,vis,src+" ");
        
    }
}
