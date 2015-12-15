public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i=1;i<=s.length();i++){
            int single = s.charAt(i-1)-'0';
            if(single>0){
                dp[i] += dp[i-1];
            }
            if(i>1){
                if(s.charAt(i-2)!='0'){
                    int doub = Integer.parseInt(s.substring(i-2,i));
                    if(doub>0&&doub<=26){
                        dp[i] += dp[i-2];
                    }
                }
            }
        }
        return dp[s.length()];
    }
}