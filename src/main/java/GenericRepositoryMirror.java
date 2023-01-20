
public class GenericRepositoryMirror<T> {
  private Object[] elements = new Object[100];
  private int emptyIndex = 0;

  public void add(T element) {
    if (emptyIndex >= elements.length) {
      return;
    }
    elements[emptyIndex++] = element;
  }

  public T get(int index) {
    if (isIndexValid(index)) {
      return null;
    }
    return (T) elements[index];
  }

  private boolean isIndexValid(int index) {
    return index < 0 || index >= elements.length;
  }

  public int find(T element) {
    for (int i = 0; i < elements.length; i++) {
      if (elements[i].equals(element)) {
        return i;
      }
    }
    return -1;
  }

  public void remove(int index) {
    if (isIndexValid(index)) {
      return;
    }
    elements[index] = null;
    shiftArray();
  }

  private void shiftArray() {
    Object[] objects = new Object[100];
    int objectsIndex = 0;
    for (int i = 0; i < elements.length; i++) {
      if (elements[i] != null) {
        objects[objectsIndex++] = elements[i];
      }
    }
    this.elements = objects;
  }

  public void remove(T element) {
    int i = find(element);
    if (i == -1) {
      return;
    }
    remove(i);
  }

  public void update(int index, T element) {
    if (isIndexValid(index)) {
      return;
    }
    elements[index] = element;
  }

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


}

