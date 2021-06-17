
   public static void allPaths(ArrayList<Edge>[] graphs, int src, int dest, boolean vis[], String psf){
       if(src == dest){
           System.out.println(psf);
           return;
       }
       vis[src] = true;
       for(Edge e: graphs[src]){
           if(vis[e.nbr] == false){
               allPaths(graphs,e.nbr,dest,vis,psf+e.nbr);
           }
       }
       vis[src] = false;
   }

      // write all your codes here
      boolean vis[] = new boolean[vtces];
      String psf = ""+src;
      allPaths(graph,src,dest,vis,psf);
