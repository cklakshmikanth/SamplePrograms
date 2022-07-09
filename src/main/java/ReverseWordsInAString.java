/*Given a String S, reverse the string without reversing its individual words. Words are separated by dots.

Example 1:

Input:
S = i.like.this.program.very.much
Output: much.very.program.this.like.i
Explanation: After reversing the whole string(not individual words), the input string becomes much.very.program.this.like.i

Example 2:

Input:
S = pqr.mno
Output: mno.pqr
Explanation: After reversing the whole string , the input string becomes mno.pqr
*/
import java.util.*;
public class ReverseWordsInAString {
    public static void main(String args[]) {
      String string = "i.like.this.program.very.much";
      String reversedString = reversedString(string);

      System.out.println("Reversed string is " + reversedString);
    }
    
    public static String reversedString(String string) {
        String[] subStrings = string.split("\\.");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = subStrings.length - 1; i > 0; i--) {
            stringBuilder.append(subStrings[i]);
            stringBuilder.append(".");
        }
        stringBuilder.append(subStrings[0]);
        return stringBuilder.toString();
    }
}
