import java.util.Hashtable;
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator%denominator==0) return (long)numerator/(long)denominator + "";
        else{
            String ans = "";
            if(((long)numerator>0&&(long)denominator<0)||((long)numerator<0&&(long)denominator>0)) ans = "-";
            long numerator2 = Math.abs((long)numerator);
            long denominator2 = Math.abs((long)denominator);
            ans += numerator2/denominator2 + ".";
            numerator2 = 10*(numerator2%denominator2);
            Hashtable<Long,String> decimal = new Hashtable<Long,String>();
            String dec = "";
            decimal.put(numerator2,dec);
            //System.out.println(numerator);
            while(numerator2!=0){
                dec += numerator2/denominator2;
                numerator2 = 10*(numerator2%denominator2);
                if(decimal.containsKey(numerator2)) break;
                else{
                    decimal.put(numerator2,dec);
                }
                //System.out.println(numerator2);
            }
            if(numerator2==0) return ans+dec;
            else{
                String irrepeat = decimal.get(numerator2);
                String repeat = dec.replaceFirst(irrepeat,"");
                ans += irrepeat + "(" + repeat + ")";
            }
            return ans;
        }
    }
}