import java.util.Random;

public class BubbleSortTiming {

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};

        System.out.println("Algorithm: Bubble Sort");
        System.out.println("Input Size | Time (ns)");
        System.out.println("-----------------------");

        for (int size : sizes) {
            int[] arr = generateArray(size);

            long start = System.nanoTime();
            bubbleSort(arr);
            long end = System.nanoTime();

            System.out.println(size + "         | " + (end - start));
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
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