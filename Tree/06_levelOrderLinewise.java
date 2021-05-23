
  public static void levelOrderLinewise01(Node node){
    // write your code here
    Queue<Node> mainQ = new ArrayDeque();
    Queue<Node> childQ = new ArrayDeque();
    mainQ.add(node);
    while(mainQ.size()>0){
        Node rem = mainQ.remove();
        System.out.print(rem.data+" ");
        for(Node child: rem.children){
            childQ.add(child);
        }
        if(mainQ.size()==0){
            Queue<Node> temp = mainQ;
            mainQ = childQ;
            childQ = temp;
            System.out.println();
        }
    }
  }
    
  public static void levelOrderLinewise02(Node node){
    // write your code here
    Queue<Node> que = new LinkedList();
    que.add(node);
    que.add(null);
    
    while(que.size()>0){
        Node rem = que.remove();
        if(rem == null){
            //hit enter
            System.out.println();
            // add null
            if(que.size()>0){
                que.add(null);
            }
        }else{
            System.out.print(rem.data+" ");
            for(Node child: rem.children){
                que.add(child);
            }
        }
    }
  }

//````````````````````````IMP```````````````````````````


  public static void levelOrderLinewise03(Node node){
    // write your code here
    Queue<Node> mainQ = new ArrayDeque();
    Queue<Node> childQ = new ArrayDeque();
    mainQ.add(node);
    while(mainQ.size()>0){
        Node rem = mainQ.remove();
        System.out.print(rem.data+" ");
        for(Node child: rem.children){
            childQ.add(child);
        }
        if(mainQ.size()==0){
            Queue<Node> temp = mainQ;
            mainQ = childQ;
            childQ = temp;
            System.out.println();
        }
    }
  }
