package com.cheng.service.Impl;

import com.cheng.dao.BookMapper;
import com.cheng.pojo.Books;
import com.cheng.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl  implements BookService {
    @Autowired
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {

        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {

        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {

        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {

        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public Books queryBookByName(String bookName) {

        return bookMapper.queryBookByName(bookName);
    }
}
