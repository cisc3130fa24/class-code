package C_generics.A_generic_classes.A_without_generics;

public class StringPair {
  private String first, second;

  public StringPair(String first, String second) {
    this.first = first;
    this.second = second;
  }

  public String getFirst() {
    return first;
  }

  public String getSecond() {
    return second;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public void setSecond(String second) {
    this.second = second;
  }

  @Override
  public String toString() {
    return "(" + first + ", " + second + ")";
  }

  public static void main(String[] args) {
    StringPair pair = new StringPair("hello", "world"); // works
    System.out.println(pair); // (hello, world)
    pair.setFirst("hola");
    System.out.println(pair.getFirst()); // hola
  }
}
