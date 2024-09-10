package C_generics.A_generic_classes.D_variations;

import C_generics.A_generic_classes.C_current_style.Pair;
import C_generics.A_generic_classes.C_current_style.PositiveInteger;

// If we want a class that will only allow us to create
// pairs of Numbers, or Integers, or Rationals, etc.,
// this is another way to do it.
// Note that this class is not a generic class -- it just 
// inherits from a generic class.
public class NumberPair2 extends Pair<Number> {
  public NumberPair2(Number first, Number second) {
    super(first, second);
  }

  public double sum() {
    return getFirst().doubleValue() + getSecond().doubleValue();
  }

  public static void main(String[] args) {
    NumberPair2 pair1 = new NumberPair2(44, new PositiveInteger(1));
    NumberPair2 pair2 = new NumberPair2(45, 33);
    NumberPair2 pair3 = new NumberPair2(new PositiveInteger(2),
                                        new PositiveInteger(3));
    System.out.println(pair3.sum());

    // cannot do this:
    // NumberPair2 stringPair = new NumberPair2("hello", "world");
  }
}