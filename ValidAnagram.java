import java.util.Hashtable;
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        Hashtable<Character,Character> table = new Hashtable<Character,Character>();
        for(int i=0;i<schar.length;i++){
            if(!table.containsKey(schar[i])&&!table.containsValue(tchar[i]))
                table.put(schar[i],tchar[i]);
            else{
                if(!table.containsKey(schar[i]))
                    return false;
                if(table.get(schar[i])!=tchar[i])
                    return false;
            }
        }
        return true;
    }
}