public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int p1 = 0,p2 = 0,len = 0;
        for(;p2<c.length;p2++){
            if(map.containsKey(c[p2])&&map.get(c[p2])>=p1){
                len = Math.max(len,p2-p1);
                p1 = map.get(c[p2])+1;
            }
            map.put(c[p2],p2);
        }
        return Math.max(len,p2-p1);
    }
}