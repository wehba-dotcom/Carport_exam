package business.entities;

public class Order {
    int user_id;
    double price;
    int order_id;
    double length;
    double width;


    public Order( int user_id, double price, double length, double width) {
        this.user_id = user_id;
        this.price = price;
        this.length = length;
        this.width = width;
    }

    public Order(int order_id, int user_id, double price, double length, double width) {
        this.order_id= order_id;
        this.user_id = user_id;
        this.price = price;
        this.length = length;
        this.width = width;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
