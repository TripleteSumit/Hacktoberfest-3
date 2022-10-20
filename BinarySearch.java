import java.util.Arrays;

public class QuickSort {
    public static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static int partition(int arr[], int l, int h) {
        int pivot = arr[h];
        int i = l - 1;
        for (int j = l; j < h; j++) {
            if (arr[j] < pivot) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, i + 1, h);
        return i + 1;
    }

    public static int partition1(int arr[], int l, int h) {
        int pivot = arr[l];
        int i = l, j = h;
        do {
            do {
                i++;
            } while (arr[i] <= pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i < j) {
                swap(arr, i, j);
            }

        } while (i < j);
        swap(arr, j, l);
        return j;
    }

    public static void quickSort(int arr[], int l, int h) {
        if (l < h) {
            int j = partition1(arr, l, h);
            quickSort(arr, l, j);
            quickSort(arr, j + 1, h);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 9, 3, 7, 5, 6, 4, 8, 2, Integer.MAX_VALUE }, l = 0, h = arr.length - 1;
        quickSort(arr, l, h);
        System.out.println(Arrays.toString(arr));
    }

}
