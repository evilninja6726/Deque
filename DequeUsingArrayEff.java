package dequeDs;

import java.util.Arrays;

public class DequeUsingArrayEff {
    public static void main(String[] args) {
        ArrayDequeEff arrayDequeEff = new ArrayDequeEff(3);
        System.out.println(arrayDequeEff.deleteFront());
        arrayDequeEff.insertFront(10);
        arrayDequeEff.insertRear(30);
        arrayDequeEff.insertRear(40);
        arrayDequeEff.insertRear(50);
        arrayDequeEff.deleteFront();
        arrayDequeEff.deleteRear();
        arrayDequeEff.insertFront(20);
        arrayDequeEff.insertFront(30);
        System.out.println(arrayDequeEff.getFront() + " " + arrayDequeEff.getRear());
        System.out.println(Arrays.toString(arrayDequeEff.arr));
        arrayDequeEff.insertFront(50);
        System.out.println(arrayDequeEff.getFront() + " " + arrayDequeEff.getRear());
    }
}

class ArrayDequeEff {
    private int capacity, front, rear, size;
    int[] arr;

    ArrayDequeEff(int capacity) {
        this.capacity = capacity;
        front = -1;
        rear = -1;
        size = 0;
        arr = new int[capacity];
    }

    void insertFront(int data) {
        if (front == -1) {
            arr[++front] = data;
            size++;
            rear++;
        } else if (front == 0) {
            if (rear != capacity - 1) {
                arr[rear + 1] = data;
                size++;
            } else {
                arr[capacity - 1] = data;
                size++;
                front = capacity - 1;
                if (rear == front)
                    rear--;
            }
        } else {
            arr[--front] = data;
            size++;
            if (front == rear && rear == 0)
                rear = size - 1;
            else if (front == rear)
                rear--;
        }
    }

    void insertRear(int data) {
        if (rear == -1) {
            arr[++rear] = data;
            size++;
            front++;
        } else {
            arr[(rear + 1) % capacity] = data;
            size++;
            rear = (rear + 1) % capacity;
            if (rear == front)
                front = (front + 1) % capacity;
        }
    }

    int deleteFront() {
        if (front == -1) {
            return -1;
        } else {
            int x = arr[front];
            front = (front + 1) % capacity;
            size--;
            return x;
        }
    }

    int deleteRear() {
        if (rear == -1) {
            return -1;
        } else if (rear == 0) {
            int x = arr[rear];
            rear = size - 1;
            size--;
            return x;
        } else {
            int x = arr[--rear];
            size--;
            return x;
        }
    }

    int getFront() {
        if (front == -1)
            return -1;
        return arr[front];
    }

    int getRear() {
        if (rear == -1)
            return -1;
        return arr[rear];
    }

    int size() {
        return size;
    }
}