package com.oewami.flooring.model;

import java.math.BigDecimal;

public class Order {
    /**
     * OrderNumber – Integer
     * CustomerName – String
     * State – String
     * TaxRate – BigDecimal
     * ProductType – String
     * Area – BigDecimal
     * CostPerSquareFoot – BigDecimal
     * LaborCostPerSquareFoot – BigDecimal
     * MaterialCost – BigDecimal
     * LaborCost – BigDecimal
     * Tax – BigDecimal
     * Total – BigDecimal
     */

    private int orderNumber;
    private String customerName;
    private String state;
    private BigDecimal taxRate;
    private String productType;
    private BigDecimal area;
    private BigDecimal costPerSquareFoot;
    private BigDecimal laborCostPerSquareFoot;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal tax;
    private BigDecimal total;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    //     * Tax rates are stored as whole numbers
    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public void setCostPerSquareFoot(BigDecimal costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    //     * LaborCost = (Area * LaborCostPerSquareFoot)
    public void setLaborCostPerSquareFoot(BigDecimal laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    //     * MaterialCost = (Area * CostPerSquareFoot)
    public void setMaterialCost(BigDecimal materialCost) {
//        this.materialCost = area.multiply(costPerSquareFoot);
        this.materialCost = materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getTax() {
        return tax;
    }

    //     * Tax = (MaterialCost + LaborCost) * (TaxRate/100)
    public void setTax(BigDecimal tax) {
//        this.tax = (materialCost.add(laborCost)).multiply(taxRate.divide(new BigDecimal("100")));
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    //     * Total = (MaterialCost + LaborCost + Tax)
    public void setTotal(BigDecimal total) {
//        total = materialCost.add(laborCost).add(tax);
        this.total = total;
    }
}
