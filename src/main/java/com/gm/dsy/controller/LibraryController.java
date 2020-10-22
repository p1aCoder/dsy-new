package com.gm.dsy.controller;

import com.gm.dsy.pojo.Book;
import com.gm.dsy.service.BookService;
import com.gm.dsy.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @PostMapping("/api/covers")
    public String coversUpload(MultipartFile file) throws Exception{
        String folder="E:\\IdeaProjects\\vueproject\\dsy-new\\src\\main\\resources\\assets";
        File f = new File(folder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.exists()){
            f.getParentFile().mkdirs();
        }
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        }catch (IOException e){
            e.printStackTrace();
            return "";
        }
    }

}
