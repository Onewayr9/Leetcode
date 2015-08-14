import java.util.Hashtable;
public class Solution {
    public int majorityElement(int[] nums) {
        Hashtable <Integer,Integer> cal = new Hashtable();
        if(nums.length==1)
            return nums[0];
        for(int i=0;i<nums.length;i++){
            if(!cal.containsKey(nums[i]))
                cal.put(nums[i],1);
            else{
                int val = cal.get(nums[i]);
                cal.remove(nums[i]);
                cal.put(nums[i],val+1);
                if(val+1>nums.length/2)
                    return(nums[i]);
            }
        }
        return 0;
    }
}