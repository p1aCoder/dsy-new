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

    @GetMapping("/api/book")
    public List<Book> list(){
        return bookService.listAll();
    }

    @PostMapping("/api/book")
    public Book addOrUpdate(@RequestBody Book book){
        bookService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book){
        bookService.deleteById(book.getId());
    }

    @GetMapping("/api/book/{cid}")
    public List<Book> listByCategory(@PathVariable("cid") int cid){
        return cid==0?list():bookService.listByCategory(cid);
    }

}
