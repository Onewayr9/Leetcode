public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0)
            return Integer.MAX_VALUE;
        boolean isNeg = (dividend^divisor)>>>31==1;
        int ans = 0;
        if(dividend==Integer.MIN_VALUE){
            dividend+=divisor;
            if(divisor==-1) return Integer.MAX_VALUE;
            ans++;
        }
        if(divisor==Integer.MIN_VALUE) return ans;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int pos = 0;
        while(divisor<=(dividend>>1)){
            divisor<<=1;
            pos++;
        }
        while(pos>=0){
            if(dividend>=divisor){
                ans += 1<<pos;
                dividend -= divisor;
            }
            divisor>>=1;
            pos--;
        }
        return isNeg? -ans:ans;
    }
}