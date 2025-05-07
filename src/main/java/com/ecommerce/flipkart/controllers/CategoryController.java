package com.ecommerce.flipkart.controllers;


import com.ecommerce.flipkart.config.AppConstants;
import com.ecommerce.flipkart.models.Category;
import com.ecommerce.flipkart.payload.CategoryDTO;
import com.ecommerce.flipkart.payload.CategoryResponse;
import com.ecommerce.flipkart.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryService categoryService;
    @GetMapping("/public/categories")
    public ResponseEntity<CategoryResponse> getAllCategories(@RequestParam (name = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
                                                       @RequestParam (name = "pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false) Integer pageSize,
                                                       @RequestParam (name = "sortBy",defaultValue = AppConstants.SORT_CATEGORIES_BY,required = false)String sortBy,
                                                       @RequestParam (name = "sortOrder",defaultValue = AppConstants.SORT_DIR,required = false) String sortOrder) {
        CategoryResponse categoryResponse = categoryService.getAllUser(pageNumber, pageSize, sortBy, sortOrder);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);

    }
    @PostMapping("/admin/createCategory")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        CategoryDTO savedCategory = categoryService.saveCategory(categoryDTO);
        return new ResponseEntity<>(savedCategory,HttpStatus.CREATED);
    }
    @DeleteMapping("/admin/category/{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId){
        CategoryDTO deletedCategory=categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(deletedCategory,HttpStatus.OK);
    }
    @PutMapping("/admin/updateCategory/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,@PathVariable Long categoryId){
        CategoryDTO updatedCategory = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(updatedCategory,HttpStatus.OK);
    }
}
