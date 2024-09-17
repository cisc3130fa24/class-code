package D_jcf;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new ArraySet<>(10);
        set.add("a");
        set.add("b");
        set.add("c");

        for (String s : set) {
            System.out.println(s);
        }
    }
}
