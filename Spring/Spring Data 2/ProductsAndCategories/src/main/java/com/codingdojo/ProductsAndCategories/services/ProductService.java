package com.codingdojo.ProductsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ProductsAndCategories.models.Category;
import com.codingdojo.ProductsAndCategories.models.Product;
import com.codingdojo.ProductsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	public ProductService(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	
    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }
    
    public Product updateProduct(Product myProduct,Category myCategory) {
    	List<Category> allCategories=myProduct.getCategories();
    	allCategories.add(myCategory);
    	return productRepository.save(myProduct);
    }
    
    public List<Product> distinctProducts(Category myCategory){
    	return productRepository.findByCategoriesNotContaining(myCategory);
    }
    
}
