package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Book;
import service.BookService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/list")
    public String list(Model model) {
        List<Book> list = bookService.findBookList();
        model.addAttribute("list", list);
        return "book";
    }

    @RequestMapping("/add")
    public String toAddPage() {
        return "addBook";
    }

    @RequestMapping("/insert")
    public String addPaper(Book book) {
        bookService.addBook(book);
        return "redirect:/book/list";
    }

    @RequestMapping("/edit")
    public String toUpdateBook(Model model, int id) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book",book);
        return "updateBook";
    }

    @RequestMapping("/update")
    public String updateBook(Book book) {
        bookService.updateBook(book);
        return "redirect:/book/list";
    }

    @RequestMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/list";
    }
}
