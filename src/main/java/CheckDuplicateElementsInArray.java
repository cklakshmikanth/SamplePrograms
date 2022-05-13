import java.util.HashSet;
import java.util.Set;

/*Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.

        Example 1:

        Input: nums = [1,2,3,1]
        Output: true
        Example 2:

        Input: nums = [1,2,3,4]
        Output: false
        Example 3:

        Input: nums = [1,1,1,3,3,4,3,2,4,2]
        Output: true*/


public class CheckDuplicateElementsInArray {

    public static void main(String[] args) {
        int array[] = new int[] { 1, 2, 3, 4};
        System.out.println(containsDuplicate(array));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> distinctElements = new HashSet<>();
        for (int a : nums) {
            if(distinctElements.contains(a)) {
                return true;
            } else {
                distinctElements.add(a);
            }
        }
        return false;
    }
}
