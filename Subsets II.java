public class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans.add(new ArrayList<Integer>());
        if(nums.length==0) return ans;
        else{
            Arrays.sort(nums);
            int len = nums.length;
            List<Integer> temp = new ArrayList<Integer>();
            subsetsWithDup(nums,temp,0,len);
        }
        return ans;
    }
    public void subsetsWithDup(int[] nums,List<Integer> temp,int begin,int len){
        if(begin<len){
            for(int i=begin;i<len;i++){
                if(i>begin&&nums[i]==nums[i-1]) continue;
                temp.add(nums[i]);
                List<Integer> tem2 = new ArrayList<Integer>();
                tem2.addAll(temp);
                ans.add(tem2);
                subsetsWithDup(nums,temp,i+1,len);
                temp.remove(temp.size()-1);
            }
        }
    }
}