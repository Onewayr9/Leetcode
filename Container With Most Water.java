public class Solution {
    public int maxArea(int[] height) {
        if(height.length==0||height.length==1) return 0;
        else{
            int ans = 0,left = 0,right = height.length-1;
            while(left<right){
                ans = Math.max(ans,Math.min(height[left],height[right])*(right-left));
                if(height[left]<height[right])
                    left++;
                else right--;
            }
            return ans;
        }
    }
}