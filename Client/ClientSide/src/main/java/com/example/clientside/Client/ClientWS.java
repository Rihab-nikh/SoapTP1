package com.example.clientside.Client;

import Proxy.GetAllProductsResponse;
import Proxy.Product;
import Proxy.ProductWS;
import Proxy.ProductWebServiceService;

import java.util.List;

public class ClientWS {
    public static void main(String[] args) {
        ProductWebServiceService service = new ProductWebServiceService();

        ProductWS productService = service.getProductWSPort();

        List<Product> products = productService.getAllProducts();

        if (products != null && !products.isEmpty()) {
            for (Product product : products) {
                System.out.println("Product ID: " + product.getId());
                System.out.println("Product Name: " + product.getName());
                System.out.println("Product Price: " + product.getPrice());
            }
        } else {
            System.out.println("No products found.");
        }
    }
}
