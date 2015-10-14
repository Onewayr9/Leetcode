class Edge {
    int x;
    int height;
    boolean isStart;
    public Edge(int x,int height,boolean isStart){
        this.x = x;
        this.height = height;
        this.isStart = isStart;
    }
}
public class Solution {
    List<int[]> ans = new ArrayList<int[]>();
    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings.length==0||buildings[0].length==0){
            return ans;
        }
        List<Edge> edges = new ArrayList<Edge>();
        for(int[] building:buildings){
            edges.add(new Edge(building[0],building[2],true));
            edges.add(new Edge(building[1],building[2],false));
        }
        // sort edges 
    	Collections.sort(edges, new Comparator<Edge>() {
    		public int compare(Edge a, Edge b) {
    			if (a.x != b.x)
    				return Integer.compare(a.x, b.x);
     
    			if (a.isStart && b.isStart) {
    				return Integer.compare(b.height, a.height);
    			}
     
    			if (!a.isStart && !b.isStart) {
    				return Integer.compare(a.height, b.height);
    			}
     
    			return a.isStart ? -1 : 1;
    		}
    	});
    	PriorityQueue<Integer> heightHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    	for(Edge edge:edges){
    	    if(edge.isStart){
    	        if(heightHeap.isEmpty()||edge.height>heightHeap.peek()){
    	            ans.add(new int[] {edge.x,edge.height});
    	        }
    	        heightHeap.add(edge.height);
    	    }else{
    	        heightHeap.remove(edge.height);
    	        if(heightHeap.isEmpty()){
    	            ans.add(new int[] {edge.x,0});
    	        }else if(edge.height>heightHeap.peek()){
    	            ans.add(new int[] {edge.x,heightHeap.peek()});
    	        }
    	    }
    	}
    	return ans;
    }
}