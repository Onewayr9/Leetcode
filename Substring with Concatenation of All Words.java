import java.util.Hashtable;
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        int len = words.length*words[0].length();
        int wordlen = words[0].length();
        if(len>s.length()) return ans;
        else{
            Hashtable<String,Integer> table = new Hashtable<String,Integer>();
            for(int i=0;i<words.length;i++){
                if(!table.containsKey(words[i])) table.put(words[i],1);
                else table.put(words[i],table.get(words[i])+1);
            }
            int p1 = 0,p2 = 0;
            while(p1+len<=s.length()){
                Hashtable<String,Integer> temp = new Hashtable<String,Integer>();
                boolean canAdd = true;
                for(p2=p1;p2<p1+len;p2+=wordlen){
                    String tempword = s.substring(p2,p2+wordlen);
                    if(!table.containsKey(tempword)){
                        canAdd = false;
                        break;
                    }else if(!temp.containsKey(tempword)){
                        temp.put(tempword,1);
                    }else if(temp.get(tempword)==table.get(tempword)){
                        canAdd = false;
                        break;
                    }else{
                        temp.put(tempword,temp.get(tempword)+1);
                    }
                }
                if(canAdd){
                    ans.add(p1);
                }
                p1++;
            }
            return ans;
        }
    }
}