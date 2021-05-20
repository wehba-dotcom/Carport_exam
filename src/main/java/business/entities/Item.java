package business.entities;

public class Item {
    int item_id;
    String name;
    String info;
    double price;

    public Item(int item_id, String name, String info, double price) {
        this.item_id = item_id;
        this.name = name;
        this.info = info;
        this.price = price;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
