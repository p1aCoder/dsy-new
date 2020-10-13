package com.gm.dsy.service;

import com.gm.dsy.dao.BookDAO;
import com.gm.dsy.dao.CategoryDAO;
import com.gm.dsy.pojo.Book;
import com.gm.dsy.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookDAO bookDAO;
    @Autowired
    CategoryService categoryService;

    public List<Book> listAll(){
        Sort sort=Sort.by(Sort.Direction.DESC,"id");
        return bookDAO.findAll(sort);
    }

    public void addOrUpdate(Book book){
        bookDAO.save(book);
    }

    public List<Book> listByCategory(int cid){
        Category category=categoryService.get(cid);
        return bookDAO.findAllByCategory(category);
    }

    public void deleteById(int id){
        bookDAO.deleteById(id);
    }


}
