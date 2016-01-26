public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        helper(new ArrayList<Integer>(),nums,0,len);
        return ans;
    }
    public void helper(List<Integer> temp,int[] nums,int begin,int len){
        ArrayList<Integer> tempadd = new ArrayList<>(temp);
        ans.add(tempadd);
        if(begin==len){
            return;
        }
        for(int i=begin;i<len;i++){
            if(i>begin&&nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            helper(temp,nums,i+1,len);
            temp.remove(temp.size()-1);
        }
    }
}