public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String>[] list = new ArrayList[s.length()+1];
        list[0] = new ArrayList<String>();
        for(int i=0;i<s.length();i++){
            if(list[i]==null){
                continue;
            }
            for(String e:wordDict){
                int len = e.length();
                int end = i+len;
                if(end>s.length()){
                    continue;
                }
                if(s.substring(i,end).equals(e)){
                    if(list[end]==null){
                        list[end] = new ArrayList<String>();
                    }
                    list[end].add(e);
                }
            }
        }
        List<String> ans = new ArrayList<String>();
        if(list[s.length()]==null){
            return ans;
        }
        ArrayList<String> temp = new ArrayList<String>();
        dfs(list,s.length(),ans,temp);
        return ans;
    }
    public void dfs(List<String>[] list,int end,List<String> ans,List<String> temp){
        if(end<=0){
            String copy = temp.get(temp.size()-1);
            for(int i=temp.size()-2;i>=0;i--){
                copy += " "+temp.get(i);
            }
            ans.add(copy);
            return;
        }
        for(String str:list[end]){
            temp.add(str);
            dfs(list,end-str.length(),ans,temp);
            temp.remove(temp.size()-1);
        }
    }
}