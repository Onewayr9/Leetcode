public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] index = new int[primes.length];
        int[] ans = new int[n];
        ans[0] = 1;
        for(int i=1;i<n;i++){
            ans[i] = Integer.MAX_VALUE;
            for(int j=0;j<index.length;j++){
                ans[i] = Math.min(ans[i],primes[j]*ans[index[j]]);
            }
            for(int j=0;j<index.length;j++){
                if(ans[i]==primes[j]*ans[index[j]]){
                    index[j]++;
                }
            }
        }
        return ans[n-1];
    }
}