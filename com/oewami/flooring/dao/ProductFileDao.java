package com.oewami.flooring.dao;

import com.oewami.flooring.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductFileDao {

    Product unmarshallItem(String line);
    String marshallItem(Product product);
    void writeFile(List<Product> products);
    Map<String,Product> readFile(String file);

}


