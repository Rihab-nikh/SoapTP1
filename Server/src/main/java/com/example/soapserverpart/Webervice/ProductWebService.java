package com.example.soapserverpart.Webervice;

import com.example.soapserverpart.Model.Product;
import com.example.soapserverpart.Model.Repository.ProductRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@WebService(name = "ProductWS")
@Component
@Service
public class ProductWebService {

    @Autowired
    private ProductRepository productRepository;

    @WebMethod
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @WebMethod
    public Optional<Product> getProductById(@WebParam(name = "id") Long id) {
        return productRepository.findById(id);
    }

    @WebMethod
    public void createProduct(@WebParam(name = "product") Product product) {
        productRepository.save(product);
    }

    @WebMethod
    public void updateProduct(@WebParam(name = "id") Long id, @WebParam(name = "product") Product product) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product updatedProduct = existingProduct.get();
            updatedProduct.setName(product.getName());
            updatedProduct.setPrice(product.getPrice());
            productRepository.save(updatedProduct);
        }
    }

    @WebMethod
    public void deleteProduct(@WebParam(name = "id") Long id) {
        productRepository.deleteById(id);
    }
}
