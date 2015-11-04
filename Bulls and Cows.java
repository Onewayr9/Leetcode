public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
            }
            if(!map.containsKey(secret.charAt(i))){
                map.put(secret.charAt(i),1);
            }else{
                map.put(secret.charAt(i),map.get(secret.charAt(i))+1);
            }
        }
        for(int i=0;i<guess.length();i++){
            if(map.containsKey(guess.charAt(i))){
                if(map.get(guess.charAt(i))>0){
                    cows++;
                    map.put(guess.charAt(i),map.get(guess.charAt(i))-1);
                }
            }
        }
        return bulls+"A"+(cows-bulls)+"B";
    }
}