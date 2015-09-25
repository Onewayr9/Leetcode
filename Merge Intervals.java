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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<Interval>();
        if(intervals.size()<=1) return intervals;
        List<Interval> sortinterval = mergesort(intervals,0,intervals.size()-1);
        for(int i=0;i<sortinterval.size()-1;i++){
            if(sortinterval.get(i).end<sortinterval.get(i+1).start){
                ans.add(sortinterval.get(i));
            }else{
                sortinterval.get(i+1).start = sortinterval.get(i).start;
                sortinterval.get(i+1).end = Math.max(sortinterval.get(i).end,sortinterval.get(i+1).end);
            }
        }
        ans.add(sortinterval.get(sortinterval.size()-1));
        return ans;
    }
    public List<Interval> mergesort(List<Interval> intervals,int left,int right){
        if(left==right){
            List<Interval> ans = new ArrayList<Interval>();
            ans.add(intervals.get(left));
            return ans;
        }else{
            int middle = (left+right)/2;
            List<Interval> leftinterval = mergesort(intervals,left,middle);
            List<Interval> rightinterval = mergesort(intervals,middle+1,right);
            return mergeInterval(leftinterval,rightinterval);
        }
    }
    public List<Interval> mergeInterval(List<Interval> leftinterval,List<Interval> rightinterval){
        List<Interval> interval = new ArrayList<Interval>();
        int i=0,j=0;
        while(i<leftinterval.size()&&j<rightinterval.size()){
            if(leftinterval.get(i).start<rightinterval.get(j).start){
                interval.add(leftinterval.get(i));
                i++;
            }else{
                interval.add(rightinterval.get(j));
                j++;
            }
        }
        if(i<leftinterval.size()){
            while(i<leftinterval.size()){
                interval.add(leftinterval.get(i));
                i++;
            }
        }else{
            while(j<rightinterval.size()){
                interval.add(rightinterval.get(j));
                j++;
            }
        }
        return interval;
    }
}