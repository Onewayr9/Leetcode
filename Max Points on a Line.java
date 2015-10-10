/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points.length<=1){
            return points.length;
        }
        HashMap<Double,Integer> map = new HashMap<Double,Integer>();
        int max = 0;
        for(int i=0;i<points.length;i++){
            int duplicate = 1;
            int vertical = 0;
            for(int j=i+1;j<points.length;j++){
                if(points[j].x==points[i].x){
                    if(points[j].y==points[i].y){
                        duplicate++;
                    }else{
                        vertical++;
                    }
                }else{
                    double slope = points[j].y == points[i].y ? 0.0 : (1.0 * (points[j].y - points[i].y)) / (points[j].x - points[i].x);
                    if(!map.containsKey(slope)){
                        map.put(slope,1);
                    }else{
                        map.put(slope,map.get(slope)+1);
                    }
                }
            }
            for(Integer e:map.values()){
                max = Math.max(max,e+duplicate);
            }
            max = Math.max(max,duplicate+vertical);
            map.clear();
        }
        return max;
    }
}