package dequeDs;

import java.util.Arrays;

public class DequeUsingArray {
    public static void main(String[] args) {
        ArrayDeque arrayDeque=new ArrayDeque(3);
        System.out.println(arrayDeque.deleteFront());
        arrayDeque.getFront();
        arrayDeque.insertFront(10);
//        arrayDeque.insertFront(20);
//        arrayDeque.insertFront(30);
        arrayDeque.insertFront(40);
        arrayDeque.insertRear(30);
      //  System.out.println(arrayDeque.deleteFront());
        System.out.println(arrayDeque.deleteRear());
        System.out.println(arrayDeque.getRear()+" "+arrayDeque.getFront());
    }
}

class ArrayDeque{
    private int capacity, size;
    int[] arr;
    ArrayDeque(int capacity){
        this.capacity=capacity;
        arr=new int[capacity];
        size=0;
    }
    void insertFront(int data){
        if (size==capacity){
            System.out.println("Can't Add");
            return;
        }else {
            for (int i=size-1;i>=0;i--)
                arr[i+1]=arr[i];
            arr[0]=data;
            size++;
        }
    }
    int getFront(){
        if (size==0){
            System.out.println("Empty Queue");
            return -1;
        }
        return arr[0];
    }
     void insertRear(int data){
        if (size==capacity){
            System.out.println("Can't Add");
            return;
        }
        arr[size]=data;
        size++;
     }
     int getRear(){
        if (size==0){
            System.out.println("Empty Queue");
            return -1;
        }
        return arr[size-1];
     }

     int deleteFront(){
        if (size==0){
            System.out.println("Empty Queue");
            return -1;
        }else {
            int x=arr[0];
            for (int i=0;i<size-1;i++){
                arr[i]=arr[i+1];
            }
            size--;
            return x;
        }
     }
     int deleteRear(){
        if (size==0){
            System.out.println("Empty Queue");
            return -1;
        }
        int x=arr[size-1];
        size--;
        return x;
     }

     boolean isFull(){
        return size==capacity;
     }

     boolean isEmpty(){
        return size==0;
     }

     int size(){
        return size;
     }
}

