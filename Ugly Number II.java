public class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        else{
            Queue<Integer> s1 = new PriorityQueue<Integer>();
            Queue<Integer> s2 = new PriorityQueue<Integer>();
            Queue<Integer> s3 = new PriorityQueue<Integer>();
            s1.offer(1);
            s2.offer(1);
            s3.offer(1);
            int temp = 1;
            for(int i=1;i<n;i++){
                int l1 = 2*s1.peek();
                int l2 = 3*s2.peek();
                int l3 = 5*s3.peek();
                if(l1<l2&&l1<l3){
                    temp = l1;
                    s1.poll();
                }else if(l2<l1&&l2<l3){
                    temp = l2;
                    s2.poll();
                }else if(l3<l1&&l3<l2){
                    temp = l3;
                    s3.poll();
                }else if(l1==l2&&l1<l3){
                    temp = l1;
                    s1.poll();
                    s2.poll();
                }else if(l1==l3&&l1<l2){
                    temp = l1;
                    s1.poll();
                    s3.poll();
                }else if(l2==l3&&l2<l1){
                    temp = l2;
                    s2.poll();
                    s3.poll();
                }else if(l1==l2&&l1==l3){
                    temp = l1;
                    s1.poll();
                    s2.poll();
                    s3.poll();
                }
                s1.offer(temp);
                s2.offer(temp);
                s3.offer(temp);
            }
            return temp;
        }
    }
}