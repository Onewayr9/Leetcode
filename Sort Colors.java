public class Solution {
    public void sortColors(int[] nums) {
        if(nums.length==0) return;
        int p0 = -1;
        int p1 = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                p0++;
                if(i>0&&nums[i]<nums[i-1]) {
                    swap(nums,p0,i);
                    i--;
                }
            }else if(nums[i]==1){
                p1++;
                if(i>0&&nums[i]<nums[i-1]) {
                    swap(nums,p1,i);
                    i--;
                }
            }
            if(p1<p0) p1=p0;
        }
    }
    public void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}