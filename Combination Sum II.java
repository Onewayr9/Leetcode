public class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length==0) return ans;
        else{
            Arrays.sort(candidates);
            List<Integer> temp = new ArrayList<Integer>();
            combinationSum2(candidates,target,0,temp);
        }
        return ans;
    }
    public void combinationSum2(int[] candidates,int target,int begin,List<Integer> temp){
        if(target==0){
            List<Integer> tem2 = new ArrayList<Integer>();
            tem2.addAll(temp);
            ans.add(tem2);
        }else if(begin<candidates.length&&target>0){
            for(int i=begin;i<candidates.length;i++){
                if(i>begin&&candidates[i]==candidates[i-1]) continue;
                temp.add(candidates[i]);
                combinationSum2(candidates,target-candidates[i],i+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}