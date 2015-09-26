import java.util.Hashtable;
public class Solution {
    public String minWindow(String s, String t) {
        if(t.length()==0){
            return "";
        }
        Hashtable<Character,Integer> ttable = new Hashtable<Character,Integer>();
        for(int i=0;i<t.length();i++){
            if(ttable.containsKey(t.charAt(i))){
                ttable.put(t.charAt(i),ttable.get(t.charAt(i))+1);
            }else{
                ttable.put(t.charAt(i),1);
            }
        }
        int len = 0,sum = 0,pointer_1 = 0,pointer_2 = 0;
        boolean find = false;
        Hashtable<Character,Integer> stable = new Hashtable<Character,Integer>();
        for(;pointer_1<s.length();++pointer_1){
            if(ttable.containsKey(s.charAt(pointer_1))){
                break;
            }
        }
        if(pointer_1==s.length()) return "";
        else if(t.length()==1) return t;
        stable.put(s.charAt(pointer_1),1);
        pointer_2 = pointer_1;
        sum++;
        for(int i=pointer_2+1;i<s.length();i++){
            if(ttable.containsKey(s.charAt(i))){
                if(!stable.containsKey(s.charAt(i))){
                    stable.put(s.charAt(i),1);
                    sum++;
                }else if(stable.get(s.charAt(i))<ttable.get(s.charAt(i))){
                    stable.put(s.charAt(i),stable.get(s.charAt(i))+1);
                    sum++;
                }else if(s.charAt(pointer_2)==s.charAt(i)){
                    pointer_2++;
                    for(;pointer_2<s.length();pointer_2++){
                        if(ttable.containsKey(s.charAt(pointer_2))){
                            if(stable.get(s.charAt(pointer_2))>ttable.get(s.charAt(pointer_2))){
                                stable.put(s.charAt(pointer_2),stable.get(s.charAt(pointer_2))-1);
                            }else{
                                break;
                            }
                    }
                }
                }else{
                    stable.put(s.charAt(i),stable.get(s.charAt(i))+1);
                }
            }
            if(sum==t.length()){
                find = true;
                if((i-pointer_2+1)<len||len==0){
                    pointer_1 = pointer_2;
                    len = (i-pointer_2+1);
                }
                stable.put(s.charAt(pointer_2),stable.get(s.charAt(pointer_2))-1);
                pointer_2 = pointer_2+1;
                for(;pointer_2<s.length();pointer_2++){
                    if(ttable.containsKey(s.charAt(pointer_2))){
                        if(stable.get(s.charAt(pointer_2))>ttable.get(s.charAt(pointer_2))){
                            stable.put(s.charAt(pointer_2),stable.get(s.charAt(pointer_2))-1);
                        }else{
                            break;
                        }
                    }
                }
                sum--;
            }
        }
        if(!find) return "";
        else return s.substring(pointer_1,pointer_1+len);
    }
}