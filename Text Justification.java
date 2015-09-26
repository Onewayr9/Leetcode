public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<String>();
        if(words.length==0) return ans;
        int point_1 = 0,point_2 = 0;
        int tempLength = words[0].length();
        for(;point_2<words.length-1;point_2++){
            if(tempLength+words[point_2+1].length()+1>maxWidth){
                String insert = generate(words,point_1,point_2,tempLength,maxWidth);
                ans.add(insert);
                point_1 = point_2+1;
                tempLength = words[point_1].length();
            }else{
                tempLength+=words[point_2+1].length()+1;
            }
        }
        String lastLine = "";
        for(int i=point_1;i<words.length-1;i++){
            lastLine+=words[i]+" ";
        }
        lastLine+=words[words.length-1];
        lastLine+=genSpace(maxWidth-lastLine.length());
        ans.add(lastLine);
        return ans;
    }
    public String generate(String[] words,int begin,int end,int tempLength,int maxWidth){
        if(begin==end){
            return words[begin]+genSpace(maxWidth-tempLength);
        }
        String ans = "";
        int gap = end - begin;
        int aveSpace = (maxWidth - tempLength)/gap + 1;
        int remainer = (maxWidth - tempLength)%gap;
        for(int i=begin;i<end;i++){
            ans+=words[i]+genSpace(aveSpace);
            if(remainer>0){
                ans+=" ";
                remainer--;
            }
        }
        ans+=words[end];
        return ans;
    }
    public String genSpace(int n){
        String ans = "";
        for(int i=1;i<=n;i++){
            ans+=" ";
        }
        return ans;
    }
}