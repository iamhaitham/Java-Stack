package com.codingdojo.ProductsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ProductsAndCategories.models.Category;
import com.codingdojo.ProductsAndCategories.models.Product;
import com.codingdojo.ProductsAndCategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository=categoryRepository;
	}
	
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
    
    public List<Category> distinctCategories(Product myProduct){
    	return categoryRepository.findByProductsNotContaining(myProduct);
    }
    
    public Category updateCategory(Category myCategory,Product myProduct) {
    	List<Product> allProducts =myCategory.getProducts();
    	allProducts.add(myProduct);
    	return categoryRepository.save(myCategory);
    }
}
