package org.example;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product("Brot", new BigDecimal("1.50"));
        Product product2 = new Product("Milch", new BigDecimal("1.00"));
        List<Product> products = List.of(product1, product2);
        Shelf shelf = new Shelf(products);
        Optional<Product> optionalProduct = shelf.getProductByName("Milch");
        optionalProduct.orElseThrow(() -> new NoSuchElementException("Product with name: Milch not found!"));

        optionalProduct.ifPresentOrElse(product -> {
                    System.out.println(product.price());
                },
                () -> {
                    throw new NoSuchElementException("Product with name: Milch not found!");
                });

    }
}