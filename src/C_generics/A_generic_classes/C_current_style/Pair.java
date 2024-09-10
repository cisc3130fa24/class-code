package C_generics.A_generic_classes.C_current_style;

public class Pair<T> { // Pair is generic class. T is a type parameter
  private T first, second;

  public Pair(T first, T second) {
    this.first = first;
    this.second = second;
  }

  public void setFirst(T first) {
    this.first = first;
  }

  public void setSecond(T second) {
    this.second = second;
  }

  public T getFirst() {
    return first;
  }

  public T getSecond() {
    return second;
  }

  @Override
  public String toString() {
    return "(" + first + ", " + second + ")";
  }

  // Suppose p1 is a Pair<String>, and p2 is another pair.
  // If we say p1.equals(p2), we hope that p2 is also a Pair<String>
  // But the equals method has no way to guarantee this. 
  @Override
  public boolean equals(Object o) {
    if (o instanceof Pair) {
      Pair<?> other = (Pair<?>) o;
      return this.first.equals(other.first) 
        && this.second.equals(other.second);
    } else {
      return false;
    }
  }

  public static <U> Pair<U> of(U first, U second) {
    return new Pair<>(first, second);
  }
  
  /** Copies the values from the other pair into this pair. */
  public void copyFrom(Pair<? extends T> source) {
    this.first = source.first;
    this.second = source.second;
  }

  /** Copies the values from this pair into the other pair. */
  public void copyTo(Pair<? super T> destination) {
    destination.first = this.first;
    destination.second = this.second;
  }

  // When to use extends, and when to use super? 
  // Mnemonic: PECS: producer - extends, consumer - super.

  public static void main(String[] args) {
    
    // we can make a Pair of any reference type. but not primitive type
    
    // for this Pair, the compiler knows that T means Integer
    // Integer is the type argument here
    Pair<Integer> integerPair = new Pair<Integer>(89, -90);
    System.out.println(integerPair); // (89, -90)
    int first = integerPair.getFirst();
    integerPair.setFirst(34);

    // won't compile -- 
    // we cannot use a primitve type inside the angle brackets
    // Pair<int> intPair = new Pair<>(56, 78);

    // for this Pair, the compiler knows that T means Rational
    Pair<PositiveInteger> positiveIntegerPair = new Pair<>(
            new PositiveInteger(5), new PositiveInteger(9));
    System.out.println(positiveIntegerPair);

    // no cast needed, since the compiler knows that 
    // getFirst must return a Rational here
    PositiveInteger firstPositiveInteger = positiveIntegerPair.getFirst();

    // for this Pair, the compiler knows that T means String
    Pair<String> stringPair = new Pair<>("hello", "world");
    System.out.println(stringPair);

    // this will not compile, which is good
    // stringPair.setFirst(34);

    // no cast needed, since the compiler knows that 
    // getFirst must return a String here
    String firstString = stringPair.getFirst();

    // a Pair<Number> can contain objects of all classes that inherit from Number
    Pair<Number> numberPair = new Pair<>(34.7845, new PositiveInteger(23));
    System.out.println(numberPair);


    // it is possible to say this, but it's usually not a good idea
    // Pair pair = new Pair(4, 34);

    Pair<String> anotherStringPair = Pair.of("hello", "world");
    System.out.println(anotherStringPair);
    
    numberPair.copyFrom(positiveIntegerPair); // here, T = Number
    System.out.println(numberPair);

    integerPair.copyTo(numberPair); // here, T = Integer
    System.out.println(numberPair);
  }
}
