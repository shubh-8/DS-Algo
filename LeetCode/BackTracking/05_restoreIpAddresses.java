class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList();
        helper(s,ans,"",4);
        return ans;
    }
    
    public void helper(String s, List<String> ans, String asf, int dot){
        if(dot==0 || s.length()==0){
            if(dot==0 && s.length()==0){
                ans.add(asf.substring(0,asf.length()-1));
            }
            return;
        }
        
        char ch1 = s.charAt(0);
        helper(s.substring(1),ans,asf+ch1+'.',dot-1);
        if(ch1 != '0'&& s.length()>1){ 
            char ch2 = s.charAt(1);
            helper(s.substring(2),ans,asf+ch1+ch2+'.',dot-1);
            if(s.length()>2){
                char ch3 = s.charAt(2);
                int num = ((ch1-'0')*100)+((ch2-'0')*10)+(ch3-'0');
                // System.out.println(num);
                if(num<=255)
                    helper(s.substring(3),ans,asf+num+'.',dot-1);
            }
        }
        
    }
}
