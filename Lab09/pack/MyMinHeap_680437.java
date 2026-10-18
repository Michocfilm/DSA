package pack;

public class MyMinHeap_680437 {
    int MAX_SIZE = 100;
    int heap[] = new int[MAX_SIZE];
    int size = 0;
    
    private void swap(int i, int j) {
        heap[i] = heap[i] + heap[j];
        heap[j] = heap[i] - heap[j];
        heap[i] = heap[i] - heap[j];
    }
    public int peek() {
        return heap[0];
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int d) {
        /* your code */
        heap[size] = d;
        int i = size;
        size++;
        while(i>0){
            int parent = (i-1)/2;
            if (heap[i]<heap[parent]) {
                swap(i, parent);
                i = parent;
            }
            else{
                break;
            }
        }
    }

    public int remove() {
        int d = heap[0];
        heap[0] = heap[--size];
        heap[size] = d;
        int p = 0;
        while (true) {
            /* your code */
            int left = (2*p) + 1;
            if (left>=size)break;
            int right = (2*p) + 2;
            if(right == size){
                if(heap[p]>heap[left]){
                    swap(p,left);
                }
                break;
            }
            else{
                int q = heap[left]<heap[right]?left:right;
                if(heap[p]>heap[q])swap(p,q);
                else break;
                p=q;
            }
            System.out.println("heap snapshot (cur_size = " + size + ") " + this.toString());
        } 
        return d;
    } //end while

    public String toString() {
        int i;
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (i = 0; i < size; i++) {
            sb.append(heap[i]);
            sb.append(",");
        }
        if (size > 0) {
            sb.append("]");
        }
        return sb.toString();
    }
    
}
