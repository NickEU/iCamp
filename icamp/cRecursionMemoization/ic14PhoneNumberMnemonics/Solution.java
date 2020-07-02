package icamp.cRecursionMemoization.ic14PhoneNumberMnemonics;

// Phone Number Mnemonics: Given an N digit phone number, print all the strings that can
// be made from that phone number. Since 1 and 0 don't correspond to any characters, ignore
// them.
//
// For example:
// 213 => AD, AE, AF, BD, BE, BF, CE, CE, CF
// 456 => GJM, GJN, GJO, GKM, GKN, GKO,.. etc.

import java.util.Arrays;

public class Solution {
  private final String userInput;
  private int[] usefulDigits;
  private int comboLen;

  public Solution(String phoneNumber) {
    userInput = phoneNumber;
    parseUserInput();
  }

  private void parseUserInput() {
    if (userInput.isEmpty()) {
      usefulDigits = null;
      comboLen = 0;
      return;
    }
    usefulDigits = Arrays.stream(
            userInput.replaceAll("[^2-9]", "")
                    .split(""))
            .mapToInt(Integer::parseInt).toArray();
    comboLen = usefulDigits.length;
  }

  public static void main(String[] args) {
    Solution o = new Solution("213");
    o.printHelper();
    o = new Solution("456");
    o.printHelper();
    o = new Solution("");
    o.printHelper();
  }

  private void printHelper() {
    System.out.println("Your input was : " + userInput);
    if (comboLen == 0) {
      System.out.println("Error! Unable to parse your string into valid numbers");
      return;
    }
    System.out.println("Useful digits: " + Arrays.toString(usefulDigits));
    printAllStrings(0, new char[comboLen]);
  }

  private void printAllStrings(int pos, char[] buffer) {
    if (pos == comboLen) {
      System.out.println(Arrays.toString(buffer));
      return;
    }

    DigitToLetter letters = new DigitToLetter(usefulDigits[pos]);
    while (letters.nextExists()) {
      buffer[pos] = letters.getNextLetter();
      printAllStrings(pos + 1, buffer);
    }
  }


}
