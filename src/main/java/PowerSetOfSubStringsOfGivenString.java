/*
Given a string, write a recursive code to print all subsets of it. The subsets can be printed in any order. 

Examples:  

Input :  string = "abc"
Output : "", "a", "b", "c", "ab", "ac", "bc", "abc"

Input : string = "abcd"
Output : "" "a" "ab" "abc" "abcd" "abd" "ac" "acd"
         "ad" "b" "bc" "bcd" "bd" "c" "cd" "d"
*/
import java.util.*;
public class PowerSetOfSubStringsOfGivenString {
    public static void main(String args[]) {
      String string = "abc";
      List<String> result = getPowerSetOfSubStringsOfGivenString(string);

      System.out.println("Power set of substrings for the string " + string + " is as follows");
      for(String str : result) {
        System.out.println(str);  
      }
    }
    
    public static List<String> getPowerSetOfSubStringsOfGivenString(String string) {
        List<String> result = new ArrayList<>();
        populateSubStrings(string, 0, "", result);
        return result;
    }
    
    public static void populateSubStrings(String string, int index, String currentString, List<String> result) {
        if(index == string.length()) {
            result.add(currentString);
            return;
        }
        populateSubStrings(string, index + 1, currentString + string.charAt(index), result);
        populateSubStrings(string, index + 1, currentString, result);
    }
}
