package org.khail.productservice;

import org.khail.productservice.Entitie.Category;
import org.khail.productservice.Entitie.Product;
import org.khail.productservice.Repository.CategoryRepository;
import org.khail.productservice.Repository.ProductRepository;
import org.khail.productservice.Service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
   @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository , CategoryRepository categoryRepository) {
        return args -> {
            Category category = new Category();
            category.setId(1);
            category.setName("Smartphones");
            category.setDescription("smart");

            categoryRepository.save(category);

            Product product = new Product();
            product.setId(1);
            product.setName("iphone");
            product.setDescription("iphone 16pro");
            product.setPrice(BigDecimal.valueOf(2000));

            product.setCategory(category);
            productRepository.save(product);

        } ;
   }
}
