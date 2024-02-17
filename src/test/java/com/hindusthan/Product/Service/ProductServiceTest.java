package com.hindusthan.Product.Service;

import com.hindusthan.Product.Advisor.DeleteException;
import com.hindusthan.Product.Advisor.FindException;
import com.hindusthan.Product.Advisor.SaveException;
import com.hindusthan.Product.Advisor.UpdateException;
import com.hindusthan.Product.Product.Product;
import com.hindusthan.Product.Repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;

    @ParameterizedTest
    @ValueSource(longs={1l,2l,3l,4l,5l,6l,9l})
    void testWhenProductIdIsExist(long input) throws FindException {
        Mockito.when(productRepository.existsById(any())).thenReturn(true);
        productService.getProductById(input);

    }

    @Test
    void testWhenProductIdExistThenGetProduct() throws FindException {
        Product product = new Product();
        product.setName("samsung");
        product.setDescription("mobiles");
        product.setQuantity(3.00);

        Mockito.when(productRepository.existsById(any())).thenReturn(true);
        Mockito.when(productRepository.findById(any())).thenReturn(Optional.of(product));
        Optional actualOutput = productService.getProductById(any());
        Assertions.assertEquals(product, actualOutput.get());
    }

    @Test
    void testWhenProductIdNotExistsThenThrowFindException() {
        Mockito.when(productRepository.existsById(any())).thenReturn(false);
        assertThrows(FindException.class, () -> {
                    productService.getProductById((any()));
                }
        );
    }

    @Test
    void testWhenProductIdExistsThenDeleteProduct() throws DeleteException {
        Mockito.when(productRepository.existsById(any())).thenReturn(true);

        productService.deleteProductById(2l);
        Mockito.verify(productRepository, Mockito.atMost(1)).deleteById(any());
    }

    @Test
    void testWhenProductIdDoesNotExistsThenThrowDeleteException() throws DeleteException {
        Mockito.when(productRepository.existsById(any())).thenReturn(false);
        assertThrows(DeleteException.class, () ->
                productService.deleteProductById(any()));

    }




    @Test
    void testProductIdExistsUpdateProduct() {
        Product product = new Product();
        product.setName("samsung");
        product.setDescription("mobiles");
        product.setQuantity(3.00);
//        Mockito.when(productRepository.existsById(any())).thenReturn(true);
        Mockito.when(productRepository.save(product)).thenReturn(product);
        Product actualOutput = productRepository.save(product);
        Assertions.assertEquals(actualOutput, product);
    }
    @Test
    void testWhenProductIdExistThrowUpdateException(){
        Product product = new Product();
        product.setId(6l);
        product.setName("Cona");
        product.setDescription("Switches");
        product.setQuantity(100.00);
        Mockito.when(productRepository.existsById(any())).thenReturn(false);
        assertThrows(UpdateException.class,()->{
            productService.updateProductById(product);
        });

    }

    @Test
    void testCreateProduct() throws SaveException {
        Product product = new Product();
        product.setName("samsung");
        product.setDescription("mobiles");
        product.setQuantity(3.00);
        Mockito.when(productRepository.save(any(Product.class))).thenReturn(product);
        Product actualProduct = productRepository.save(product);
        Assertions.assertEquals(product, actualProduct);
    }

}