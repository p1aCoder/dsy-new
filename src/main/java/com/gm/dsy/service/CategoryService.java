package com.gm.dsy.service;

import com.gm.dsy.dao.CategoryDAO;
import com.gm.dsy.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> listAll(){
        Sort sort=Sort.by(Sort.Direction.DESC,"id");
        return categoryDAO.findAll(sort);
    }

    public Category get(int id){
        return categoryDAO.findById(id).orElse(null);
    }

}
