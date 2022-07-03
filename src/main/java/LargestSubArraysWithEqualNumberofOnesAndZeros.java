import java.util.*;

public class LargestSubArraysWithEqualNumberofOnesAndZeros {
    public static void main(String[] args) {
        int[] array = { 1, 1, 0, 1, 1, 0, 0 };
        int result = getLargestSubArraysWithEqualNumberofOnesAndZeros(array);

        if(result == -1) {
            System.out.println("Did not find any sub array with equal number of 1's and 0's");
        } else {
            System.out.println("Size of largest sub array with equal number of 1's and 0's is " + result);
        }
    }

    private static int getLargestSubArraysWithEqualNumberofOnesAndZeros(int[] array) {
        int max = -1;
        Map<Integer, Integer> sumIndexMap = new HashMap<>();

        int currentSum = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                array[i] = -1;
            }
            
            currentSum += array[i];

            if(currentSum == 0) {
                max = Math.max(max, i + 1);
            } else {
                if(sumIndexMap.containsKey(currentSum)) {
                    max = Math.max(max, i - sumIndexMap.get(currentSum));
                } else {
                    sumIndexMap.put(currentSum, i);
                }
            }
        }
        return max;
    }
}
