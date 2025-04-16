package com.ecommerce.flipkart.service;

import com.ecommerce.flipkart.models.Category;
import com.ecommerce.flipkart.models.User;
import com.ecommerce.flipkart.payload.CategoryDTO;
import com.ecommerce.flipkart.payload.CategoryResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

     CategoryResponse getAllUser(Integer pageNumber,Integer pageSize,String sortBy,String sortOrder);

     CategoryDTO saveCategory(CategoryDTO categoryDTO);

     CategoryDTO deleteCategory(Long categoryId);

     CategoryDTO updateCategory(@Valid CategoryDTO categoryDTO, Long categoryId);
}
