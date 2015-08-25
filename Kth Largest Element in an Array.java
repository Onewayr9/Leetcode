public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return (nums[nums.length-k]);
    }
}
/* I just used sort in java and the time complexity is O(nlgn), quicksort is also available, which can reduce average complexity to O(n) while the worse complexity is O(n^2). */