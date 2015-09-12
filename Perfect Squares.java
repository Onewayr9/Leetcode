public class Solution {
    public int numSquares(int n) {
        if(n==0) return 1;
        else{
            int[] ans = new int[n+1];
            ans[0] = 1;
            ans[1] = 1;
            for(int i=1;i<n+1;i++){
                for(int j=1;j*j<=i;j++)
                    if(j*j==i) ans[i]=1;
                //System.out.println(ans[i]);
                for(int j=1;j<=i&&j+i<n+1;j++){
                    //System.out.println(ans[i+j]+" "+ans[i]);
                    if(ans[i+j]==0||(ans[i+j]>ans[i]+ans[j])) ans[i+j] = ans[i]+ans[j];
                }
            }
            return ans[n];
        }
    }
}