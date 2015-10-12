public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(k==0){
            return 0;
        }
        if(k>=len){
            int profit = 0;
            if(prices.length<=1) return 0;
            else{
                for(int i=0,j=0;j<prices.length;j++){
                    if(j==prices.length-1||prices[j]>prices[j+1]){
                        profit += prices[j]-prices[i];
                        i = j+1;
                    }
                }
                return profit;
            }
        }
        int[][] local = new int[len][k + 1];
	    int[][] global = new int[len][k + 1];
 
	    for (int i = 1; i < len; i++) {
    		int diff = prices[i] - prices[i - 1];
    		for (int j = 1; j <= k; j++) {
    			local[i][j] = Math.max(
    					global[i - 1][j - 1] + Math.max(diff, 0),
    					local[i - 1][j] + diff);
    			global[i][j] = Math.max(global[i - 1][j], local[i][j]);
    		}
    	}
	    return global[prices.length - 1][k];
    }
}