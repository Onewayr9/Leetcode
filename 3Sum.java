public class Solution {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3) return ret;
        
        Arrays.sort(num);
        
        int len = num.length;
        for (int i = 0; i < len-2; i++) {
            if(num[i]>0) break;
            if (i > 0 && num[i] == num[i-1]) continue;
            find(num, i+1, len-1, num[i]);
        }
        
        return ret;
    }
    
    public void find(int[] num, int begin, int end, int target) {
        int l = begin, r = end;
        while (l < r) {
            if (num[l] + num[r] + target == 0) {
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(target);
                ans.add(num[l]);
                ans.add(num[r]);
                ret.add(ans);
                while (l < r && num[l] == num[l+1]) l++;
                while (l < r && num[r] == num[r-1]) r--;
                l++;
                r--;
            } else if (num[l] + num[r] + target < 0) {
                l++;
            } else {
                r--;
            }
        }
    }
}