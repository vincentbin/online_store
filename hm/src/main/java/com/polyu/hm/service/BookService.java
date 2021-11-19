package com.polyu.hm.service;

import com.polyu.hm.dao.BookRepository;
import com.polyu.hm.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    /**
     * 获取全部图书
     * @return
     */
    public List<Book> getAllBook() {
        return bookRepository.getAllBooks();
    }

    /**
     * 根据id获取图书
     * @param id
     * @return
     */
    public Book getBookById(Integer id) {
        return bookRepository.getBookById(id);
    }
}
