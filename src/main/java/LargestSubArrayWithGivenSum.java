import java.util.*;

public class LargestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] array = { 10, 5, 2, 8, 3, 9, 15, 1, 14 };
        int sum = 15;
        int result = getLargestSubArrayWithGivenSum(array, sum);

        if(result == -1) {
            System.out.println("Did not find any sub array with given sum " + sum);
        } else {
            System.out.println("Largest sub array size with given sum " + sum + " is " + result);
        }
    }

    private static int getLargestSubArrayWithGivenSum(int[] array, int givenSum) {
        int max = -1;
        Map<Integer, Integer> sumIndexMap = new HashMap<>();

        int currentSum = 0;
        for(int i = 0; i < array.length; i++) {
            currentSum += array[i];
            if(currentSum == givenSum) {
                if(i > max) {
                    max = i;
                }
            }

            int diffSum = currentSum - givenSum;

            if(sumIndexMap.containsKey(diffSum)) {
                int size = i - sumIndexMap.get(diffSum);
                if(size > max) {
                    max = size;
                }
            }
            sumIndexMap.put(currentSum, i);
        }
        return max;
    }
}
