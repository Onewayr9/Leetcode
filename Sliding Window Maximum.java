public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0||k>nums.length){
            return new int[0];
        }
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] ans = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            if(deque.size()>0&&deque.peekLast()-deque.peekFirst()+1==k){
                deque.pollFirst();
            }
            while(deque.size()>0&&nums[i]>nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i>=k-1){
                ans[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}