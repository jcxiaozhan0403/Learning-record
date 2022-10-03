import com.jc.entity.Book;
import com.jc.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author John.Cena
 * @date 2022/10/3 13:42
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")	//注解寻找配置文件
public class MyTest {

    @Autowired
    private BookService bookService;


    @Test
    public void list() {
        List<Book> list = bookService.findBookList();
        System.out.println(list);
    }
}
