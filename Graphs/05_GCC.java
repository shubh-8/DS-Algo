
   public static void gcc(ArrayList<Edge>[] graph, ArrayList<Integer> comp, boolean vis[] , int src){
       comp.add(src);
       vis[src] = true;
       for(Edge e: graph[src]){
           if(vis[e.nbr] == false){
               gcc(graph,comp,vis,e.nbr);
           }
       }
   }
   
   public static void getComponents(ArrayList<Edge>[] graph, ArrayList<ArrayList<Integer>> comps ){
       boolean vis[] = new boolean[graph.length];
       for(int i=0; i<graph.length; i++){
           if(vis[i] == false){
               ArrayList<Integer> comp = new ArrayList();
               gcc(graph,comp,vis,i);
               comps.add(comp);
           }
       }
   }


      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      // write your code here
      getComponents(graph,comps);
      System.out.println(comps);
   
