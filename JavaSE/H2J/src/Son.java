import java.util.ArrayList;

/**
 * @author John.Cena
 * @date 2022/6/22 15:24
 * @Description:
 */
public class Son{
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Son son = (Son) o;

        if (age != son.age) return false;
        return name != null ? name.equals(son.name) : son.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}