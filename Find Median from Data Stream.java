class MedianFinder {
    PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(minheap.size()==0||num>minheap.peek()){
            minheap.offer(num);
            if(minheap.size()>maxheap.size()+1){
                maxheap.offer(minheap.poll());
            }
        }else{
            maxheap.offer(num);
            if(maxheap.size()>minheap.size()){
                minheap.offer(maxheap.poll());
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(maxheap.size()==minheap.size()){
            return ((double)maxheap.peek()+(double)minheap.peek())/2;
        }else{
            return minheap.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();