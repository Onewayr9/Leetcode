public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> posts = new ArrayList<List<Integer>>();
        for(int i=0;i<numCourses;i++){
            posts.add(new ArrayList<Integer>());
        }
        int[] preNums = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
            preNums[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(preNums[i]==0)
                queue.offer(i);
        }
        int[] ans = new int[numCourses];
        int num = 0;
        int count = numCourses;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            ans[num++] = cur;
            for(int i:posts.get(cur)){
                if(--preNums[i]==0){
                    queue.offer(i);
                }
            }
            count--;
        }
        if(count==0) return ans;
        else return (new int[0]);
    }
}