package com.polyu.hm.controller;

import com.polyu.hm.model.Book;
import com.polyu.hm.result.Result;
import com.polyu.hm.service.BookService;
import com.polyu.hm.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/book")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/all_books.json")
    public Result<List<BookVo>> getBooks() {
        List<Book> allBook = bookService.getAllBook();
        List<BookVo> books = new ArrayList<>(allBook.size());
        for (Book book : allBook) {
            Integer id = book.getId();
            String bookName = book.getBookName();
            String author = book.getAuthor();
            String publisher = book.getPublisher();
            String description = book.getDescription();
            Double price = book.getPrice();
            Double priceOff = book.getPriceOff();
            String img = book.getImg();
            BookVo bookVo = new BookVo();
            bookVo.setId(id);
            bookVo.setBookName(bookName);
            bookVo.setAuthor(author);
            bookVo.setPublisher(publisher);
            bookVo.setDescription(description);
            bookVo.setPrice(price);
            bookVo.setPriceOff(priceOff);
            bookVo.setImg(img);
            books.add(bookVo);
        }
        return Result.success(books);
    }

    @RequestMapping(value = "/single_book.json")
    public Result<BookVo> getBookById(BookVo bParam) {
        Book book = bookService.getBookById(bParam.getId());
        BookVo bookVo = new BookVo();
        bookVo.setId(book.getId());
        bookVo.setBookName(book.getBookName());
        bookVo.setAuthor(book.getAuthor());
        bookVo.setPublisher(book.getPublisher());
        bookVo.setDescription(book.getDescription());
        bookVo.setPrice(book.getPrice());
        bookVo.setPriceOff(book.getPriceOff());
        bookVo.setImg(book.getImg());
        return Result.success(bookVo);
    }
}
