package icamp.aArraysAndStrings.ic04ArrayPartitioning.redWhiteBlue;

// You're given a list of Marbles. Each marble can have one of 3 colors (Red, White or Blue).
// Arrange the marbles in order of the colors (Red -> White -> Blue).
// Colors are represented as follows:
// 0 - Red
// 1 - White
// 2 - Blue

import java.util.Arrays;

public class Solution {
  enum Marble {
    RED(0),
    WHITE(1),
    BLUE(2);

    private final int intVal;

    Marble(int intVal) {
      this.intVal = intVal;
    }

    public int getIntVal() {
      return intVal;
    }
  }

  public static void main(String[] args) {
    arrangeMarbles(new int[] {1, 2, 2, 2, 0, 0, 1});
    arrangeMarbles(new int[] {2, 1});
    arrangeMarbles(new int[] {0, 0, 1, 1, 2, 2});
    arrangeMarbles(new int[] {1, 2, 2, 3, 0, 0, 1});
  }

  private static void arrangeMarbles(int[] marbles) {
    System.out.println("--------");
    System.out.println(Arrays.toString(marbles));
    int head = 0;
    int tail = marbles.length - 1;

    try {
      for (int i = 0; i < marbles.length; ) {
        int currEl = marbles[i];
        if (currEl == Marble.BLUE.getIntVal()) {
          if (i >= tail) {
            i++;
          } else {
            swap(marbles, i, tail--);
          }
        } else if (currEl == Marble.RED.getIntVal()) {
          if (i <= head) {
            i++;
          } else {
            swap(marbles, i, head++);
          }
        } else if (currEl == Marble.WHITE.getIntVal()) {
          i++;
        } else {
          throw new IllegalArgumentException();
        }
      }
    } catch (IllegalArgumentException e) {
      System.out.println("Error! One of your marbles was not a color!");
      return;
    }

    System.out.println(Arrays.toString(marbles));
  }

  private static void swap(int[] marbles, int i, int j) {
    int temp = marbles[i];
    marbles[i] = marbles[j];
    marbles[j] = temp;
  }
}
