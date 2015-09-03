import java.util.Hashtable;
public class Solution {
    List<List<String>> ans = new ArrayList<List<String>>();
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) return ans;
        Arrays.sort(strs);
        Hashtable<String,Integer> store = new Hashtable<String,Integer>();
        int num = 0;
        for(int i=0;i<strs.length;i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String t = String.valueOf(arr);
            if(store.get(t)==null){
                store.put(t,num++);
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                ans.add(temp);
            }else{
                ans.get(store.get(t)).add(strs[i]);
            }
        }
        return ans;
    }
}