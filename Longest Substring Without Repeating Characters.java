public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int len = 1;
        if(s.length()==0||s.length()==1) return s.length();
        else{
            int pointer1 = 0;
            int pointer2 = 1;
            set.add(s.charAt(0));
            int temp = 1;
            for(;pointer2<s.length();pointer2++){
                if(!set.contains(s.charAt(pointer2))){
                    temp++;
                    set.add(s.charAt(pointer2));
                }else{
                    if(temp>len) len=temp;
                    set.remove(s.charAt(pointer1++));
                    pointer2--;
                    temp--;
                }
            }
            if(temp>len) len=temp;
        }
        return len;
    }
}