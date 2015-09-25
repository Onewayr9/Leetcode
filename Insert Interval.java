/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size()==0){
            intervals.add(newInterval);
            return intervals;
        }
        int left = findLeft(intervals, newInterval.start);
        int right = findRight(intervals, newInterval.end);
        if(left==intervals.size()-1){
            intervals.add(newInterval);
            return intervals;
        }
        if(right==0){
            intervals.add(0,newInterval);
            return intervals;
        }
        List<Interval> ans = new ArrayList<Interval>();
        int i=0;
        boolean isInsert = false;
        while(i<intervals.size()){
            if(i-1==left&&!isInsert){
                Interval insertInterval = new Interval(Math.min(intervals.get(i).start,newInterval.start),Math.max(intervals.get(right-1).end,newInterval.end));
                ans.add(insertInterval);
                i=right;
                isInsert = true;
            }else{
                ans.add(intervals.get(i++));
            }
        }
        return ans;
    }
    public int findLeft(List<Interval> intervals, int num){
        int left = 0;
        int right = intervals.size()-1;
        if(num<=intervals.get(0).end) return -1;
        while(left<=right){
            int middle = (left+right)/2;
            if(num<=intervals.get(middle).end){
                right = middle-1;
            }else if(middle<intervals.size()-1&&num>intervals.get(middle+1).end){
                left = middle+1;
            }else{
                return middle;
            }
        }
        return -1;
    }
    public int findRight(List<Interval> intervals, int num){
        int left = 0;
        int right = intervals.size()-1;
        if(num>=intervals.get(right).start) return right+1;
        while(left<=right){
            int middle = (left+right)/2;
            if(num>=intervals.get(middle).start){
                left = middle+1;
            }else if(middle>0&&num<intervals.get(middle-1).start){
                right = middle-1;
            }else{
                return middle;
            }
        }
        return 0;
    }
}