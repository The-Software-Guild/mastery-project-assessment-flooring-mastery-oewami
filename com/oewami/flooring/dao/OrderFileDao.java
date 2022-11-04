package com.oewami.flooring.dao;

import com.oewami.flooring.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderFileDao {

    Order unmarshallItem(String line);
    String marshallItem(Order order);
    void writeFile(List<Order> orders);
    Map<String,Order> readFile(String file);

}
