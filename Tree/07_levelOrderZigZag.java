  public static void levelOrderLinewiseZZ(Node node){
    // write your code here
    
    Stack<Node> mainS = new Stack();
    Stack<Node> childS = new Stack();
    mainS.push(node);
    int lvl = 1;
    
    while(mainS.size()>0)
    {
        while(mainS.size()>0)
        {
            Node rem = mainS.pop();
            System.out.print(rem.data+" ");
            if(lvl % 2  == 1){
                for(int i= 0; i<=rem.children.size()-1; i++)
                {
                    childS.push(rem.children.get(i));
                }
            }else{
                for(int i= rem.children.size()-1; i>=0; i--)
                {
                    childS.push(rem.children.get(i));
                }
            }
        }
        lvl++;
        Stack<Node> temp = mainS;
        mainS = childS;
        childS = temp;
        System.out.println();
    }
  }
