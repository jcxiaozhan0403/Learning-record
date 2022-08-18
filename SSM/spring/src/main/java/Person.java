import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author John.Cena
 * @date 2022/8/18 10:15
 * @Description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    @Autowired
    private Cat cat;
    private String name;
    private int age;
}
