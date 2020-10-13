package com.gm.dsy.dao;

import com.gm.dsy.pojo.Book;
import com.gm.dsy.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDAO extends JpaRepository<Book,Integer> {
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1,String keyword2);
}
