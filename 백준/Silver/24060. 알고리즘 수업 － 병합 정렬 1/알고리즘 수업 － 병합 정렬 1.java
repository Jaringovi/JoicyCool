import java.util.Scanner;

public class Main {
    static int[] array;
    static int[] tempArray;
    static int arraySize, mergeCount = 0, targetMergeCount = 0, resultValue = -1;

    public static void merge(int[] array, int left, int middle, int right) {
        int leftIndex = left, rightIndex = middle + 1, tempIndex = 1;

        while (leftIndex <= middle && rightIndex <= right) {
            if (array[leftIndex] <= array[rightIndex])
                tempArray[tempIndex++] = array[leftIndex++];
            else
                tempArray[tempIndex++] = array[rightIndex++];
        }
        while (leftIndex <= middle)
            tempArray[tempIndex++] = array[leftIndex++];

        while (rightIndex <= right)
            tempArray[tempIndex++] = array[rightIndex++];

        leftIndex = left;
        tempIndex = 1;
        while (leftIndex <= right) {
            array[leftIndex++] = tempArray[tempIndex++];
            mergeCount++;
            if (mergeCount == targetMergeCount) {
                resultValue = array[leftIndex - 1];
                break;
            }
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        arraySize = sc.nextInt();
        targetMergeCount = sc.nextInt();
        array = new int[arraySize];
        tempArray = new int[arraySize + 1];

        for (int i = 0; i < arraySize; i++) {
            array[i] = sc.nextInt();
        }

        mergeSort(array, 0, arraySize - 1);
        System.out.println(resultValue);

        sc.close();
    }
}
