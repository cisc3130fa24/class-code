package H_array_list;

// a very abbreviated version of java.util.List
public interface List<E> {
    int size();
    boolean add(E e);
    void add(int index, E element);
    E get(int index);
}
