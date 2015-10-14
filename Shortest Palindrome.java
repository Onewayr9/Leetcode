/*brute-force solution, running time O(n^2). It can also be solved by 
KMP algorithm in linear time. In next version I will do it:)*/
public class Solution {
    public String shortestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        String result = null;
        int len = s.length();
        int mid = (len-1)/2;
        for(int i=mid;i>=0;i--){
            if(s.charAt(i)==s.charAt(i+1)) {
    		    if ((result = scanFromCenter(s,i,i+1)) != null)
    				return result;
    		}
    		if ((result = scanFromCenter(s,i,i)) != null)
    				return result;
    	}
    	return result;
    }
    public String scanFromCenter(String s,int l,int r){
        int i=1;
        for(;l-i>=0&&r+i<s.length();i++){
            if(s.charAt(l-i)!=s.charAt(r+i)){
                break;
            }
        }
        if(l-i>=0){
            return null;
        }
        StringBuilder sb = new StringBuilder(s.substring(r+i));
	    sb.reverse();
        return sb.append(s).toString();
    }
}