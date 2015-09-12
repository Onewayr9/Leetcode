public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0) return 0;
        else{
            int[][] ans = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
            for(int i=0;i<ans[0].length;i++){
                ans[ans.length-1][i] = triangle.get(triangle.size()-1).get(i);
            }
            for(int i=ans.length-2;i>=0;i--){
                for(int j=0;j<triangle.get(i).size();j++){
                    ans[i][j] = triangle.get(i).get(j) + Math.min(ans[i+1][j],ans[i+1][j+1]);
                }
            }
            return ans[0][0];
        }
    }
}