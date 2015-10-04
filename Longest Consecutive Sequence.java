public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int max = 0;
        for(int e:nums){
            set.add(e);
        }
        for(int e:nums){
            int left = e-1;
            int right = e+1;
            int count = 1;
            while(set.contains(left)){
                set.remove(left);
                count++;
                left--;
            }
            while(set.contains(right)){
                set.remove(right);
                count++;
                right++;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}