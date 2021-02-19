package dequeDs;

import java.util.Deque;
import java.util.LinkedList;

public class MaxInSubArrayOfSizeK {
    public static void main(String[] args) {
        maxInSubArrayOfSizeK(new int[]{10, 8, 5, 12, 15, 7, 6}, 3);
        maxInSubArrayOfSizeKEff(new int[]{10, 8, 5, 12, 15, 7, 6}, 3);
    }

    public static void maxInSubArrayOfSizeK(int[] arr, int k) {
        for (int i = 0; i < arr.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < k + i; j++) {
                max = Math.max(max, arr[j]);
            }
            System.out.println(max);
        }
    }

    public static void maxInSubArrayOfSizeKEff(int[] arr, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekFirst()])
                deque.pollLast();
            deque.offerLast(i);
        }
        for (int i = k; i < arr.length; i++) {
            System.out.println(arr[deque.peekFirst()]);
            while (!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.pollFirst();
            while (!deque.isEmpty() && arr[deque.peekFirst()] <= arr[i])
                deque.pollLast();
            deque.offerLast(i);
        }
        System.out.println(arr[deque.peekFirst()]);
    }
}
