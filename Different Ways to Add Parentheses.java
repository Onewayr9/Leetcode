public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        if(input==null||input.length()==0){
            return result;
        }
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(c!='+'&&c!='-'&&c!='*'){
                continue;
            }
            List<Integer> leftResult = diffWaysToCompute(input.substring(0,i));
            List<Integer> rightResult = diffWaysToCompute(input.substring(i+1,input.length()));
            
            for(Integer m:leftResult)
                for(Integer n:rightResult){
                    if(c=='+') result.add(m+n);
                    if(c=='-') result.add(m-n);
                    if(c=='*') result.add(m*n);
                }
        }
        if(result.size()==0) result.add(Integer.parseInt(input));
        return result;
    }
}