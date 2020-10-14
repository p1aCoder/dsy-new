package com.gm.dsy.controller;

import com.gm.dsy.pojo.Book;
import com.gm.dsy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @CrossOrigin
    @GetMapping("/api/book")
    public List<Book> list() throws Exception{
        return bookService.listAll();
    }

    @CrossOrigin
    @PostMapping("/api/book")
    public Book addOrUpdate(@RequestBody Book book) throws Exception{
        bookService.addOrUpdate(book);
        return book;
    }

    @CrossOrigin
    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception{
        bookService.deleteById(book.getId());
    }

    @CrossOrigin
    @GetMapping("/api/book/{cid}")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception{
        return cid==0?list():bookService.listByCategory(cid);
    }

    @CrossOrigin
    @GetMapping("/api/search")
    public List<Book> listByCategory(@RequestParam("keywords") String keywords) throws Exception{
        return keywords.equals("")?bookService.listAll():bookService.searchBook(keywords);
    }

}
