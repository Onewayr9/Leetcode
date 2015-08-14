public class Solution {
    public String largestNumber(int[] num) {
		int n = num.length;
        if (n < 1) return "";
        
        //transfer array into string array
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(num[i]);
        }
        
        //sort
        Arrays.sort(strs, new Cmp());
        
        //concat
        String ans = "";
        for (int i = n - 1; i >= 0; i--) {
        	ans = ans.concat(strs[i]);
        }
        
        //move zero away
        int i = 0;
        while (i < n && ans.charAt(i) == '0') {
            i++;
        }
        if (i == n) return "0";
        
        return ans.substring(i);
    }
}

//if[a,b]>[b,a],then a>b
class Cmp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String str1 = o1 + o2;
        String str2 = o2 + o1;
        int length = str1.length();
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) > str2.charAt(i)) {
                return 1;
            } else if (str1.charAt(i) < str2.charAt(i)) {
                return -1;
            }
        }
        return 0;
    }
}