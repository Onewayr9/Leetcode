public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length()==0) return s.length()==0;
        else{
            if(p.length()==1){
                if(s.length()<1) return false;
                else if(s.charAt(0)!=p.charAt(0)&&p.charAt(0)!='.') return false;
                else return isMatch(s.substring(1),p.substring(1));
            }
            if(p.charAt(1)!='*'){
                if(s.length()<1) return false;
                else if(s.charAt(0)!=p.charAt(0)&&p.charAt(0)!='.') return false;
                else return isMatch(s.substring(1),p.substring(1));
            }
            if(p.charAt(1)=='*'){
                if(isMatch(s,p.substring(2))) return true;
                int i=0;
                while(i<s.length()&&(s.charAt(i)==p.charAt(0)||p.charAt(0)=='.')){
                    if(isMatch(s.substring(i+1),p.substring(2))) return true;
                    i++;
                }
                return false;
            }
            return false;
        }
    }
}
/*Another Sol: Using DP, Time Complexity:O(n^3)*/
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] ans = new boolean[s.length()+1][p.length()+1];
        ans[0][0] = true;
        for(int j=1;j<=p.length();j++){
            char c = p.charAt(j-1);
            for(int i=0;i<=s.length();i++){
                if(c!='*'){
                    if(i==0){
                        ans[i][j] = false;
                    }else if(c=='.'){
                        ans[i][j] = ans[i-1][j-1];
                    }else{
                        ans[i][j] = ans[i-1][j-1]&&s.charAt(i-1)==p.charAt(j-1);
                    }
                }else{
                    if(ans[i][j-2]){
                        ans[i][j] = true;
                    }else{
                        int k = i;
                        while(k>0&&(s.charAt(k-1)==p.charAt(j-2)||p.charAt(j-2)=='.')){
                            if(ans[k-1][j-2]){
                                ans[i][j] = true;
                                break;
                            }
                            k--;
                        }
                    }
                }
            }
        }
        return ans[s.length()][p.length()];
    }
}