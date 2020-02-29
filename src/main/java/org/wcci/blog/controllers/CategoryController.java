package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.models.Category;
import org.wcci.blog.storage.CategoryStorage;

@Controller
public class CategoryController {
    private CategoryStorage categoryStorage;

    public CategoryController(CategoryStorage categoryStorage){
        this.categoryStorage = categoryStorage;
    }



    @RequestMapping("/categories")
    public String displayCategories(Model model){
        model.addAttribute("categories", categoryStorage.findAllCategories());
        return "categoriesView";
    }

    @GetMapping("/categories/{categoryName}")
    public String displaySingleCategory(@PathVariable String categoryName, Model model){
        Category retrievedCategory = categoryStorage.findCategoryByName(categoryName);
        model.addAttribute("category", retrievedCategory);
        return "categoryView";
    }
}
