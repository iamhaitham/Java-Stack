package com.codingdojo.ProductsAndCategories.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.ProductsAndCategories.models.Category;
import com.codingdojo.ProductsAndCategories.models.Product;
import com.codingdojo.ProductsAndCategories.services.CategoryService;
import com.codingdojo.ProductsAndCategories.services.ProductService;

@Controller
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;
	public ProductController(ProductService productService,CategoryService categoryService) {
	this.productService=productService;
	this.categoryService=categoryService;
}
	
	@RequestMapping("/products/new")
	public String indexProduct(@ModelAttribute(value="product") Product product) {
		return "indexProduct.jsp";
	}
	
	@RequestMapping(value="/products/newProcessing",method=RequestMethod.POST)
	public String processingProduct(@ModelAttribute(value="product") Product product) {
		productService.createProduct(product);
		return "redirect:/products/new";
	}
	
	@RequestMapping("/products/{id}")
	public String infoProduct(@PathVariable(value="id")Long id,@ModelAttribute(value="addCategories") Product product,Model model) {
		Product myProduct=productService.findProduct(id);
		model.addAttribute("myProduct",myProduct);
		
		List<Category> distinctCategories=categoryService.distinctCategories(myProduct);
		model.addAttribute("remainingCategories",distinctCategories);
		
		return "infoProduct.jsp";
	}
	
	@RequestMapping(value="/products/{id}/addCategory",method=RequestMethod.POST)
	public String newProductProcessing(@PathVariable(value="id") Long id,@RequestParam(value="options")Long categoryId,@ModelAttribute(value="addCategories") Product product,Model model) {
		Product myProduct=productService.findProduct(id);
		Category myCategory=categoryService.findCategory(categoryId);
		productService.updateProduct(myProduct,myCategory); 
		return "redirect:/products/"+id;
	}
}
