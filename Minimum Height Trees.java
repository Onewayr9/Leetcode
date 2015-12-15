public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> topo = new ArrayList<>();
        int[] neighbor = new int[n];
        for(int i=0;i<n;i++){
            set.add(i);
            topo.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            topo.get(edge[0]).add(edge[1]);
            topo.get(edge[1]).add(edge[0]);
            neighbor[edge[0]]++;
            neighbor[edge[1]]++;
        }
        while(set.size()>2){
            Queue<Integer> queue = new LinkedList<>();
            for(int i=0;i<n;i++){
                if(neighbor[i]==1){
                    queue.offer(i);
                }
            }
            while(!queue.isEmpty()){
                int node = queue.poll();
                neighbor[node]--;
                set.remove(node);
                for(int nod:topo.get(node)){
                    if(set.contains(nod)){
                        neighbor[nod]--;
                    }
                }
            }
        }
        return new ArrayList<Integer>(set);
    }
}