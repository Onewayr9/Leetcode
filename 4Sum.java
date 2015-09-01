public class Solution {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length<4) return ret;
        else{
            Arrays.sort(nums);
            int len = nums.length;
            for(int i=0;i<nums.length-3;i++){
                if (i > 0 && nums[i] == nums[i-1]) continue;
                for(int j=i+1;j<nums.length-2;j++){
                    if (j > i+1 && nums[j] == nums[j-1]) continue;
                    find(nums,j+1,len-1,nums[i],nums[j],target);
                }
            }
        }
        return ret;
    }
    public void find(int[] num, int begin, int end, int target1, int target2, int target) {
        int l = begin, r = end;
        while (l < r) {
            if (num[l] + num[r] + target1 + target2 == target) {
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(target1);
                ans.add(target2);
                ans.add(num[l]);
                ans.add(num[r]);
                ret.add(ans);
                while (l < r && num[l] == num[l+1]) l++;
                while (l < r && num[r] == num[r-1]) r--;
                l++;
                r--;
            } else if (num[l] + num[r] + target1 + target2 < target) {
                l++;
            } else {
                r--;
            }
        }
    }
}