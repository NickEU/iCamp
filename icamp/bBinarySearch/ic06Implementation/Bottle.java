package icamp.bBinarySearch.ic06Implementation;

import java.util.Objects;

public class Bottle implements Comparable<Bottle> {
  private int currentVolume;
  private final int maxVolume;


  public Bottle(int maxVolume) {
    this.currentVolume = 0;
    this.maxVolume = maxVolume;
  }

  private void setCurrentVolume(int currentVolume) {
    this.currentVolume = currentVolume;
  }

  public int getCurrentVolume() {
    return currentVolume;
  }

  public int getMaxVolume() {
    return maxVolume;
  }

  public void addOneUnit() {
    this.setCurrentVolume(this.getCurrentVolume() + 1);
  }

  @Override
  public int compareTo(Bottle o) {
    return this.getCurrentVolume() - o.getCurrentVolume();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Bottle bottle = (Bottle) o;
    return getCurrentVolume() == bottle.getCurrentVolume();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCurrentVolume(), getMaxVolume());
  }

  @Override
  public String toString() {
    return "Bottle{" +
            "currentVolume=" + currentVolume +
            ", maxVolume=" + maxVolume +
            '}';
  }
}
