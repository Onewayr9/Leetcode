public class Solution {
    public int[] plusOne(int[] digits) {
        if((digits[digits.length-1]+1)%10!=0){
            digits[digits.length-1]++;
            return digits;
        }
        ArrayList<Integer> anslist = new ArrayList<Integer>();
        int sum = 1;
        anslist.add(0);
        for(int i=digits.length-2;i>=0;i--){
            anslist.add((digits[i]+sum)%10);
            sum = (digits[i]+sum)/10;
        }
        if(sum==1) anslist.add(1);
        int[] ans = new int[anslist.size()];
        for(int i=0;i<anslist.size();i++)
            ans[i] = anslist.get(anslist.size()-i-1);
        return ans;
    }
}