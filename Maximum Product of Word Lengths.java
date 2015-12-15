public class Solution {
    public int maxProduct(String[] words) {
        if(words.length==0) return 0;
        int[] wordBits = new int[words.length];
        for(int i=0;i<words.length;i++){
            char[] carray = words[i].toCharArray();
            for(char c:carray){
                wordBits[i] |= 1<<(c-'a');
            }
        }
        int maxProduct = 0;
        for(int i=0;i<wordBits.length;i++){
            for(int j=i+1;j<wordBits.length;j++){
                if((wordBits[i]&wordBits[j])==0){
                    maxProduct = Math.max(maxProduct,words[i].length()*words[j].length());
                }
            }
        }
        return maxProduct;
    }
}