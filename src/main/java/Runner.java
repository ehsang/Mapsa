import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner<T> {
  public static void main(String[] args) {
    GenericRepository<String> genericRepository = new GenericRepository<>(10);
    GenericRepository<Integer> genericRepositoryArray = new GenericRepository<>();
    // genericRepositoryArray.removeAll(65);
    genericRepositoryArray.remove(Integer.valueOf(65));
    // genericRepositoryArray.update(5,666);
    System.out.println(genericRepositoryArray);

  }
}
