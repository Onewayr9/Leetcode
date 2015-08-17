public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
        else if(haystack.length()<needle.length())
            return -1;
        else{
            int pointer1 = 0;
            int pointer2 = needle.length()-1;
            for(;pointer2<haystack.length();pointer1++,pointer2++){
                if(haystack.substring(pointer1,pointer2+1).equals(needle))
                    return pointer1;
            }
        }
        return -1;
    }
}