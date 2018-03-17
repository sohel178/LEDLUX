package com.android.sohel.ludlux;

/**
 * Created by user on 13/03/2018.
 */

public class OrderDetails {
    private int customerId;
    private int productId;
    private int mount;
    private int price;

    public OrderDetails() {
    }

    public OrderDetails(int customerId, int productId, int mount, int price) {
        this.customerId = customerId;
        this.productId = productId;
        this.mount = mount;
        this.price = price;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getMount() {
        return mount;
    }

    public void setMount(int mount) {
        this.mount = mount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "orderDetails{" +
                "customerId=" + customerId +
                ", productId=" + productId +
                ", mount=" + mount +
                ", price=" + price +
                '}';
    }
}