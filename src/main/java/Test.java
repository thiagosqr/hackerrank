import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

public class Test {

  private int age;
  private String name;

  public Test(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public static void main(final String[] args) {

    Set<Test> set = new HashSet<>();
    set.add(new Test(18,"John"));
    set.add(new Test(17,"Mary"));
    set.add(new Test(18,"Adam"));

    System.out.println(set.size());

  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Test test = (Test) o;
    return age == test.age && Objects.equals(name, test.name);
  }

  @Override public int hashCode() {
    return Objects.hash(age, name);
  }
}
