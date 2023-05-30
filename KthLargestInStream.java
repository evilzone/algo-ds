/**

Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

**/

class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();

        for(int num : nums) {
            pq.add(num);

            if(pq.size() > k) {
                pq.remove();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);

        if(pq.size() > k) {
            pq.remove();
        }
        return pq.peek();
    }
}
