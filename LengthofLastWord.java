public class Solution {
    public int lengthOfLastWord(String s) {
        String[] stringgroup = s.split(" ");
        if(stringgroup.length==0)
            return 0;
        else return (stringgroup[stringgroup.length-1].length());
    }
}