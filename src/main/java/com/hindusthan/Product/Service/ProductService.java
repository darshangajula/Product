package com.hindusthan.Product.Service;

import com.hindusthan.Product.Advisor.DeleteException;
import com.hindusthan.Product.Advisor.FindException;
import com.hindusthan.Product.Advisor.SaveException;
import com.hindusthan.Product.Advisor.UpdateException;
import com.hindusthan.Product.Product.Product;
import com.hindusthan.Product.Repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) throws SaveException{
        if(!productRepository.existsById((long) product.getId())){
            throw new SaveException("An error occurred during save operation");
        }
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(Long id) throws FindException {
        if (!productRepository.existsById(id)) {
            throw new FindException("enter the Existing id to Find");
        }
        return productRepository.findById(id);
    }

    public void deleteProductById(Long id) throws DeleteException {
        if (!productRepository.existsById(id)) {
            throw new DeleteException(" an id should be present to delete ");
        }
        productRepository.deleteById(id);
        log.info("your product with " + id + " is deleted");
    }

    public Product updateProductById(Product product) throws UpdateException {
        if (!productRepository.existsById((long) product.getId())) {
            throw new UpdateException("Product id not found to update");
        }
        return productRepository.save(product);
    }

}
