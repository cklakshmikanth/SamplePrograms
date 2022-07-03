import java.util.*;

public class LargestSubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] array = { 15, -2, 2, -8, 1, 7, 10, 23 };
        int result = getLargestSubArraysWithZeroSum(array);

        if(result == -1) {
            System.out.println("Did not find any sub array with sum equal to zero");
        } else {
            System.out.println("Size of largest sub array with zero sum is " + result);
        }
    }

    private static int getLargestSubArraysWithZeroSum(int[] array) {
        int max = -1;
        Map<Integer, Integer> sumIndexMap = new HashMap<>();

        int currentSum = 0;
        for(int i = 0; i < array.length; i++) {
            currentSum += array[i];
            if(currentSum == 0) {
                max = Math.max(max, i + 1);
            }
            else if(sumIndexMap.containsKey(currentSum)) {
                max = Math.max(max, i - sumIndexMap.get(currentSum));
            } else {
                sumIndexMap.put(currentSum, i);
            }
        }
        return max;
    }
}
