public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length==0) return -1;
        if(gas.length==1){
            if(gas[0]<cost[0]) return -1;
            else return 0;
        }
        for(int i=0;i<gas.length;){
            int gasremaining = 0;
            int next = 0;
            for(int j=i;(j+(gas.length-i))%gas.length<gas.length-1;j=(j+1)%gas.length){
                gasremaining = gasremaining + gas[j] - cost[j];
                if(gasremaining<0) {
                    next = (j+1)%gas.length;
                    //System.out.println(next);
                    if(next<i) {
                        //System.out.println(next);
                        return -1;}
                    break;}
            }
            if(gasremaining>=0&&gasremaining+gas[(i+gas.length-1)%gas.length]-cost[(i+gas.length-1)%gas.length]>=0) return i;
            else if(next>i) i=next;
            else return -1;
        }
        return -1;
    }
}