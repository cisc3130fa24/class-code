package C_generics.A_generic_classes.D_variations;// If we want a class that will only allow us
// to create pairs of Numbers, or Integers, or Rationals, etc.,
// but not other types of pair, like pairs of Strings
// this is one way to do it.
// Note that this class 
// - is a generic class
// - does not inherit from the Pair class.

import C_generics.A_generic_classes.C_current_style.PositiveInteger;

// "T extends Number" means that
// T must either be Number or a subclass of Number
public class NumberPair1<T extends Number> {
  private T first, second;

  public NumberPair1(T first, T second) {
    this.first = first;
    this.second = second;
  }

  // we are taking advantage of the fact that T is either Number
  // or a subclass of Number
  public double sum() {
    return first.doubleValue() + second.doubleValue();
  }

  public static void main(String[] args) {
    NumberPair1<Number> pair1 = new NumberPair1<>(44, new PositiveInteger(1));
    NumberPair1<Integer> pair2 = new NumberPair1<>(45, 33);
    NumberPair1<PositiveInteger> pair3 = new NumberPair1<>(new PositiveInteger(2),
                                                    new PositiveInteger(3));
    System.out.println(pair3.sum());

    // this is not allowed:
    // NumberPair1<String> stringPair = new NumberPair1<>("hello", "world");
  }
}
