package org.taishan.electronshop.domain;

public class OrderItem {

    private int id;
    private Goods goods; // 哪个商品
    private double price; // 当时什么价格
    private int number; // 买了多少个
    private Order order; // 这个订单项属于哪个订单

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}