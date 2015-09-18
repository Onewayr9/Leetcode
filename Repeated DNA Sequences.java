import java.util.Hashtable;
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();
        if(s.length()<10) return ans;
        else{
            Hashtable<String,Integer> table = new Hashtable<String,Integer>();
            //System.out.println(s.length());
            for(int i=0;i<s.length()-9;i++){
                String str = s.substring(i,i+10);
                if(!table.containsKey(str)) table.put(str,1);
                else if(table.get(str)==1){
                    ans.add(str);
                    table.remove(str);
                    table.put(str,2);
                }
                else{
                    table.remove(str);
                    table.put(str,2);
                }
            }
            return ans;
        }
    }
}