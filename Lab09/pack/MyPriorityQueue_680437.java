package pack;

public class MyPriorityQueue_680437 implements MyQueueIntf {
    MyMinHeap_680437 heap = new MyMinHeap_680437();
    
    @Override
    public void enqueue(int d) {
        if(!heap.isFull()){
            heap.insert(d);
        }
        else{
            System.out.println("Queue is Full, discarding "+d);
        }
    }

    @Override
    public int dequeue() {
        return heap.remove();
    }

    @Override
    public int front() {
        return heap.peek();
    }

    @Override
    public boolean isFull() {
        return heap.isFull();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }    

    @Override
    public String toString() {
        return heap.toString();
    }
}
