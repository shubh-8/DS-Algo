
  static class Tpair{
      int ht;
      boolean isBal;
      Tpair(){
          ht = -1;
          isBal = true;
      }
  }
  
  public static Tpair isBalance(Node node){
      if(node == null){
          return new Tpair();
      }
      
      Tpair lres = isBalance(node.left);
      Tpair rres = isBalance(node.right);
      
      Tpair mres = new Tpair();
      boolean status = false;
      
      int dif = lres.ht - rres.ht;
      if( dif >= -1 && dif <= 1){
          status = true;
      }
      
      mres.ht = Math.max(lres.ht,rres.ht) + 1;
      mres.isBal = lres.isBal && rres.isBal && status;
      
      return mres;
  }

 // write your code here
    Tpair res = isBalance(root);
    System.out.println(res.isBal);
  
