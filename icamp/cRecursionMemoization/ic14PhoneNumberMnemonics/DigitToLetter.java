package icamp.cRecursionMemoization.ic14PhoneNumberMnemonics;

import java.util.Map;
import static java.util.Map.entry;

public class DigitToLetter {
  private final Map<Integer, String> digitsToLetters = Map.ofEntries(
          entry(2, "ABC"),
          entry(3, "DEF"),
          entry(4, "GHI"),
          entry(5, "JKL"),
          entry(6, "MNO"),
          entry(7, "PQRS"),
          entry(8, "TUV"),
          entry(9, "WXYZ")
  );

  private final int digit;
  private int lettersStillNotShown;

  public DigitToLetter(int digit) {
    this.digit = digit;
    this.lettersStillNotShown = digitsToLetters.get(digit).length();
  }

  public boolean nextExists() {
    return lettersStillNotShown > 0;
  }

  public char getNextLetter() {
    String letters = digitsToLetters.get(digit);
    return letters.charAt(letters.length() - lettersStillNotShown--);
  }

}
