
   public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean vis[] ){
       if(src == dest){
           return true;
       }
       boolean res = false;
       for(Edge e: graph[src]){
           if(vis[e.nbr] == false){
               vis[e.nbr] = true;
               res = res || hasPath(graph, e.nbr, dest, vis);
           }
       }
       return res;
   }


      // write your code here
      boolean vis[] = new boolean[vtces];
      boolean res = hasPath(graph, src, dest, vis);
      System.out.println(res);
