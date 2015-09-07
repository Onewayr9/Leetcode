public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0) return 0;
        int hIndex = 0;
        int len = citations.length;
        int left = 0, right = len-1;
        int middle = (left+right)/2;
        while(left<=right){
            if(citations[middle]>=len-middle&&(middle==0||citations[middle-1]<=len-middle)) return len-middle;
            else if(citations[middle]>=len-middle&&citations[middle-1]>len-middle) right = middle-1;
            else if(citations[middle]<len-middle) left = middle+1;
            middle = (left+right)/2;
        }
        return hIndex;
    }
}