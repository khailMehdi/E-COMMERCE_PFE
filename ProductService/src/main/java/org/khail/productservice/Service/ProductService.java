package org.khail.productservice.Service;

import org.khail.productservice.Entitie.Category;
import org.khail.productservice.Entitie.Product;
import org.khail.productservice.Exception.ProductNotExist;

import java.util.List;

public interface ProductService {
     List<Product> getProducts();
     Product getProduct(int id) throws ProductNotExist;
     Product addProduct(Product product);
     Product updateProduct(Product product) throws ProductNotExist;
     void deleteProduct(int id) throws ProductNotExist;
    //Catgory
     List<Category> getCategorys();
     Category addCategory(Category category);
     Category updateCategory(Category category) ;

}
