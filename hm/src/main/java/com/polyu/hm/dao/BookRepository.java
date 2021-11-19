package com.polyu.hm.dao;

import com.polyu.hm.mapper.BookMapper;
import com.polyu.hm.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    BookMapper bookMapper;

    /**
     * 获取所有书本
     * @return
     */
    public List<Book> getAllBooks() {
        return bookMapper.selectList(null);
    }

    /**
     * 根据id获取书本
     * @param id
     * @return
     */
    public Book getBookById(Integer id) {
        return bookMapper.selectById(id);
    }

}
