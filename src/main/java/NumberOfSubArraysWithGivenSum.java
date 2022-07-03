import java.util.*;

public class NumberOfSubArraysWithGivenSum {
    public static void main(String[] args) {
        int[] array = { 10, 5, 2, 8, 3, 9, 15, 1, 14 };
        int sum = 15;
        int result = getNumberOfSubArraysWithGivenSum(array, sum);

        System.out.println("No of sub arrays with given sum " + sum + " is " + result);
    }

    private static int getNumberOfSubArraysWithGivenSum(int[] array, int givenSum) {
        int result = 0;
        Map<Integer, Integer> sumIndexMap = new HashMap<>();

        int currentSum = 0;
        for(int i = 0; i < array.length; i++) {
            currentSum += array[i];
            if(currentSum == givenSum) {
                result++;
            }

            int diffSum = currentSum - givenSum;

            if(sumIndexMap.containsKey(diffSum)) {
                result++;
            }
            sumIndexMap.put(currentSum, i);
        }
        return result;
    }
}
