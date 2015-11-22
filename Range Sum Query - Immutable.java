public class NumArray {
    long[] sums;
    public NumArray(int[] nums) {
        sums = new long[nums.length+1];
        sums[0] = 0;
        for(int i=1;i<=nums.length;i++){
            sums[i] = sums[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return (int)(sums[j+1] - sums[i]);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);