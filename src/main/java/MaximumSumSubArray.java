/*Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.

Example 1:

Input:
N = 5
Arr[] = {1,2,3,-2,5}
Output:
9
Explanation: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.

Example 2:

Input:
N = 4
Arr[] = {-1,-2,-3,-4}
Output:
-1
Explanation: Max subarray sum is -1 of element (-1)
*/

import java.util.*;
public class MaximumSumSubArray {
    public static void main(String args[]) {
      int[] array = { -47, 43, 94, -94, -93, -59, 31, -86 };
      int result = getMaximunSumOfSubarray(array, array.length);

      System.out.println("Maximum value of a sub array is " + result);
    }
    
    public static int getMaximunSumOfSubarray(int[] arr, int n) {
        int maxSum = arr[0];
        int currentSum = 0;
        
        for(int i = 0; i < n; i++) {
            currentSum += arr[i];
            maxSum = Math.max(currentSum, maxSum);
            if(currentSum < 0) {
                currentSum = 0;
            }
        }
        
        return maxSum;
    }
}
