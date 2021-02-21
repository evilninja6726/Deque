package dequeDs;

public class FirstCircularTour {
    public static void main(String[] args) {
        System.out.println(firstCircularTour(new int[]{4, 8, 7, 4}, new int[]{6, 5, 3, 5}));
        System.out.println(firstCircularTour(new int[]{4, 8, 7, 4}, new int[]{5, 10, 9, 4}));
        System.out.println(firstCircularTourEff(new int[]{4, 8, 7, 4}, new int[]{6, 5, 3, 5}));
        System.out.println(firstCircularTourEff(new int[]{4, 8, 7, 4}, new int[]{5, 10, 9, 4}));
        System.out.println(firstCircularTourEff(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }

    public static int firstCircularTour(int[] p, int[] d) {
        for (int i = 0; i < p.length; i++) {
            int left = 0;
            int j = i;
            while (true) {
                left += p[j] - d[j];
                if (left < 0)
                    break;
                j = (j + 1) % p.length;
                if (j == i)
                    return i + 1;
            }
        }
        return -1;
    }

    public static int firstCircularTourEff(int[] p, int[] d) {
        int sum = 0, diff = 0;
        int res = 0;
        for (int i = 0; i < p.length; i++) {
            sum = sum + p[i] - d[i];
            if (sum < 0) {
                sum = 0;
                diff = diff + p[i] - d[i];
                res = i + 1;
            }
        }
        return sum + diff >= 0 ? res + 1 : -1;
    }
}
