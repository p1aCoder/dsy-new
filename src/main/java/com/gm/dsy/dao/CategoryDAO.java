package com.gm.dsy.dao;

import com.gm.dsy.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer> {
    Category findByName(String name);
}
