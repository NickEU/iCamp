package icamp.aArraysAndStrings.ic03ArrayTraversal.twoSum;

import java.util.Objects;

public class Pair {
  private final int first;
  private final int second;

  public Pair(int first, int second) {
    this.first = first;
    this.second = second;
  }

  public int getFirst() {
    return first;
  }

  public int getSecond() {
    return second;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pair pair = (Pair) o;
    return getFirst() == pair.getFirst() &&
            getSecond() == pair.getSecond();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirst(), getSecond());
  }
}
