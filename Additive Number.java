public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num.length()<3){
            return false;
        }
        for(int i=0;i<num.length()-2;i++){
            String First = num.substring(0,i+1);
            boolean isfirstZero = First.equals("0")?true:false;
            for(int j=i+1;j<num.length()-1;j++){
                String first = First;
                String second = num.substring(i+1,j+1);
                String remain = num.substring(j+1);
                boolean issecondZero = second.equals("0")?true:false;
                while(!remain.equals("")){
                    String sum = add(first,second);
                    if(remain.startsWith(sum)){
                        remain = remain.substring(sum.length());
                        first = second;
                        second = sum;
                    }else{
                        break;
                    }
                }
                if(remain.equals("")){
                    return true;
                }
                if(issecondZero){
                    break;
                }
            }
            if(isfirstZero){
                break;
            }
        }
        return false;
    }
    public String add(String s1,String s2){
        if(s1.equals("0")||s2.equals("0")){
            return s1.equals("0")?s2:s1;
        }
        String ans = "";
        String first = s1;
        String second = s2;
        int carry = 0;
        while(first.length()!=0||second.length()!=0){
            int a1 = first.length()==0?0:first.charAt(first.length()-1)-'0';
            int a2 = second.length()==0?0:second.charAt(second.length()-1)-'0';
            ans = (a1+a2+carry)%10 + ans;
            carry = (a1+a2+carry)/10;
            first = first.length()<=1?"":first.substring(0,first.length()-1);
            second = second.length()<=1?"":second.substring(0,second.length()-1);
        }
        return carry==1?'1'+ans:ans;
    }
}