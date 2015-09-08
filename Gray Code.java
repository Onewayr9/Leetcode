public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        if(n==0) return ans;
        else grayCode(ans,0,1<<n);
        return ans;
    }
    public void grayCode(List<Integer> ans,int begin,int n){
        if(begin==n-1) return;
        else{
            for(int i=1;;i*=2){
                if(!ans.contains(ans.get(begin)^i)){
                    ans.add(ans.get(begin)^i);
                    break;
                }
            }
            grayCode(ans,begin+1,n);
        }
    }
}