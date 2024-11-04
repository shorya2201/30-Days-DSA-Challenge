class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        if(s.length()==0) return "";
        int max = 1;

        for(int i = 0;i<s.length();i++){
            for(int j =0;j<=1;j++){
            int l = i;
            int r= i+j;

               while(l>=0 && r<s.length()&&s.charAt(l)==s.charAt(r)){
                if(r-l+1>max){ max = r-l+1; start=l;}
                
                l--;
                r++;
                }
            
            }
        }
        return s.substring(start,start+max);
    }
}
