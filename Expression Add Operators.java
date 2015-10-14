public class Solution {
    List<String> ans = new ArrayList<String>();
    public List<String> addOperators(String num, int target) {
        for(int i=1;i<=num.length();i++){
            if(i>=2&&num.charAt(0)=='0'){
                break;
            }
            addOperators(num.substring(0,i),num.substring(i),target,0,Long.parseLong(num.substring(0,i)),true);
        }
        return ans;
    }
    public void addOperators(String temp,String num,int target,long pre,long cur,boolean sign){
        long sum = sign?pre+cur:pre-cur;
        if(num.length()==0){
            if(sum==(long)target){
                ans.add(temp);
            }
            return;
        }
        for(int i=1;i<=num.length();i++){
            if(i>=2&&num.charAt(0)=='0'){
                break;
            }
            int number = Integer.parseInt(num.substring(0,i));
            addOperators(temp+"+"+number,num.substring(i),target,sum,number,true);
            addOperators(temp+"-"+number,num.substring(i),target,sum,number,false);
            addOperators(temp+"*"+number,num.substring(i),target,pre,number*cur,sign);
        }
    }
}