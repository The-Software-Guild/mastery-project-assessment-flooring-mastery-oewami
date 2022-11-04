package com.oewami.flooring.dao;

import com.oewami.flooring.model.Product;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductFileDaoImpl implements ProductFileDao {

    private final String DELIMITER = ",";
    private final String PRODUCT_FILE;

    public ProductFileDaoImpl() { PRODUCT_FILE = "Products.txt"; }

    public ProductFileDaoImpl(String file) { PRODUCT_FILE = file; }

    @Override
    public Product unmarshallItem(String line) {
        String[] details = line.split(DELIMITER);
        Product product = new Product();
        product.setProductType(details[0]);
        product.setCostPerSquareFoot(new BigDecimal(details[1]));
        product.setLaborCostPerSquareFoot(new BigDecimal(details[2]));
        return product;
    }

    @Override
    public String marshallItem(Product product) {
        StringBuilder builder = new StringBuilder();
        builder.append(product.getProductType() + DELIMITER);
        builder.append(product.getCostPerSquareFoot() + DELIMITER);
        builder.append(product.getLaborCostPerSquareFoot());
        builder.append(System.lineSeparator());
        return builder.toString();
    }

    @Override
    public void writeFile(List<Product> products) {
        StringBuilder builder = new StringBuilder();
        for(Product product : products) {
            builder.append(marshallItem(product));
        }
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(PRODUCT_FILE));
            writer.write(builder.toString());
            writer.close();
        } catch(IOException e) {
            System.out.println("COULD NOT WRITE TO FILE");
        }

    }

    @Override
    public Map<String, Product> readFile(String file) {
        String line;
        Map<String, Product> products = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {
                Product product = unmarshallItem(line);
                products.put(product.getProductType(), product);
            }
        } catch(IOException e) {
            System.out.println("COULD NOT READ FILE");
        }
        return products;
    }
}
