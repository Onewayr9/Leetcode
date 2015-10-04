public class Solution {
    public int candy(int[] ratings) {
        if(ratings.length<=1){
            return ratings.length;
        }
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for(int i=1;i<candy.length;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i] = candy[i-1]+1;
            }else{
                candy[i] = 1;
            }
        }
        int ans = candy[candy.length-1];
        for(int i=candy.length-2;i>=0;i--){
            int temp = 1;
            if(ratings[i]>ratings[i+1]){
                temp = candy[i+1]+1;
            }
            ans+=Math.max(temp,candy[i]);
            candy[i] = temp;
        }
        return ans;
    }
}