public class Solution {
    public String multiply(String num1, String num2) {
        String ans = "0";
        String zero = "";
        if(num1.equals("0")||num2.equals("0")) return "0";
        for(int i=num2.length()-1;i>=0;i--){
            int num = num2.charAt(i)-'0';
            String temp = "";
            int add = 0;
            if(num==0){
                zero += "0";
                continue;}
            for(int j=num1.length()-1;j>=0;j--){
                temp = (add+(num1.charAt(j)-'0')*num)%10+temp;
                add = (add+(num1.charAt(j)-'0')*num)/10;
            }
            if(add!=0) temp = add+temp;
            temp += zero;
            ans = add(ans,temp);
            zero += "0";
        }
        return ans;
    }
    public String add(String num1,String num2){
        String ans = "";
        int add = 0;
        for(int i=num1.length()-1,j=num2.length()-1;i>=0||j>=0;i--,j--){
            int a = 0,b = 0;
            if(i>=0) a = num1.charAt(i)-'0';
            if(j>=0) b = num2.charAt(j)-'0';
            ans = (add+a+b)%10 + ans;
            add = (add+a+b)/10;
        }
        if(add==1) ans = "1"+ans;
        return ans;
    }
}