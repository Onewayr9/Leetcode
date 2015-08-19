public class Solution {
    public String addBinary(String a, String b) {
        String ans = "";
        int sum = 0;
        for(int i=a.length()-1,j=b.length()-1;Math.max(i,j)>=0;i--,j--){
            int c = 0,d = 0;
            if(i>=0) c = a.charAt(i)-'0';
            if(j>=0) d = b.charAt(j)-'0';
            ans = (c+d+sum)%2 + ans;
            sum = (c+d+sum)/2;
        }
        if(sum==1) ans = "1" + ans;
        return ans;
    }
}