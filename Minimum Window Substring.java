public class Solution {
    public String minWindow(String s, String t) {
        if(t.length()==0){
            return "";
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),1);
            }else{
                map.put(t.charAt(i),map.get(t.charAt(i))+1);
            }
        }
        char[] c = s.toCharArray();
        int p1 = 0;
        int findNum = 0;
        for(;p1<c.length;p1++){
            if(map.containsKey(c[p1])){
                map.put(c[p1],map.get(c[p1])-1);
                findNum++;
                break;
            }
        }
        if(findNum==0) return "";
        if(t.length()==1) return t;
        int p2 = p1+1;
        int minlen = s.length();
        String ans = "";
        for(;p2<c.length;p2++){
            if(map.containsKey(c[p2])){
                if(map.get(c[p2])>0){
                    map.put(c[p2],map.get(c[p2])-1);
                    findNum++;
                    if(findNum==t.length()){
                        minlen = p2-p1+1;
                        ans = s.substring(p1,p2+1);
                    }
                }else{
                    if(c[p2]==c[p1]){
                        for(p1=p1+1;p1<=p2;p1++){
                            if(map.containsKey(c[p1])){
                                if(map.get(c[p1])<0){
                                    map.put(c[p1],map.get(c[p1])+1);
                                }else{
                                    break;
                                }
                            }
                        }
                        if(findNum==t.length()){
                            if(minlen>p2-p1+1){
                                minlen = p2-p1+1;
                                ans = s.substring(p1,p2+1);
                            }
                        }
                    }else{
                        map.put(c[p2],map.get(c[p2])-1);
                    }
                }
            }
        }
        return ans;
    }
}