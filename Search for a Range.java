public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        if(nums.length==0) return ans;
        int mid = 0;
        int left = 0,right = nums.length-1;
        while(left<=right){
            int middle = (left+right)/2;
            if(nums[middle]==target){
                mid = middle;
                break;
            }else if(nums[middle]<target) left = middle+1;
            else if(nums[middle]>target) right = middle-1;
        }
        if(nums[mid]!=target) return ans;
        else{
            int ll = left,lr = mid,rl = mid,rr = right;
            while(ll<=lr){
                int lm = (ll+lr)/2;
                if(nums[ll]==target){
                    ans[0]=ll;
                    break;
                }else if(nums[lm]<target) ll = lm+1;
                else if(nums[lm-1]!=target){
                    ans[0]=lm;
                    break;
                }else lr = lm-1;
            }
            while(rl<=rr){
                int rm = (rl+rr)/2;
                if(nums[rr]==target){
                    ans[1]=rr;
                    break;
                }else if(nums[rm]>target) rr = rm-1;
                else if(nums[rm+1]!=target){
                    ans[1]=rm;
                    break;
                }else rl = rm+1;
            }
        }
        return ans;
    }
}