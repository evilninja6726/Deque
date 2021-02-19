package dequeDs;

import java.util.Deque;
import java.util.LinkedList;

public class DsUsingMinMax {
    public static void main(String[] args) {
        MinMax minMax = new MinMax();
        minMax.insertMax(15);
        minMax.insertMax(40);
        minMax.insertMin(30);
        minMax.insertMin(10);
        System.out.println(minMax.extractMax() + " " + minMax.extractMin());
    }
}

class MinMax {
    private Deque<Integer> deque;

    MinMax() {
        deque = new LinkedList<>();
    }

    void insertMin(int data) {
        if (deque.peekFirst() == null)
            deque.offerFirst(data);
        if (data < deque.peekFirst())
            deque.offerFirst(data);
    }

    void insertMax(int data) {
        if (deque.peekLast() == null)
            deque.offerLast(data);
        if (data > deque.peekLast())
            deque.offerLast(data);
    }

    int getMin() {
        if (deque.size() == 0)
            return -1;
        return deque.peekFirst();
    }

    int getMax() {
        if (deque.size() == 0)
            return -1;
        return deque.peekLast();
    }

    int extractMin() {
        if (deque.size() == 0)
            return -1;
        return deque.pollFirst();
    }

    int extractMax() {
        if (deque.size() == 0)
            return -1;
        return deque.pollLast();
    }
}