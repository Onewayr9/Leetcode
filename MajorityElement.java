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
/*Moore voting algorithm*/
public class Solution {
    public int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }
}
/*Bit Manipulation*/
public int majorityElement(int[] num) {

    int ret = 0;

    for (int i = 0; i < 32; i++) {

        int ones = 0, zeros = 0;

        for (int j = 0; j < num.length; j++) {
            if ((num[j] & (1 << i)) != 0) {
                ++ones;
            }
            else
                ++zeros;
        }

        if (ones > zeros)
            ret |= (1 << i);
    }

    return ret;
}