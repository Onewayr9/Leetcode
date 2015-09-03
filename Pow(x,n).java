public class Solution {
    public double myPow(double x, int n) {
        boolean isNeg = false;
        if(n<0){
            isNeg = true;
            n = 0-n;
        }
        double ans = 1;
        String binary = Integer.toBinaryString(n);
        double temp = x;
        for(int i=binary.length()-1;i>=0;i--){
            if(binary.charAt(i)=='1') ans*=temp;
            temp *= temp;
        }
        return isNeg? 1/ans:ans;
    }
}