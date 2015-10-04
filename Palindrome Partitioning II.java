public class Solution {
    public int minCut(String s) {
        if(s.length()<=1){
            return 0;
        }
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = i;
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j)&&(i-j<=1||palindrome[j+1][i-1])){
                    palindrome[j][i] = true;
                    if(j>0){
                        ans[i] = Math.min(ans[i],ans[j-1]+1);
                    }else{
                        ans[i] = 0;
                    }
                }
            }
        }
        return ans[n-1];
    }
}