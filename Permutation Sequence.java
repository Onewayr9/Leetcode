public class Solution {
    public String getPermutation(int n, int k) {
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = i+1;
        }
        for(int i=1;i<k;i++) {nextPermutation(ans);}
        String ans2 = "";
        for(int i=0;i<n;i++){
            ans2+=ans[i];
        }
        return ans2;
    }
    public void nextPermutation(int[] nums) {
        if(nums.length>1){
            boolean isDescend = true;
            for(int i=nums.length-1;i>0;i--){
                if(nums[i]>nums[i-1]){
                    for(int j=nums.length-1;j>=i;j--){
                        if(nums[j]>nums[i-1]){
                            int temp = nums[j];
                            nums[j] = nums[i-1];
                            nums[i-1] = temp;
                            Arrays.sort(nums,i,nums.length);
                            break;
                        }
                    }
                    isDescend = false;
                    break;
                }
            }
            if(isDescend==true) Arrays.sort(nums);
        }
    }
}