import junit.framework.TestCase;
import org.junit.Test;

import java.util.Random;

/**
 * @author John.Cena
 * @date 2022/9/29 11:36
 * @Description:
 */
// 15题测试程序
public class Demo15Test extends TestCase {

    @Test
    public void testTotlePrint() {
        Random random = new Random();
        int max = 100,min = -100;

        int i = random.nextInt(max)%(max-min+1) + min;
        System.out.println(i);
    }
}