package org.khail.productservice.Web;

import org.khail.productservice.Entitie.Category;
import org.khail.productservice.Entitie.Product;
import org.khail.productservice.Exception.ProductNotExist;
import org.khail.productservice.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductWeb {
    private final ProductService productService;


    public ProductWeb(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
       return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id)
            throws ProductNotExist {
        return productService.getProduct(id);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/products{id}")
    public Product updateProduct(@PathVariable int id ,@RequestBody Product product)
            throws ProductNotExist {
        return productService.updateProduct(product);
    }

    @GetMapping("/category")
    public List<Category> getCategory(){
        return productService.getCategorys();
    }

    @PostMapping("/category")
    public Category addCategory(@RequestBody Category category){
        return productService.addCategory(category);
    }

    @PutMapping("/category")
    public Category updateCategory(@RequestBody Category category){
        return productService.updateCategory(category);
    }

}
