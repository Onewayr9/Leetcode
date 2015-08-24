public class Solution {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(n>9*k||n<k)
            return ans;
        else{
            combination(1,k,n,temp,ans);
        }
        return ans;
    }
    public static void combination(int start,int k,int n,List<Integer> temp,List<List<Integer>> ans){
    	if(n==0&&temp.size()==k){
            List<Integer> list = new ArrayList<Integer>();
            list.addAll(temp);
            ans.add(list);
                //temp.remove(temp.size()-1);
    	}
        for(int i=start;i<=9;i++){ 
        	if(n-i<0) break;
        	if(temp.size()>k) break;
        	temp.add(i);
        	combination(i+1,k,n-i,temp,ans);
            temp.remove(temp.size()-1);
        }
    }
}