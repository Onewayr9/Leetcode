public class Solution {
    public int singleNumber(int[] nums) {
        int one = 0,two = 0,three = 0;
        for(int e:nums){
            two |= one&e;
            one ^= e;
            three = one&two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}