public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0) return 0;
        Arrays.sort(citations);
        int hindex = citations.length;
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=hindex) return hindex;
            else hindex--;
        }
        return hindex;
    }
}