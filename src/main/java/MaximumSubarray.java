public class MaximumSubarray {

    /*Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
    A subarray is a contiguous part of an array.

    Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.

    Example 2:
    Input: nums = [1]
    Output: 1

    Example 3:
    Input: nums = [5,4,-1,7,8]
    Output: 23*/

    public static void main(String[] args) {
        int[] array = new int[]{5,4,-1,7,8};
        System.out.println(maxSubArray(array));
    }


    /*Not performant
    public static int maxSubArray(int[] nums) {
        int globalMaxValue = nums[0];
        for(int i = 0 ; i < nums.length; i++) {
            int ithMaxValue = nums[i];
            int maxValue = nums[i];
            for(int j = i + 1; j< nums.length; j++) {
                if(maxValue + nums[j] > ithMaxValue) {
                    ithMaxValue = maxValue + nums[j];
                }
                maxValue = maxValue + nums[j];
            }
            if(ithMaxValue > globalMaxValue) {
                globalMaxValue = ithMaxValue;
            }
        }
        return globalMaxValue;
    }*/

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int j = 0; j < nums.length; j++) {
            if (sum < 0) {
                sum = nums[j];
            } else {
                sum = sum + nums[j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
