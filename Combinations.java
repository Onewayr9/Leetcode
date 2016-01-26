public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        combineList(1,n,k,new ArrayList<>());
        return ans;
    }
    public void combineList(int start, int n, int k, List<Integer> temp){
        if(k==0){
            List<Integer> tempadd = new ArrayList<>(temp);
            ans.add(tempadd);
        }
        for(int i=start;i<=n;i++){
            temp.add(i);
            combineList(i+1,n,k-1,temp);
            temp.remove(temp.size()-1);
        }
    }
}