public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        Arrays.sort(nums);
        for(int i=0;i<(nums.length-nums.length/3);i++){
            if(nums[i]==nums[i+nums.length/3]&&!ans.contains(nums[i])){
                ans.add(nums[i]);
                i = i+nums.length/3;
            }
        }
        return ans;
    }
}