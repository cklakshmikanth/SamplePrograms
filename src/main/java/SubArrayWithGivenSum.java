import java.util.*;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] array = { 10, 5, 2, 8, 3, 9, 15, 1, 4 };
        int sum = 13;
        int[] result = getSubArrayIndicesForGivenSumUsingPrefixSum(array, sum);

        System.out.println("Indices are (" + result[0] + ", " + result[1] + ")");
    }

    private static int[] getSubArrayIndicesForGivenSumUsingPrefixSum(int[] array, int givenSum) {
        int[] result = {-1, -1};
        Map<Integer, Integer> sumIndexMap = new HashMap<>();

        int currentSum = 0;
        for(int i = 0; i < array.length; i++) {
            currentSum += array[i];
            if(currentSum == givenSum) {
                return new int[]{0, i};
            }

            int diffSum = currentSum - givenSum;

            if(sumIndexMap.containsKey(diffSum)) {
                return new int[]{ sumIndexMap.get(diffSum) + 1, i };
            }
            sumIndexMap.put(currentSum, i);
        }
        return result;
    }

    private static int[] getSubArrayIndicesForGivenSumUsingSlidingWindow(int[] array, int sum) {
        int[] result = {-1, -1};

        int leftPointer = 0;
        int rightPointer = 0;
        int currentSum = array[0];

        while(leftPointer < array.length - 1 && rightPointer < array.length - 1) {
            if(currentSum == sum) {
                return new int[] { leftPointer, rightPointer};
            } else if(currentSum < sum) {
                currentSum += array[++rightPointer];
            } else {
                currentSum -= array[leftPointer++];
            }
        }

        return result;
    }
}
