public class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<Integer>();
        List<Integer> temp1 = new ArrayList<Integer>();
        ans.add(temp1);
        if(nums.length==0) return ans;
        Arrays.sort(nums);
        subsets(temp,nums,nums.length,0);
        return ans;
    }
    public void subsets(List<Integer> temp,int[] nums,int len,int begin){
        if(begin<len){
            for(int i=begin;i<len;i++){
                temp.add(nums[i]);
                List<Integer> tem2 = new ArrayList<Integer>();
                tem2.addAll(temp);
                ans.add(tem2);
                subsets(temp,nums,len,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}