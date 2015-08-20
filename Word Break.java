/* Dynamic Programming:
if(ans[j]&&wordDict.contains(s.substring(j,i)))
    ans[i]=true;
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s.length()==0)
            return true;
        else if(s.length()==1)
            return (wordDict.contains(s));
        else{
            boolean[] ans = new boolean[s.length()+1];
            ans[0] = true;
            ans[1] = wordDict.contains(s.substring(0,1));
            for(int i=2;i<=s.length();i++){
                for(int j=0;j<i;j++){
                    if(ans[j]&&wordDict.contains(s.substring(j,i)))
                        ans[i]=true;
                }
            }
            return ans[s.length()];
        }
    }
}