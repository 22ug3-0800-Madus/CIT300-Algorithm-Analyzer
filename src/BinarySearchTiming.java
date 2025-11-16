import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class BinarySearchTiming {

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};

        System.out.println("Algorithm: Binary Search");
        System.out.println("Input Size | Time (ns)");
        System.out.println("-----------------------");

        for (int size : sizes) {
            int[] arr = generateArray(size);
            Arrays.sort(arr);
            int target = arr[size - 1]; // search last element

            long start = System.nanoTime();
            binarySearch(arr, target);
            long end = System.nanoTime();

            System.out.println(size + "         | " + (end - start));
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static int[] generateArray(int size) {
        Random rand = new Random(42);
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }
}
