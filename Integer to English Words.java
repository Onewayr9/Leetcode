public class Solution {
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        else{
            String[] carry = {" Thousand"," Million"," Billion"};
            String ans = "";
            int i = -1;
            while(num!=0){
                if(i==-1){
                    ans += underThousandToWords(num%1000);
                }else{
                    if(num%1000!=0&&!ans.equals("")) ans = underThousandToWords(num%1000) + carry[i] + " " + ans;
                    else if(num%1000!=0) ans = underThousandToWords(num%1000) + carry[i];
                }
                i++;
                num/=1000;
            }
            return ans;
        }
    }
    public String underThousandToWords(int num){
        String words = "";
        if(num==0) return words;
        String[] underTwenty = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen","Twenty"};
        String[] aboveTwenty = {"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        if(num/100>0){
            words += underTwenty[num/100-1] + " Hundred";
            if(num%100!=0) words += " ";
        }
        num%=100;
        if(num<=20&&num!=0){
            words += underTwenty[num-1];
        }else if(num>20){
            words += aboveTwenty[num/10-2];
            if(num%10>0) words += " "+underTwenty[num%10-1];
        }
        return words;
    }
}