public class Solution {
    public String simplifyPath(String path) {
        path.replaceAll("/+","/");
        Stack<String> store = new Stack<String>();
        String temp = "/";
        if(path.length()==0) return "";
        if(path.length()==1) return path;
        for(int i=1;i<path.length();i++){
            if(path.charAt(i)=='/'){
                if(temp.length()==1){
                }else if(temp.equals("/..")){
                    if(!store.empty())
                        store.pop();
                }
                else if(temp.equals("/.")){
                }else{
                    store.push(temp);
                }
                temp = "/";
            }else{
                temp += path.charAt(i);
            }
        }
        if(temp.equals("/..")){
            if(!store.empty())
            store.pop();
        }else if(temp.equals("/.")){ }
        else if(!temp.equals("/")) store.push(temp);
        String ans = "";
        while(!store.empty()){
            ans = store.pop() + ans;
        }
        if(ans.length()==0) return "/";
        return ans;
    }
}