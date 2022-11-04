package com.oewami.flooring.dao;

import com.oewami.flooring.model.Order;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderFileDaoImpl implements OrderFileDao {

    private final String DELIMITER = ",";
    private final String ORDER_FILE;

    public OrderFileDaoImpl() { ORDER_FILE = "Orders.txt"; }

    public OrderFileDaoImpl(String file) { ORDER_FILE = file; }

    @Override
    public Order unmarshallItem(String line) {
        String[] details = line.split(DELIMITER);
        Order order = new Order();
        order.setOrderNumber(Integer.parseInt(details[0]));
        order.setCustomerName(details[1]);
        order.setState(details[2]);
        order.setTaxRate(new BigDecimal(details[3]));
        order.setProductType(details[4]);
        order.setArea(new BigDecimal(details[5]));
        order.setCostPerSquareFoot(new BigDecimal(details[6]));
        order.setLaborCostPerSquareFoot(new BigDecimal(details[7]));
        order.setMaterialCost(new BigDecimal(details[8]));
        order.setLaborCost(new BigDecimal(details[9]));
        order.setTax(new BigDecimal(details[10]));
        order.setTotal(new BigDecimal(details[11]));
        return order;
    }

    @Override
    public String marshallItem(Order order) {
        StringBuilder builder = new StringBuilder();
        builder.append(order.getOrderNumber() + DELIMITER);
        builder.append(order.getCustomerName() + DELIMITER);
        builder.append(order.getState() + DELIMITER);
        builder.append(order.getTaxRate() + DELIMITER);
        builder.append(order.getProductType() + DELIMITER);
        builder.append(order.getArea() + DELIMITER);
        builder.append(order.getCostPerSquareFoot() + DELIMITER);
        builder.append(order.getLaborCostPerSquareFoot() + DELIMITER);
        builder.append(order.getMaterialCost() + DELIMITER);
        builder.append(order.getLaborCost() + DELIMITER);
        builder.append(order.getTax() + DELIMITER);
        builder.append(order.getTotal());
        builder.append(System.lineSeparator());
        return builder.toString();
    }

    @Override
    public void writeFile(List<Order> orders) {
        StringBuilder builder = new StringBuilder();
        for(Order order : orders) {
            builder.append(marshallItem(order));
        }
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(ORDER_FILE));
            writer.write(builder.toString());
            writer.close();
        } catch(IOException e) {
            System.out.println("COULD NOT WRITE TO FILE");
        }
    }

    @Override
    public Map<String, Order> readFile(String file) {
        String line;
        Map<String, Order> orders = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {
                Order order = unmarshallItem(line);
                orders.put(order.getCustomerName(), order);
            }
        } catch(IOException e) {
            System.out.println("COULD NOT READ FILE");
        }
        return orders;
    }
}
