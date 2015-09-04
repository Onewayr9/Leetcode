public class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length==0) return ans;
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<Integer>();
        int len = nums.length;
        find(nums,temp,0,len);
        return ans;
    }
    public void find(int[] nums,List<Integer> temp,int begin,int len){
        if(begin==len){
            List<Integer> tem2 = new ArrayList<Integer>();
            tem2.addAll(temp);
            ans.add(tem2);
        }
        else{
            for(int i=begin;i<len;i++){
                if(!containsDuplicate(nums,begin,i)) continue;
                temp.add(nums[i]);
                swap(nums,begin,i);
                find(nums,temp,begin+1,len);
                swap(nums,begin,i);
                temp.remove(begin);
            }
        }
    }
    public void swap(int[] a, int i, int j) {
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
    }
    private boolean containsDuplicate(int[] arr, int start, int end) {
	    for (int i = start; i <= end-1; i++) {
		    if (arr[i] == arr[end]) {
			    return false;
		    }
	    }
	    return true;
    }
}