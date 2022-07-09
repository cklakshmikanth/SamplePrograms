/*Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
 
Example 1:

Input:
N = 4
arr[] = {1, 5, 3, 2}
Output: 2
Explanation: There are 2 triplets: 
1 + 2 = 3 and 3 + 2 = 5 

Example 2:

Input: 
N = 3
arr[] = {2, 3, 4}
Output: 0
Explanation: No such triplet exits

*/
import java.util.*;
public class CountTheTriplets {
    public static void main(String args[]) {
      int[] array = { 5, 2, 1, 4, 3 };
      int result = getTripletsCount(array);

      System.out.println("No. of triplets matching the given condition is " + result);
    }
    
    public static int getTripletsCount(int[] a) {
        int count = 0;
        Arrays.sort(a);
        
        int n = a.length;
        
        for(int i = 0; i <= n-3; i++) {
            int l = i + 1;
            int r = l + 1;
            while(l < n && r < n) {
                if(a[i] + a[l] == a[r]) {
                    count++;
                    l++;
                    r++;
                } else if(a[i] + a[l] > a[r]) {
                    r++;
                } else {
                    l++;
                }
            }
        }
        
        return count;
    }
}
