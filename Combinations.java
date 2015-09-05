public class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        if(n==0||n<k) return ans;
        else{
            List<Integer> temp = new ArrayList<Integer>();
            combine(n,1,k,temp);
        }
        return ans;
    }
    public void combine(int n,int begin,int time,List<Integer> temp){
        if(time==0){
            List<Integer> tem2 = new ArrayList<Integer>();
            tem2.addAll(temp);
            ans.add(tem2);
        }else{
            for(int i=begin;i<=n-time+1;i++){
                temp.add(i);
                combine(n,i+1,time-1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}