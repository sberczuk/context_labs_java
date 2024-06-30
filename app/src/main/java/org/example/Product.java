package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {

    // I'm  not entirely user about the unparameterized type use here.
    // but it seems better than just using an Object or having the values all be Objects
    Map<String, ProductAttribute> attributes = new HashMap<>();
    public Product(List<ProductAttribute> p) {
        for (ProductAttribute pa : p) {
            this.addAttribute(pa);
        }
    }

    public void addAttribute(ProductAttribute attrib) {
        attributes.put(attrib.GetName(), attrib);
    }

    public ProductAttribute getAttribute(String key) {
        return attributes.get(key);
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for (Map.Entry<String, ProductAttribute> entry : attributes.entrySet()) {
            str.append(entry.getValue().asString());
        }
        return String.format("Product with Attributes:\n%s\n\n", str);
    }


}
