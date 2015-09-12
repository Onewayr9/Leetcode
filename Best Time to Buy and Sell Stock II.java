public class Solution {
    public int maxProfit(int[] prices) {
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
}