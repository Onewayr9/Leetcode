public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        else{
            int[] ans = new int[s.length()];
            if(s.charAt(0)=='0') ans[0]=0;
            else ans[0]=1;
            if(s.length()==1) return ans[0];
            int a = (s.charAt(0)-'0')*10+(s.charAt(1)-'0');
            int b = (s.charAt(1)-'0');
            if(a>0&&a<=26&&b>0) ans[1] = ans[0]*(ans[0]+1);
            else if(a>0&&a<=26) ans[1] = ans[0];
            else if(b>0) ans[1] = ans[0];
            else ans[1] = 0;
            for(int i=2;i<ans.length;i++){
                a = (s.charAt(i-1)-'0')*10+(s.charAt(i)-'0');
                b = (s.charAt(i)-'0');
                int c = (s.charAt(i-1)-'0');
                if(a>0&&a<=26&&b>0&&c!=0) ans[i] = ans[i-1]+ans[i-2];
                else if(a>0&&a<26&c!=0) ans[i] = ans[i-2];
                else if(b>0) ans[i] = ans[i-1];
                else ans[i] = 0;
            }
            return ans[ans.length-1];
        }
    }
}