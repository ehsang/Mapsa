import java.util.Arrays;
import java.util.List;

public class GenericRepository<T> implements GenericRepo<T> {

  @Override
  public String toString() {
    return "GenericRepository{" +
      "elements=" + Arrays.toString(elements) +
      ", emptyIndex=" + emptyIndex +
      '}';
  }

  private Object[] elements;

  private int emptyIndex = 0;

  public GenericRepository() {
    elements = new Object[]{56,65,6,5,6,6};
  }

  public GenericRepository(int size) {
    this.elements = new Object[size];
  }


  public GenericRepository(T[] objArray) {
    elements = objArray;
  }

  public void add(T[] elements) {

  }

  private void extendArray() {
    Object[] temp = new Object[this.elements.length + 100];
    System.arraycopy(this.elements, 0, temp, this.elements.length - 1, this.elements.length);
    this.elements = temp;
  }

  public void add(T element) {

    if (emptyIndex >= elements.length) {
      extendArray();
    }
    elements[emptyIndex++] = element;

  }

  public T get(int index) {
    if (isIndexInvalid(index)) {
      return null;
    }
    return (T) elements[index];
  }

  private boolean isIndexInvalid(int index) {
    return index < 0 || index >= elements.length;
  }


  private int findFirst(T element) {

    if (element == null) {
      return -1;
    }

    for (int i = 0; i < elements.length; i++) {
      // null checking: the element in array should not be null
      if (elements[i] != null && elements[i].equals(element)) {
        return i;
      }
    }
    // its a convention to return -1 in such methods when the element couldn't be found in the array
    return -1;
  }

  public void remove(int index) {
    if (isIndexInvalid(index)) {
      return;
    }
    elements[index] = null;
    shiftArray();
  }

  private void shiftArray() {
    Object[] objects = new Object[this.elements.length];
    int objectsIndex = 0;
    for (int i = 0; i < elements.length; i++) {
      if (elements[i] != null) {
        objects[objectsIndex++] = elements[i];
      }
    }
    this.elements = objects;
  }

  public void remove(T element) {
    int i = findFirst(element);
    if (i == -1) {
      return;
    }
    remove(i);
  }

  public void removeAll(T element) {
    // remove all the elements in the array based on the type T -> like if there are 5,5,5,5 in the array
    // use findFirst() and remove(T element)
    for (int i = 0; i < elements.length; i++) {
      if (findFirst(element) != -1) {
        remove(element);
      }
    }


  }

  public void clear() {
    for (int i = 0; i < elements.length; i++) {
      elements[i] = null;
    }
  }

  public void update(int index, T element) {
    if (isIndexInvalid(index)) {
      return;
    }
    elements[index] = element;
  }


  //Make the ret type GenericRepository<T> and make the method work
  public T[] subElements(int from, int to) {
    if (from < 0 || from > to || to >= elements.length) {
      return null;
    }
    Object[] subElements = new Object[to - from + 1];
    int index = 0;
    for (int i = from; i <= to; i++) {
      subElements[index++] = elements[i];
    }

    return (T[]) subElements;
  }

  public void printAll() {
    for (int i = 0; i < elements.length; i++) {
      System.out.println(elements[i]);
    }
  }

  public void print() {

  }

}
