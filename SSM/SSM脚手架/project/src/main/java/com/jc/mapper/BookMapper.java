package com.jc.mapper;

import com.jc.entity.Book;

import java.util.List;

/**
 * @author John.Cena
 * @date 2022/10/3 13:36
 * @Description:
 */
public interface BookMapper {
    //增加一个Book
    int addBook(Book book);

    //根据id删除一个Book
    int deleteBookById(int id);

    //更新Book
    int updateBook(Book book);

    //根据id查询,返回一个Book
    Book findBookById(int id);

    //查询全部Book,返回list集合
    List<Book> findBookList();
}
