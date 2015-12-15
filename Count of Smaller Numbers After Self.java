public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        List<Integer> sort = new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            int index = findIndex(nums[i],sort);
            ans[i] = index;
            sort.add(index,nums[i]);
        }
        return Arrays.asList(ans);
    }
    public int findIndex(int num, List<Integer> sort){
        if(sort.size()==0) return 0;
        int left = 0, right = sort.size()-1;
        while(left<=right){
            if(num<=sort.get(left)){
                return left;
            }else if(num>sort.get(right)){
                return right+1;
            }else{
                int mid = (left+right)/2;
                if(num<=sort.get(mid)){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }
        }
        return 0;
    }
}