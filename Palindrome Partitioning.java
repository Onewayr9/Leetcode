public class Solution {
    List<List<String>> ans = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        char[] str = s.toCharArray();
        if(str.length==0) return ans;
        else{
            List<String> temp = new ArrayList<String>();
            partition(str,temp,0,str.length);
            return ans;
        }
    }
    public void partition(char[] str,List<String> temp,int begin,int len){
        if(begin==len){
            ArrayList<String> tem2 = new ArrayList<String>();
            tem2.addAll(temp);
            ans.add(tem2);
        }else{
            for(int i=begin;i<len;i++){
                if(isPartition(str,begin,i)){
                    temp.add(String.valueOf(str,begin,i-begin+1));
                    partition(str,temp,i+1,len);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
    public boolean isPartition(char[] str,int begin,int end){
        if(begin==end) return true;
        else{
            int i=begin;
            int j=end;
            while(i<=j){
                if(str[i]!=str[j]) return false;
                else{
                    i++;
                    j--;
                }
            }
            return true;
        }
    }
}