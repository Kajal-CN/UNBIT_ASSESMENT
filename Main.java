import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] inputArr = {1, 3, 2, 2, -4, -6, -2, 8};
        int targetValue = 4;

        // Find combinations for target value
        List<int[]> combinations = findCombinations(inputArr, targetValue);
        System.out.println("First Combination For " + targetValue + " : ");
        printCombinations(combinations);

        // Merge into a single array
        int[] mergedArray = mergeAndSort(inputArr);
        System.out.println("Merge Into a single Array: " + Arrays.toString(mergedArray));

        // Find combinations for doubled target value
        int doubleTarget = targetValue * 2;
        List<int[]> combinationsDoubleTarget = findCombinationsDoubleTarget(mergedArray, doubleTarget);
        System.out.println("Second Combination For " + doubleTarget + " : ");
        printCombinations(combinationsDoubleTarget);
    }

    public static List<int[]> findCombinations(int[] arr, int target) {
        List<int[]> combinations = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    combinations.add(new int[]{arr[i], arr[j]});
                }
            }
        }
        return combinations;
    }

    public static int[] mergeAndSort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static List<int[]> findCombinationsDoubleTarget(int[] arr, int target) {
        List<int[]> combinations = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (sumOfRange(arr, i, j) == target) {
                    combinations.add(Arrays.copyOfRange(arr, i, j + 1));
                }
            }
        }
        return combinations;
    }

    public static int sumOfRange(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void printCombinations(List<int[]> combinations) {
        for (int[] combination : combinations) {
            System.out.println(Arrays.toString(combination));
        }
    }
}
