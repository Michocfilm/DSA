package pack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyQueueL_680449<T> implements Iterable<T> {
    private List<T> items = new LinkedList<>(); // remove(0) is O(1)

    public void enqueue(T d) {
        items.add(d);
    }

    public T dequeue() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return items.remove(0);
    }

    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return items.get(0);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("top->");
        for (T item : items)
            sb.append(item).append("-> ");
        sb.append("bottom");
        return sb.toString();
    }

    @Override
    // so that one can use for-each on MyQueueL
    public Iterator<T> iterator() {
        return items.iterator();
    }       
}