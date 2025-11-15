import java.util.Random;

public class LinearSearchTiming {

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};

        System.out.println("Algorithm: Linear Search");
        System.out.println("Input Size | Time (ns)");
        System.out.println("-----------------------");

        for (int size : sizes) {
            int[] arr = generateArray(size);
            int target = arr[size - 1]; // element guaranteed to exist

            long start = System.nanoTime();
            linearSearch(arr, target);
            long end = System.nanoTime();

            System.out.println(size + "         | " + (end - start));
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int[] generateArray(int size) {
        Random rand = new Random(42);
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }
}