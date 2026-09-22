class MedianFinder {
    PriorityQueue<Integer> minheap = new PriorityQueue<>();
    PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {}
    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll());
        if(minheap.size()>maxheap.size()) maxheap.offer(minheap.poll());
    }
    
    public double findMedian() { 
        if(maxheap.size()>minheap.size()) return maxheap.peek();
        return (maxheap.peek()+minheap.peek())/2.0d;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
