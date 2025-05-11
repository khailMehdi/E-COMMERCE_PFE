package org.khail.productservice.Service;

import jakarta.transaction.Transactional;
import org.khail.productservice.Entitie.Category;
import org.khail.productservice.Entitie.Product;
import org.khail.productservice.Exception.ProductNotExist;
import org.khail.productservice.Repository.CategoryRepository;
import org.khail.productservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }



    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(int id)
            throws ProductNotExist {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotExist("Product with ID " + id + " does not exist"));
    }

    @Override
    public Product addProduct(Product product) {
        System.out.println(product.toString());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) throws ProductNotExist {
        if (!productRepository.existsById(product.getId())) {
            throw new ProductNotExist("Cannot update: Product with ID " + product.getId() + " does not exist");
        }
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id)
            throws ProductNotExist {
     productRepository.deleteById(id);
    }

    @Override
    public List<Category> getCategorys() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }
}
