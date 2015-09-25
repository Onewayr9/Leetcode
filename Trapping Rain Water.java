public class Solution {
    public int trap(int[] height) {
        // skip zeros  
        int cur = 0;  
        while (cur < height.length && height[cur] == 0) ++cur;  
   
        // check each one  
        int vol = 0;  
        Stack<Integer> stack = new Stack<Integer>();  
        while (cur < height.length) {  
            while (!stack.isEmpty() && height[cur] >= height[stack.peek()]) {  
                int b = stack.pop();  
                if (stack.isEmpty()) break;  
                vol += ((cur - stack.peek() - 1) * (Math.min(height[cur], height[stack.peek()]) - height[b]));  
            }  
            stack.push(cur);  
            ++cur;  
        }  
   
        return vol; 
    }
}