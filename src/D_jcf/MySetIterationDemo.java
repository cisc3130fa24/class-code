package D_jcf;

public class MySetIterationDemo {
    public static void main(String[] args) {
        MySet<String> set = new ArrayMySet<>(10);
        set.add("a");
        set.add("b");
        set.add("c");

        for (String s : set) {
            System.out.println(s);
        }
    }
}
