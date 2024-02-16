package com.hindusthan.Product.Controller;

import com.hindusthan.Product.Advisor.SaveException;
import com.hindusthan.Product.Product.Product;
import com.hindusthan.Product.Service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllUsers() {
        return productService.getAllProducts();
    }
    @PostMapping()
    public Product addProduct(@RequestBody Product product) throws SaveException {
        log.info("you are about to save the product");
        return productService.saveProduct(product);
    }
@GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) throws Exception{
        return productService.getProductById(id);
}
@DeleteMapping("/{id}")
    public void DeleteProductById(@PathVariable Long id ) throws Exception{
        productService.deleteProductById(id);
}
@PutMapping("/{id}")
    public Product updateProductById(@RequestBody Product product,@PathVariable Long id) throws Exception{

    product.setId(id);
    return productService.updateProductById(product);
}
}
