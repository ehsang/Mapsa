public interface GenericRepo<T> {
  void add(T t);
  void add(T[] t);
  void update(int index, T t);
  void remove (T t);
  void removeAll(T element);
  void clear();
  void print();


}
