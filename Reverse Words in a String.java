public class Solution {
    public String reverseWords(String s) {
        String[] b = s.trim().split("\\s+");
        String[] c = new String[b.length];
        for(int i = 0;i< b.length;i++)
        c[i]=b[b.length-i-1];
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < c.length-1; i++){
            sb.append(c[i]+" ");
        }
        sb.append(c[c.length-1]);
        return sb.toString();
    }
}