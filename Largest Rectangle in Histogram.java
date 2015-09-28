public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height.length==0){
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<height.length;i++){
            if(stack.empty()||height[i]>=height[stack.peek()]){
                stack.push(i);
            }else{
                while(!stack.empty()&&height[i]<height[stack.peek()]){
                    int index = stack.pop();
                    int high = stack.empty()?i:i-stack.peek()-1;
                    max = Math.max(max,high*height[index]);
                }
                stack.push(i);
            }
        }
        while(!stack.empty()){
            int index = stack.pop();
            int high = stack.empty()?height.length:height.length-stack.peek()-1;
            max = Math.max(max,high*height[index]);
        }
        return max;
    }
}