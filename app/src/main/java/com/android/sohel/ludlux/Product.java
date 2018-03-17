package com.android.sohel.ludlux;

import android.widget.ImageView;

/**
 * Created by user on 13/03/2018.
 */

public class Product {
    private int productId;
    private String name;
    private int price;
    private int quantity;
    private ImageView image;

    public Product() {
    }

    public Product(int productId, String name, int price, int quantity, ImageView image) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", image=" + image +
                '}';
    }
}