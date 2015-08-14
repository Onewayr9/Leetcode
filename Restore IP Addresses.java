public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        String IP = "";
        backtracking(0,s,IP,ans);
        return ans;
    }
    public boolean backtracking(int layer, String sub, String IP, List<String> tempans){
        if(layer==3){
            if(sub.charAt(0)=='0'){
                if(sub.length()==1){
                    tempans.add(IP+sub);
                    return true;
                }else return false;}
            else{
                int num = Integer.parseInt(sub);
                if(num<=255){
                    tempans.add(IP+sub);
                    return true;
                }
                else return false;
            }
        }else{
            if(sub.length()==0)
                return false;
            else if(sub.length()<4-layer||sub.length()>3*(4-layer))
                return false;
            else{
                if(sub.length()>1){
                    backtracking(layer+1,sub.substring(1),IP+sub.substring(0,1)+".",tempans);
                }
                if(sub.length()>2&&sub.charAt(0)!='0'){
                    backtracking(layer+1,sub.substring(2),IP+sub.substring(0,2)+".",tempans);
                }
                if(sub.length()>3&&sub.charAt(0)!='0'&&Integer.parseInt(sub.substring(0,3))<=255){
                    backtracking(layer+1,sub.substring(3),IP+sub.substring(0,3)+".",tempans);
                }
            }
        }
        return true;
    }
}