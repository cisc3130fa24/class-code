package O_lambdas;

//class AdditionOperator implements IntBinaryOperator {
//    @Override
//    public int apply(int a, int b) {
//        return a + b;
//    }
//}

/*
Syntax of lambda expressions:

A lambda expression must implement the abstract method of a functional interface.

A lambda expression can be assigned to a variable, or can be passed to a method.

Basic:
(type0 param0, type1 param1, etc.) -> {
    method body
}

The parameter types must correspond to the parameter types in the functional interface.

Simplifications:
- parameter types can almost always be omitted
- if exactly one parameter, then parentheses can be omitted
- if the method body consists of a single return statement,
  then the word "return", and the curly braces, can be omitted.
- if the method body consists of a single statement, such as a
  print statement, the curly braces can be omitted.

The body of an ideal lambda expression consists of just a single statement.

Method reference: a shorthand way of writing a lambda expression
that simply calls another method with its parameters.
Examples:
    (x, y) -> Math.max(x, y) simplifies to: Math::max
General syntax: method location, two colons, method name.
 */

public class LambdaDemo {
    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 1};
        IntBinaryOperator addition = (x, y) -> x + y;
        int sum = reduce(arr, 0, addition);
        System.out.println("sum = " + sum);

        int product = reduce(arr, 1, (x, y) -> x * y);
        System.out.println("product = " + product);

        // int max = reduce(arr, Integer.MIN_VALUE, (x, y) -> Math.max(x, y));
        int max = reduce(arr, Integer.MIN_VALUE, Math::max);
        System.out.println("max = " + max);

        StringConsumer twicePrinter = s -> System.out.println(s + s);
        twicePrinter.accept("hello");

        StringConsumer printer = System.out::println;
        printer.accept("hello again");
    }

    // identity for addition:
    // Number x such that x + a = a. So x = 0
    // identity for max:
    // number x such that Math.max(x, a) = a. So x = Integer.MIN_VALUE

    // result:
    // element:
    public static int reduce(int[] arr, int identity, IntBinaryOperator operator) {
        int result = identity;

        for (int element : arr) {
            result = operator.apply(result, element);
        }

        return result;
    }
}