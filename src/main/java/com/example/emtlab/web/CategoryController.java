package com.example.emtlab.web;

import com.example.emtlab.model.Author;
import com.example.emtlab.model.enumerations.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = {"https://emt-lab-frontend-production.up.railway.app/"})
@RequestMapping("/api/books/categories")
public class CategoryController {

    @GetMapping
    public List<Category> listAll() {
        return Arrays.stream(Category.values()).toList();
    }

}
