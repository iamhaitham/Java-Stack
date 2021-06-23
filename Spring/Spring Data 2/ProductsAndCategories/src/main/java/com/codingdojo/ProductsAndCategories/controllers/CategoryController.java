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
public class CategoryController {
	private final CategoryService categoryService;
	private final ProductService productService;
	public CategoryController(CategoryService categoryService,ProductService productService) {
		this.categoryService=categoryService;
		this.productService=productService;
	}
	
	@RequestMapping("/categories/new")
	public String indexCategory(@ModelAttribute(value="category") Category category) {
		return "indexCategory.jsp";
	}
	
	@RequestMapping(value="/categories/newProcessing",method=RequestMethod.POST)
	public String processingCategory(@ModelAttribute(value="category") Category category) {
		categoryService.createCategory(category);
		return "redirect:/categories/new";
	}
	
	@RequestMapping("/categories/{id}")
	public String infoCategory(@ModelAttribute(value="addProducts") Category category,@PathVariable(value="id")Long id,Model model) {
		Category myCategory=categoryService.findCategory(id);
		model.addAttribute("myCategory",myCategory);
		
		List<Product> distinctProducts=productService.distinctProducts(myCategory);
		model.addAttribute("distinctProducts",distinctProducts);
		
		return "infoCategory.jsp";
	}
	
	@RequestMapping(value="/categories/{id}/addProducts",method=RequestMethod.POST)
	public String newProductProcessing(Model model,@ModelAttribute(value="addProducts") Category category,@PathVariable("id")Long id,@RequestParam(value="options") Long productId) {
		Product myProduct=productService.findProduct(productId);
		Category myCategory=categoryService.findCategory(id);
		categoryService.updateCategory(myCategory,myProduct);
		return "redirect:/categories/"+id;
	}
}
