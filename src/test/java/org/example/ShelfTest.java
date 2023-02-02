package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


class ShelfTest {


    @Test
    void getProductByName_whenProductExists_thenOptionalWithProduct() {
        //GIVEN
        Shelf shelf = new Shelf(List.of(new Product("testProduct", new BigDecimal("1.5"))));

        //WHEN
        Optional<Product> optionalProduct = shelf.getProductByName("testProduct");

        //THEN
        Assertions.assertTrue(optionalProduct.isPresent());
        Assertions.assertEquals(new Product("testProduct", new BigDecimal("1.5")), optionalProduct.get());
    }

    @Test
    void getProductByName_whenProductNotExists_thenEmptyOptional() {
        //GIVEN
        Shelf shelf = new Shelf(List.of(new Product("testProduct", new BigDecimal("1.5"))));

        //WHEN
        Optional<Product> optionalProduct = shelf.getProductByName("notFound");

        //THEN
        Assertions.assertTrue(optionalProduct.isEmpty());
    }
}