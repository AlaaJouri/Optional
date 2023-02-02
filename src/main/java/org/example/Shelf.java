package org.example;


import java.util.List;
import java.util.Optional;

public class Shelf {
   private List<Product> productlist;

   public Shelf(List<Product> productlist) {
       this.productlist = productlist;
   }

    public List<Product> getProductlist() {
        return productlist;
    }

    public Optional<Product> getProductByName(String name) {
        for (Product product:productlist) {
            if (product.name().equals(name)) {
                return Optional.ofNullable(product);
            }
        }
        return Optional.empty();
    }
}
