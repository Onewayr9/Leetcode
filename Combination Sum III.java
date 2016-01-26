public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combine(k,1,n,new ArrayList<>());
        return ans;
    }
    public void combine(int k, int begin, int n, List<Integer> temp){
        if(k==1){
            if(n>=begin&&n<=9){
                List<Integer> tempadd = new ArrayList<>(temp);
                tempadd.add(n);
                ans.add(tempadd);
            }
            return;
        }
        for(int i=begin;i<=n/k;i++){
            temp.add(i);
            combine(k-1,i+1,n-i,temp);
            temp.remove(temp.size()-1);
        }
    }
}